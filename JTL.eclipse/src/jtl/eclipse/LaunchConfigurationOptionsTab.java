package jtl.eclipse;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class LaunchConfigurationOptionsTab extends AbstractLaunchConfigurationTab {

	/** Logger */
	private static Logger logger = LogManager.getLogger(LaunchConfigurationOptionsTab.class);

	private Button generateAspCheck;
	private Button clearTargetCheck;

	@Override
	public void createControl(Composite parent) {

		Composite comp = new Composite(parent, SWT.NONE);
		setControl(comp);

		GridLayout gl = new GridLayout();
		gl.marginLeft = 10;
		gl.marginTop = 20;

        comp.setLayout(gl);
        comp.setFont(parent.getFont());

        // OPTION_GENERATE_ASP
        generateAspCheck = new Button(comp, SWT.CHECK);
        generateAspCheck.setText("Generate ASP files for target and trace models");
        generateAspCheck.setLayoutData(
        		new GridData(SWT.FILL, SWT.CENTER, true, false));
        generateAspCheck.addSelectionListener(new SelectionAdapter() {
        	@Override
            public void widgetSelected(SelectionEvent e) {
        		updateLaunchConfigurationDialog();
        	}
        });

        // OPTION_CLEAR_TARGET
        clearTargetCheck = new Button(comp, SWT.CHECK);
        clearTargetCheck.setText("Remove all files in the target directory before the launch");
        clearTargetCheck.setLayoutData(
        		new GridData(SWT.FILL, SWT.CENTER, true, false));
        clearTargetCheck.addSelectionListener(new SelectionAdapter() {
        	@Override
            public void widgetSelected(SelectionEvent e) {
        		updateLaunchConfigurationDialog();
        	}
        });
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			generateAspCheck.setSelection(configuration
					.getAttribute(LaunchConfigurationAttributes.GENERATE_ASP, false));
			clearTargetCheck.setSelection(configuration
					.getAttribute(LaunchConfigurationAttributes.CLEAR_TARGET, false));
		} catch (CoreException e) {
			logger.warn("Unable to load configuration data.", e);
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(LaunchConfigurationAttributes.GENERATE_ASP,
				generateAspCheck.getSelection());
		configuration.setAttribute(LaunchConfigurationAttributes.CLEAR_TARGET,
				clearTargetCheck.getSelection());
	}

	@Override
	public String getName() {
		return "Options";
	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		return true;
	}

}
