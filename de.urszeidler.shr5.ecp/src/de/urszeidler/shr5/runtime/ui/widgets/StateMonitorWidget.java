package de.urszeidler.shr5.runtime.ui.widgets;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;

/**
 * Defines a state monitor for one damage state.
 * 
 * @author urs
 */
public class StateMonitorWidget extends Composite {

    private WritableValue damageState = new WritableValue();
    private WritableValue conditionMonitor = new WritableValue();
    private Composite composite_state;
    private List<SingleStateWidget> stateMonitors;
    private int style;

    /**
     * Create the composite.
     * 
     * @param parent
     * @param style
     */
    public StateMonitorWidget(Composite parent, int style) {
        super(parent, style);
        conditionMonitor.setValue(11);

        this.style = style;
        setLayout(new FillLayout(SWT.HORIZONTAL));
        init();
    }

    private void init() {
        if (composite_state != null)
            composite_state.dispose();

        composite_state = new Composite(this, SWT.NONE);
        GridLayout layout = new GridLayout(4, false);
        layout.horizontalSpacing = 0;
        layout.verticalSpacing = 0;
        composite_state.setLayout(layout);

        Integer value = (Integer)conditionMonitor.getValue();
        stateMonitors = new ArrayList<SingleStateWidget>(value);
        for (int i = 1; i <= value; i++) {
            SingleStateWidget stateWidget = new SingleStateWidget(composite_state, style);
            GridData gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
            stateWidget.setLayoutData(gridData);
            stateMonitors.add(stateWidget);
            if (i % 3 == 0) {
                Label label = new Label(composite_state, style);
                label.setText("dd");
            }
        }
    }

    @Override
    protected void checkSubclass() {
        // Disable the check that prevents subclassing of SWT components
    }

}
