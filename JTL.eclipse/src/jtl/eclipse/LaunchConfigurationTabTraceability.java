package jtl.eclipse;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ResourceListSelectionDialog;

public class LaunchConfigurationTabTraceability extends AbstractLaunchConfigurationTab {

	private Text sourcemmText;
	private Text targetmmText;
	private Text sourcemText;
	private Text targetmText;
	private Text transfText;
	private Spinner limitSpinner;
	private Button tracesCheck;
	private Text tracesText;
	private Button chainCheck;
	private Combo chainCombo;
	private Spinner chainLimitSpinner;
	private ArrayList<Control> tracesControls = new ArrayList<Control>();
	private ArrayList<Control> chainControls = new ArrayList<Control>();


	@Override
	public void createControl(Composite parent) {

		Composite comp = new Composite(parent, SWT.NONE);
		setControl(comp);

        comp.setLayout(new GridLayout());
        comp.setFont(parent.getFont());

        // Create a listener for user modifications of text fields
        ModifyListener modTextListener = new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                updateLaunchConfigurationDialog();
        	}
        };

        // Metamodels selection form
        // Group
        Group metamodelsGroup = new Group(comp, SWT.NONE);
        metamodelsGroup.setFont(comp.getFont());
        metamodelsGroup.setLayout(new GridLayout(3, false));
        metamodelsGroup.setLayoutData(
        		new GridData(SWT.FILL, SWT.CENTER, true, false));
        metamodelsGroup.setText("Metamodels");

        // Source metamodel
        new Label(metamodelsGroup, SWT.NONE).setText("Source:");
        sourcemmText = new Text(metamodelsGroup, SWT.BORDER);
        sourcemmText.setLayoutData(
        		new GridData(SWT.FILL, SWT.CENTER, true, false));
        sourcemmText.addModifyListener(modTextListener);
        //sourcemmText.addModifyListener(new ModifyListener() {
        Button sourcemmButton = new Button(metamodelsGroup, SWT.PUSH);
        sourcemmButton.setText("Browse...");
        sourcemmButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
        		sourcemmText.setText(selectResource(
                        "Select a resource as the source metamodel",
        				IResource.FILE));
        		updateLaunchConfigurationDialog();
        	}
        });

        // Target metamodel
        new Label(metamodelsGroup, SWT.NONE).setText("Target:");
        targetmmText = new Text(metamodelsGroup, SWT.BORDER);
        targetmmText.setLayoutData(
        		new GridData(SWT.FILL, SWT.CENTER, true, false));
        targetmmText.addModifyListener(modTextListener);
        Button targetmmButton = new Button(metamodelsGroup, SWT.PUSH);
        targetmmButton.setText("Browse...");
        targetmmButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
        		targetmmText.setText(selectResource(
        				"Select a resource as the target metamodel",
        				IResource.FILE));
        		updateLaunchConfigurationDialog();
        	}
        });

        // Models selection form
        // Group
        Group modelsGroup = new Group(comp, SWT.NONE);
        modelsGroup.setFont(comp.getFont());
        modelsGroup.setLayout(new GridLayout(3, false));
        modelsGroup.setLayoutData(
        		new GridData(SWT.FILL, SWT.CENTER, true, false));
        modelsGroup.setText("Models");

        // Source model
        new Label(modelsGroup, SWT.NONE).setText("Source:");
        sourcemText = new Text(modelsGroup, SWT.BORDER);
        sourcemText.setLayoutData(
        		new GridData(SWT.FILL, SWT.CENTER, true, false));
        sourcemText.addModifyListener(modTextListener);
        Button sourcemButton = new Button(modelsGroup, SWT.PUSH);
        sourcemButton.setText("Browse...");
        sourcemButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
        		sourcemText.setText(selectResource(
        				"Select a resource as the source model",
        				IResource.FILE));
        		updateLaunchConfigurationDialog();
        	}
        });

        // Target models folder
        new Label(modelsGroup, SWT.NONE).setText("Target:");
        targetmText = new Text(modelsGroup, SWT.BORDER);
        targetmText.setLayoutData(
        		new GridData(SWT.FILL, SWT.CENTER, true, false));
        targetmText.addModifyListener(modTextListener);
        Button targetmButton = new Button(modelsGroup, SWT.PUSH);
        targetmButton.setText("Browse...");
        targetmButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
        		targetmText.setText(selectResource(
        				"Select a folder where to store target models",
        				IResource.FILE));
        		updateLaunchConfigurationDialog();
        	}
        });

        // Transformation selection form
        // Group
        Group transfGroup = new Group(comp, SWT.NONE);
        transfGroup.setFont(comp.getFont());
        transfGroup.setLayout(new GridLayout(4, false));
        transfGroup.setLayoutData(
        		new GridData(SWT.FILL, SWT.CENTER, true, false));
        transfGroup.setText("Transformation");

        // Transformation
        new Label(transfGroup, SWT.NONE).setText("JTL:");
        transfText = new Text(transfGroup, SWT.BORDER);
        transfText.setLayoutData(
        		new GridData(SWT.FILL, SWT.CENTER, true, false));
        transfText.addModifyListener(modTextListener);
        Button transfButton = new Button(transfGroup, SWT.PUSH);
        transfButton.setText("Browse...");
        transfButton.setLayoutData(
        		new GridData(SWT.BEGINNING, SWT.CENTER, false, false, 2, 1));
        transfButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
        		transfText.setText(selectResource(
        				"Select a resource as JTL transformation",
        				IResource.FILE));
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
			sourcemmText.setText(configuration
				.getAttribute(LaunchConfigurationAttributes.SOURCEMM_TEXT, ""));
			targetmmText.setText(configuration
				.getAttribute(LaunchConfigurationAttributes.TARGETMM_TEXT, ""));
			sourcemText.setText(configuration
				.getAttribute(LaunchConfigurationAttributes.SOURCEM_TEXT, ""));
			targetmText.setText(configuration
				.getAttribute(LaunchConfigurationAttributes.TARGETM_TEXT, ""));
			transfText.setText(configuration
				.getAttribute(LaunchConfigurationAttributes.TRANSF_TEXT, ""));
		} catch (CoreException e) {
			System.out.println("Unable to load the configuration data.");
			e.printStackTrace();
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(LaunchConfigurationAttributes.SOURCEMM_TEXT,
				sourcemmText.getText());
		configuration.setAttribute(LaunchConfigurationAttributes.TARGETMM_TEXT,
				targetmmText.getText());
		configuration.setAttribute(LaunchConfigurationAttributes.SOURCEM_TEXT,
				sourcemText.getText());
		configuration.setAttribute(LaunchConfigurationAttributes.TARGETM_TEXT,
				targetmText.getText());
		configuration.setAttribute(LaunchConfigurationAttributes.TRANSF_TEXT,
				transfText.getText());
	}

	@Override
	public String getName() {
		return "JTL for Traceability";
	}

	private String selectResource(final String title, final int resourceType) {
		ResourceListSelectionDialog dialog = new ResourceListSelectionDialog(
				getShell(),
				ResourcesPlugin.getWorkspace().getRoot(),
				resourceType);
		dialog.setTitle(title);
		if (dialog.open() == ResourceListSelectionDialog.OK) {
			Object[] result = dialog.getResult();
			return ((IResource) result[0]).getFullPath().toString();
		}
		return null;
	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		this.setErrorMessage(null);
		return super.isValid(launchConfig);
	}

	private void setTraceModelVisible(final boolean visible) {
		for (Control c : tracesControls) {
			c.setVisible(visible);
		}
	}

	private void setChainVisible(final boolean visible) {
		for (Control c : chainControls) {
			c.setVisible(visible);
		}
	}

}
