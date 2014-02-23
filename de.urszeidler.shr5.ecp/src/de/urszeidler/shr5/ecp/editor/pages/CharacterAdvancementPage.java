package de.urszeidler.shr5.ecp.editor.pages;

import java.text.DateFormat;
import java.util.Date;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import de.urszeidler.eclipse.shr5.Shr5Factory;
import de.urszeidler.eclipse.shr5.util.AdapterFactoryUtil;
import de.urszeidler.eclipse.shr5Management.ManagedCharacter;
import de.urszeidler.eclipse.shr5Management.Shr5managementFactory;
import de.urszeidler.eclipse.shr5Management.Shr5managementPackage.Literals;
import de.urszeidler.emf.commons.ui.util.EmfFormBuilder.ReferenceManager;
import de.urszeidler.shr5.ecp.editor.widgets.CharacterAdvacementWidget;

public class CharacterAdvancementPage extends AbstractShr5Page<ManagedCharacter> {

    //private Changes currentChange;
    
    private ManagedCharacter object;
    private EditingDomain editingDomain;
    private DataBindingContext m_bindingContext;
    private Table table;
    private TableViewer tableViewer;

    /**
     * Create the form page.
     * 
     * @param id
     * @param title
     */
    public CharacterAdvancementPage(String id, String title) {
        super(id, title);
    }

    /**
     * Create the form page.
     * 
     * @param editor
     * @param id
     * @param title
     * @wbp.parser.constructor
     * @wbp.eval.method.parameter id "Some id"
     * @wbp.eval.method.parameter title "Some title"
     */
    public CharacterAdvancementPage(FormEditor editor, String id, String title) {
        super(editor, id, title);
        object = Shr5managementFactory.eINSTANCE.createPlayerCharacter();
        object.setPersona(Shr5Factory.eINSTANCE.createMudanPersona());

    }

    /**
     * The main contructor.
     * 
     * @param editor
     * @param id
     * @param title
     * @param object
     * @param editingDomain
     * @param manager
     */
    public CharacterAdvancementPage(FormEditor editor, String id, String title, ManagedCharacter object, EditingDomain editingDomain,
            ReferenceManager manager) {
        super(editor, id, title);
        this.object = object;
        this.editingDomain = editingDomain;
        this.mananger = manager;

    }

    /**
     * Create contents of the form.
     * 
     * @param managedForm
     */
    @Override
    protected void createFormContent(IManagedForm managedForm) {
        final FormToolkit toolkit = managedForm.getToolkit();
        ScrolledForm form = managedForm.getForm();
        form.setText("Character advacements");
        Composite body = form.getBody();
        toolkit.decorateFormHeading(form.getForm());
        toolkit.paintBordersFor(body);
        managedForm.getForm().getBody().setLayout(new GridLayout(1, false));

        Composite composite_advacements = new Composite(managedForm.getForm().getBody(), SWT.NONE);
        composite_advacements.setLayout(new FillLayout(SWT.HORIZONTAL));
        GridData gd_composite_advacements = new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1);
        gd_composite_advacements.heightHint = 106;
        composite_advacements.setLayoutData(gd_composite_advacements);
        managedForm.getToolkit().adapt(composite_advacements);
        managedForm.getToolkit().paintBordersFor(composite_advacements);

        CharacterAdvacementWidget characterAdvacementWidget = new CharacterAdvacementWidget(composite_advacements, SWT.NONE, editingDomain, object,
                toolkit);
        managedForm.getToolkit().adapt(characterAdvacementWidget);
        managedForm.getToolkit().paintBordersFor(characterAdvacementWidget);

        Composite composite_1 = new Composite(managedForm.getForm().getBody(), SWT.NONE);
        composite_1.setLayout(new FillLayout(SWT.HORIZONTAL));
        GridData gd_composite_1 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
        gd_composite_1.heightHint = 108;
        composite_1.setLayoutData(gd_composite_1);
        managedForm.getToolkit().adapt(composite_1);
        managedForm.getToolkit().paintBordersFor(composite_1);

        tableViewer = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
        
        table = tableViewer.getTable();
        table.setHeaderVisible(true);
        managedForm.getToolkit().paintBordersFor(table);
        
        TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
        TableColumn tblclmnName = tableViewerColumn.getColumn();
        tblclmnName.setWidth(350);
        tblclmnName.setText("name");
        
        TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
        TableColumn tblclmnNewColumn = tableViewerColumn_1.getColumn();
        tblclmnNewColumn.setWidth(141);
        tblclmnNewColumn.setText("date");
        
        TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
        TableColumn tblclmnNewColumn_1 = tableViewerColumn_2.getColumn();
        tblclmnNewColumn_1.setWidth(100);
        tblclmnNewColumn_1.setText("date applied");

//        Composite composite = new Composite(managedForm.getForm().getBody(), SWT.NONE);
//        composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
//        composite.setLayout(new FillLayout(SWT.HORIZONTAL));
//        managedForm.getToolkit().adapt(composite);
//        managedForm.getToolkit().paintBordersFor(composite);
//
//        TreeTableWidget treeTableWidget = new TreeTableWidget(composite, "The list of changes", SWT.NONE, object,
//                Shr5managementPackage.Literals.MANAGED_CHARACTER__CHANGES, toolkit, mananger, editingDomain);
//        managedForm.getToolkit().adapt(treeTableWidget);
//        managedForm.getToolkit().paintBordersFor(treeTableWidget);

        Group grpSummary = new Group(managedForm.getForm().getBody(), SWT.NONE);
        grpSummary.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        grpSummary.setText("Summary");
        managedForm.getToolkit().adapt(grpSummary);
        managedForm.getToolkit().paintBordersFor(grpSummary);

        m_bindingContext = initDataBindings();
        // --------
        createFormBuilder(managedForm);

    }

    @Override
    protected EditingDomain getEditingDomain() {
        return editingDomain;
    }

    protected DataBindingContext initDataBindings() {
        DataBindingContext bindingContext = new DataBindingContext();
        //
        ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
        IObservableMap[] observeMaps = EMFEditObservables.observeMaps(editingDomain, listContentProvider.getKnownElements(),
                new EStructuralFeature[]{ Literals.PERSONA_CHANGE__CHANGEABLE, Literals.CHANGES__DATE, Literals.CHANGES__DATE_APPLIED });
        
        
        tableViewer.setLabelProvider(new ObservableMapLabelProvider(observeMaps){
            public String getColumnText(Object element, int columnIndex) {
                if(columnIndex==0){ 
                    
                    return AdapterFactoryUtil.getInstance().getItemDelegator().getText(element);                    
                }
                if (columnIndex < attributeMaps.length) {
                    Object result = attributeMaps[columnIndex].get(element);
                    if (result instanceof Date) {
                        return    result == null ? "" : DateFormat.getDateInstance(DateFormat.SHORT).format(result); //$NON-NLS-1$
                    }
                         
                    }

                return super.getColumnText(element, columnIndex);
            }
            
        });
        tableViewer.setContentProvider(listContentProvider);
        //
        IObservableList objectChangesObserveList = EMFEditObservables.observeList(Realm.getDefault(), editingDomain, object,
                Literals.MANAGED_CHARACTER__CHANGES);
        tableViewer.setInput(objectChangesObserveList);
        //
        return bindingContext;
    }
}