package de.urszeidler.shr5.ecp.editor.pages;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EValidator.SubstitutionLabelProvider;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.wb.swt.ResourceManager;

import de.urszeidler.eclipse.shr5.AbstraktPersona;
import de.urszeidler.eclipse.shr5.Spezies;
import de.urszeidler.eclipse.shr5.util.AdapterFactoryUtil;
import de.urszeidler.eclipse.shr5.util.ShadowrunTools;
import de.urszeidler.eclipse.shr5Management.CharacterGenerator;
import de.urszeidler.eclipse.shr5Management.GeneratorState;
import de.urszeidler.eclipse.shr5Management.LifestyleToStartMoney;
import de.urszeidler.eclipse.shr5Management.ManagedCharacter;
import de.urszeidler.eclipse.shr5Management.Shr5KarmaGenerator;
import de.urszeidler.eclipse.shr5Management.Shr5managementFactory;
import de.urszeidler.eclipse.shr5Management.Shr5managementPackage;
import de.urszeidler.emf.commons.ui.util.EmfFormBuilder.ReferenceManager;
import de.urszeidler.shr5.ecp.Activator;
import de.urszeidler.shr5.ecp.printer.PersonaPrinter;
import de.urszeidler.shr5.ecp.service.ValidationService;
import de.urszeidler.shr5.gameplay.dice.IniDice;

/**
 * The basic page for the generators.
 * 
 * @author urs
 */
public abstract class AbstractGeneratorPage extends AbstractShr5Page<CharacterGenerator> implements Adapter {

    public static final String PERSONA_PRINTER = "persona.printer"; //$NON-NLS-1$
    public static final String PERSONA_ADVANCEMENT = "persona.advancement"; //$NON-NLS-1$
    public static final String PERSONA_INVENTAR = "persona.inventar"; //$NON-NLS-1$
    public static final String PERSONA = "persona"; //$NON-NLS-1$

    /**
     * Provides the lables for the validation chain.
     */
    public class ValidationLabelProvider implements SubstitutionLabelProvider {

        /*
         * (non-Javadoc)
         * @see org.eclipse.emf.ecore.EValidator.SubstitutionLabelProvider#getObjectLabel(org.eclipse.emf.ecore.EObject)
         */
        @Override
        public String getObjectLabel(EObject eObject) {
            return AdapterFactoryUtil.getInstance().getLabelProvider().getText(eObject);
        }

        /*
         * (non-Javadoc)
         * @see org.eclipse.emf.ecore.EValidator.SubstitutionLabelProvider#getFeatureLabel(org.eclipse.emf.ecore.EStructuralFeature)
         */
        @Override
        public String getFeatureLabel(EStructuralFeature eStructuralFeature) {
            return AdapterFactoryUtil.getInstance().getLabelProvider().getText(eStructuralFeature);
        }

        /*
         * (non-Javadoc)
         * @see org.eclipse.emf.ecore.EValidator.SubstitutionLabelProvider#getValueLabel(org.eclipse.emf.ecore.EDataType, java.lang.Object)
         */
        @Override
        public String getValueLabel(EDataType eDataType, Object value) {
            return AdapterFactoryUtil.getInstance().getLabelProvider().getText(value);
        }
    }

    private Image decoratorImage = ResourceManager.getPluginImage("de.urszeidler.shr5.ecp", "images/stcksync_ov.gif"); //$NON-NLS-1$ //$NON-NLS-2$
    protected Map<Object, Object> context;
    protected ValidationService validationService;
    protected IPreferenceStore store;

    public AbstractGeneratorPage(String id, String title) {
        super(id, title);
    }

    public AbstractGeneratorPage(FormEditor editor, String id, String title) {
        super(editor, id, title);
    }

    public AbstractGeneratorPage(FormEditor editor, String id, String title, ReferenceManager manager) {
        super(editor, id, title, manager);
    }

    /**
     * Update the given decorator with the given text when the feature is in the set.
     * 
     * @param newSet
     * @param featureID
     * @param decoration
     * @param textToShow
     */
    protected void updateDecorator(Set<Integer> newSet, Object featureID, ControlDecoration decoration, String textToShow) {
        if (newSet.contains(featureID)) {
            decoration.setDescriptionText(textToShow);
            decoration.setImage(decoratorImage);
            decoration.setShowHover(true);
            // decoration.showHoverText(textToShow);
        } else if (decoration.getImage() != null) {
            decoration.setDescriptionText(""); //$NON-NLS-1$
            decoration.setImage(null);
        }
    }

    /**
     * Creates the validation context.
     * 
     * @return
     */
    protected Map<Object, Object> createValidationContext() {
        Map<Object, Object> context = new HashMap<Object, Object>();
        context.put(SubstitutionLabelProvider.class, new ValidationLabelProvider());
        return context;
    }

    /**
     * Validates the changes and update the gui.
     */
    protected abstract void validateChange();

    public Notifier getTarget() {
        return null;
    }

    public boolean isAdapterForType(Object type) {
        return false;
    }

    /**
     * Handles the events from the generator.
     */
    public void notifyChanged(Notification notification) {
        Object feature = notification.getFeature();
        if (feature == null)
            return;
        if (Shr5managementPackage.Literals.CHARACTER_GENERATOR__STATE.equals(feature))
            return;
        if (Shr5managementPackage.Literals.CHARACTER_GENERATOR__CURRENT_INSTRUCTION.equals(feature))
            return;
        if (!notificationIsRequierd(notification))
            return;

        validateChange();
    }

    protected abstract boolean notificationIsRequierd(Notification notification);

    @Override
    public void setTarget(Notifier newTarget) {

    }

    @Override
    public void initialize(FormEditor editor) {
        super.initialize(editor);
        validationService = (ValidationService)editor.getSite().getService(ValidationService.class);
        store = Activator.getDefault().getPreferenceStore();
    }

    /**
     * Create the managed character.
     * 
     * @param selectableType the type of the persona
     * @param spezies the spezies to set to the persona
     * @param createPlayer thre for a player character
     * @param object the generator
     * @return
     */
    protected ManagedCharacter createManagedCharacter(EClass selectableType, Spezies spezies, boolean createPlayer, CharacterGenerator object) {
        ManagedCharacter playerCharacter;
        if (createPlayer)
            playerCharacter = Shr5managementFactory.eINSTANCE.createPlayerCharacter();
        else
            playerCharacter = Shr5managementFactory.eINSTANCE.createNonPlayerCharacter();

        int edge = 0;// metaType.getSpecialPoints();

        AbstraktPersona persona = ShadowrunTools.createPersona(spezies, selectableType, edge);
        playerCharacter.setPersona(persona);
        persona.setName(object.getCharacterName());

        object.setState(GeneratorState.PERSONA_CREATED);
        object.getSelectedGroup().getMembers().add(playerCharacter);
        object.setCharacter(playerCharacter);
        return playerCharacter;
    }

    /**
     * Clears the character from the generator.
     */
    protected void resetCharacter(CharacterGenerator object) {
        boolean openConfirm = MessageDialog.openConfirm(getSite().getShell(), Messages.AbstractGeneratorPage_dlg_reset_titel,
                Messages.AbstractGeneratorPage_dlg_reset_message);

        if (!openConfirm)
            return;

        if (object.getSelectedGroup() != null)
            object.getSelectedGroup().getMembers().remove(object.getCharacter());

        ManagedCharacter character = object.getCharacter();
        if (character != null)
            character.setChracterSource(null);

        object.setCharacter(null);
        object.setState(GeneratorState.NEW);
        removePages();
        validateChange();
    }

    protected void addPersonaPage(ManagedCharacter playerCharacter) {
        try {
            removePages();

            CharacterGenerator chracterSource = playerCharacter.getChracterSource();
            if (chracterSource instanceof Shr5KarmaGenerator) {
                this.getEditor().addPage(
                        1,
                        new AbstraktPersonaPage(this.getEditor(), PERSONA, Messages.ShadowrunEditor_page_persona, playerCharacter,
                                getEditingDomain(), mananger));
            } else {
                this.getEditor().addPage(
                        1,
                        new AbstraktPersonaPage(this.getEditor(), PERSONA, Messages.ShadowrunEditor_page_persona, playerCharacter.getPersona(),
                                getEditingDomain(), mananger));
            }
            this.getEditor().addPage(
                    2,
                    new ManagedCharacterPage(this.getEditor(), PERSONA_INVENTAR, Messages.ShadowrunEditor_page_character, playerCharacter,
                            getEditingDomain(), mananger));

            this.getEditor().addPage(
                    3,
                    new CharacterAdvancementPage(this.getEditor(), PERSONA_ADVANCEMENT, Messages.ShadowrunEditor_page_advacement, playerCharacter,
                            getEditingDomain(), mananger));

            this.getEditor().addPage(
                    4,
                    new PrintPreviewPage(this.getEditor(), PERSONA_PRINTER, Messages.ShadowrunEditor_page_character_sheet, PersonaPrinter
                            .getInstance().createPrintFactory(playerCharacter)));

        } catch (PartInitException e1) {
            e1.printStackTrace();
        };
    }

    /**
     * 
     */
    private void removePages() {
        if (this.getEditor().findPage(PERSONA_PRINTER) != null)
            this.getEditor().removePage(4);
        if (this.getEditor().findPage(PERSONA_ADVANCEMENT) != null)
            this.getEditor().removePage(3);
        if (this.getEditor().findPage(PERSONA_INVENTAR) != null)
            this.getEditor().removePage(2);
        if (this.getEditor().findPage(PERSONA) != null)
            this.getEditor().removePage(1);
    }

    protected void updateGeneratorState(Diagnostic diagnostic, CharacterGenerator generator) {
        if (EObjectValidator.DIAGNOSTIC_SOURCE.equals(diagnostic.getSource())) {
            if (diagnostic.getCode() == EObjectValidator.EOBJECT__EVERY_MULTIPCITY_CONFORMS) {
                Object object2 = diagnostic.getData().get(1);
                if (Shr5managementPackage.Literals.CHARACTER_GENERATOR__SELECTED_GROUP.equals(object2)) {
                    generator.setState(GeneratorState.NEW);
                } else if (Shr5managementPackage.Literals.CHARACTER_GENERATOR__CHARACTER.equals(object2))
                    generator.setState(GeneratorState.READY_FOR_CREATION);
            }
        }
    }

    /**
     * Creates the lifestyle to money dialog.
     * 
     * @param calcResourcesLeft
     * @param lifestyleToMoney
     * @return
     */
    protected InputDialog createLifestyle2MoneyDialog(final int calcResourcesLeft, LifestyleToStartMoney lifestyleToMoney) {
        final int numberOfW = lifestyleToMoney.getNumberOfW();
        final int moneyFactor = lifestyleToMoney.getMoneyFactor();

        IniDice iniDice = new IniDice();
        int ini = iniDice.ini(0, numberOfW);
        int money = moneyFactor * ini;
        int m = money + calcResourcesLeft;

        String dialogMessage = String.format(Messages.AbstractGeneratorPage_dlg_lifestyle_message, numberOfW, moneyFactor, calcResourcesLeft);
        IInputValidator validator = new IInputValidator() {
            @Override
            public String isValid(String newText) {
                try {
                    int max = calcResourcesLeft + (6 * numberOfW * moneyFactor);
                    int value = Integer.parseInt(newText);
                    if (value > max)
                        return String.format(Messages.AbstractGeneratorPage_dlg_lifestyle_to_much, value, max);
                    if (value < 0)
                        return Messages.AbstractGeneratorPage_dlg_lifestyle_less;

                } catch (Exception e) {
                    return String.format(Messages.AbstractGeneratorPage_dlg_lifestyle_no_number, newText);
                }
                return null;
            }
        };
        InputDialog inputDialog = new InputDialog(getSite().getShell(), Messages.AbstractGeneratorPage_dlg_lifestyle_titel, dialogMessage,
                m + "", validator); //$NON-NLS-1$
        return inputDialog;
    }

    protected boolean openDefaultCommitMessageDialog() {
        boolean openConfirm = MessageDialog.openConfirm(getSite().getShell(), Messages.AbstractGeneratorPage_dlg_commit_titel,
                Messages.AbstractGeneratorPage_dlg_commit_message);
        return openConfirm;
    }

}