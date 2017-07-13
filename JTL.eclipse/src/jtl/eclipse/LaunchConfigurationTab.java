package jtl.eclipse;


import java.util.ArrayList;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ResourceListSelectionDialog;

public class LaunchConfigurationTab extends AbstractLaunchConfigurationTab {

	private Text sourcemmText;
	private Text targetmmText;
	private Text sourcemText;
	private Text targetmText;
	private Text transfText;
	private Button tracesCheck;
	private Text tracesText;
	private ArrayList<Control> tracesControls = new ArrayList<Control>();


	@Override
	public void createControl(Composite parent) {

		Composite comp = new Composite(parent, SWT.NONE);
		setControl(comp);

        comp.setLayout(new GridLayout());
        comp.setFont(parent.getFont());

        // Create a listener for user modifications of text fields
        ModifyListener modListener = new ModifyListener() {
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
        sourcemmText.addModifyListener(modListener);
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
        targetmmText.addModifyListener(modListener);
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
        sourcemText.addModifyListener(modListener);
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
        targetmText.addModifyListener(modListener);
        Button targetmButton = new Button(modelsGroup, SWT.PUSH);
        targetmButton.setText("Browse...");
        targetmButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
        		targetmText.setText(selectResource(
        				"Select a folder where to store target models",
        				IResource.FOLDER));
        		updateLaunchConfigurationDialog();
        	}
        });

        // Transformation selection form
        // Group
        Group transfGroup = new Group(comp, SWT.NONE);
        transfGroup.setFont(comp.getFont());
        transfGroup.setLayout(new GridLayout(3, false));
        transfGroup.setLayoutData(
        		new GridData(SWT.FILL, SWT.CENTER, true, false));
        transfGroup.setText("Transformation");

        // Transformation
        new Label(transfGroup, SWT.NONE).setText("JTL:");
        transfText = new Text(transfGroup, SWT.BORDER);
        transfText.setLayoutData(
        		new GridData(SWT.FILL, SWT.CENTER, true, false));
        transfText.addModifyListener(modListener);
        Button transfButton = new Button(transfGroup, SWT.PUSH);
        transfButton.setText("Browse...");
        transfButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
        		transfText.setText(selectResource(
        				"Select a resource as JTL transformation",
        				IResource.FILE));
        		updateLaunchConfigurationDialog();
        	}
        });

        // Traces model
        tracesCheck = new Button(transfGroup, SWT.CHECK);
        tracesCheck.setText("Provide a trace model");
        tracesCheck.setLayoutData(
        		new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
        tracesCheck.addSelectionListener(new SelectionAdapter() {
        	@Override
            public void widgetSelected(SelectionEvent e) {
            	final Button check = (Button) e.getSource();
            	setTraceModelVisible(check.getSelection());
        		updateLaunchConfigurationDialog();
        	}
        });
        final Label tracesLabel = new Label(transfGroup, SWT.NONE);
        tracesLabel.setText("Traces:");
        tracesText = new Text(transfGroup, SWT.BORDER);
        tracesText.setLayoutData(
        		new GridData(SWT.FILL, SWT.CENTER, true, false));
        tracesText.addModifyListener(modListener);
        final Button tracesButton = new Button(transfGroup, SWT.PUSH);
        tracesButton.setText("Browse...");
        tracesButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
        		tracesText.setText(selectResource(
        				"Select a resource as trace model",
        				IResource.FILE));
        		updateLaunchConfigurationDialog();
        	}
        });
        tracesControls.add(tracesLabel);
        tracesControls.add(tracesText);
        tracesControls.add(tracesButton);
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
			tracesText.setText(configuration
					.getAttribute(LaunchConfigurationAttributes.TRACE_TEXT, ""));
			tracesCheck.setSelection(configuration
					.getAttribute(LaunchConfigurationAttributes.TRACE_CHECK, false));
			setTraceModelVisible(tracesCheck.getSelection());
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
		configuration.setAttribute(LaunchConfigurationAttributes.TRACE_TEXT,
				tracesText.getText());
		configuration.setAttribute(LaunchConfigurationAttributes.TRACE_CHECK,
				tracesCheck.getSelection());
	}

	@Override
	public String getName() {
		return "JTL Transformation";
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
		String errorMsg = "";
		if (sourcemmText.getText().equals("")) {
			errorMsg += ", the source metamodel";
		}
		if (targetmmText.getText().equals("")) {
			errorMsg += ", the target metamodel";
		}
		if (sourcemText.getText().equals("")) {
			errorMsg += ", the source model";
		}
		if (targetmText.getText().equals("")) {
			errorMsg += ", the target models folder";
		}
		if (transfText.getText().equals("")) {
			errorMsg += ", the JTL transformation";
		}
		if (tracesCheck.getSelection() && tracesText.getText().equals("")) {
			errorMsg += ", the trace model";
		}
		if (!errorMsg.equals("")) {
			errorMsg = "Please, select a path for " + errorMsg.substring(1) + ".";
			this.setErrorMessage(errorMsg);
			return false;
		}

		this.setErrorMessage(null);
		return super.isValid(launchConfig);
	}

	private void setTraceModelVisible(final boolean visible) {
		for (Control c : tracesControls) {
			c.setVisible(visible);
		}
	}

}
