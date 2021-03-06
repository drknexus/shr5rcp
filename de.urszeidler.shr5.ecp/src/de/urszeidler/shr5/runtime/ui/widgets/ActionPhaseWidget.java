package de.urszeidler.shr5.runtime.ui.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.wb.swt.ResourceManager;

import de.urszeidler.eclipse.shr5.gameplay.GameplayFactory;
import de.urszeidler.eclipse.shr5.gameplay.InitativePass;
import de.urszeidler.eclipse.shr5.gameplay.InterruptAction;
import de.urszeidler.eclipse.shr5.gameplay.InterruptType;

public class ActionPhaseWidget extends NameableComposite {

    private InitativePass initativePass;
    
    
    /**
     * Create the composite.
     * 
     * @param parent
     * @param style
     * @param grouname
     */
    public ActionPhaseWidget(Composite parent, int style, String grouname) {
        super(parent, style, grouname);

    }

    @Override
    protected void checkSubclass() {
        // Disable the check that prevents subclassing of SWT components
    }

    protected void updateToolbar() {
//        final InterruptType interruptType = InterruptType.INTERCEPT;
        InterruptType[] interruptTypes = InterruptType.values();
        for (InterruptType interruptType : interruptTypes) {
            createInterruptedAction(interruptType);
        }
        
    }

    private void createInterruptedAction(final InterruptType interruptType) {
        ToolItem tltmI = new ToolItem(actionBar, SWT.NONE);
        String literal = interruptType.getLiteral();
        tltmI.setToolTipText(literal);
        tltmI.setImage(ResourceManager.getPluginImage("de.urszeidler.shr5.ecp", "images/interrupt-"+(interruptType.getValue()+1)+".png"));
        
        tltmI.addSelectionListener(new SelectionAdapter(){
            @Override
            public void widgetSelected(SelectionEvent e) {
                InterruptAction interruptAction = GameplayFactory.eINSTANCE.createInterruptAction();
                if(interruptType==InterruptType.FULL_DEFENSE)
                    interruptAction.setIniCost(-10);
                else    
                    interruptAction.setIniCost(-5);
                interruptAction.setInterruptType(interruptType);
                interruptAction.setSubject(initativePass.getSubject());
                interruptAction.setDate(initativePass.getDate());
                initativePass.setInterruptAction(interruptAction);
                interruptAction.redo();
            }
            
        });
    }
    
    public void setCharacter(InitativePass pass) {
        this.initativePass = pass;
        this.setNameable(pass.getSubject().getCharacter().getPersona());
    }

    
    public void setActiv(boolean active) {
        if (active) {
            gridLayout1.marginTop = 8;
            gridLayout1.marginBottom = 8;
            gridLayout1.marginRight = 4;
            gridLayout1.marginLeft = 4;
            this.setBackgroundImage(ResourceManager.getPluginImage("de.urszeidler.shr5.ecp", "images/simple-bck.png"));
            actionBar.setEnabled(false);
        } else {
            gridLayout1.marginTop = 0;
            gridLayout1.marginBottom = 0;
            gridLayout1.marginRight = 0;
            gridLayout1.marginLeft = 0;
            this.setBackgroundImage(null);
            actionBar.setEnabled(!initativePass.isExecuted());
        }
    }

}
