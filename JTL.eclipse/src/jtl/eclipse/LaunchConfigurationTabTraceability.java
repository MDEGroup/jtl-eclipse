package jtl.eclipse;


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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ResourceListSelectionDialog;

public class LaunchConfigurationTabTraceability extends AbstractLaunchConfigurationTab {

	private Text leftmmText;
	private Text rightmmText;
	private Text leftmText;
	private Text rightmText;
	private Text transfText;
	private Text traceText;

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

        // Left metamodel
        new Label(metamodelsGroup, SWT.NONE).setText("Left:");
        leftmmText = new Text(metamodelsGroup, SWT.BORDER);
        leftmmText.setLayoutData(
        		new GridData(SWT.FILL, SWT.CENTER, true, false));
        leftmmText.addModifyListener(modTextListener);
        Button leftmmButton = new Button(metamodelsGroup, SWT.PUSH);
        leftmmButton.setText("Browse...");
        leftmmButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
        		leftmmText.setText(selectResource(
                        "Select a resource as the left metamodel",
        				IResource.FILE));
        		updateLaunchConfigurationDialog();
        	}
        });

        // Right metamodel
        new Label(metamodelsGroup, SWT.NONE).setText("Right:");
        rightmmText = new Text(metamodelsGroup, SWT.BORDER);
        rightmmText.setLayoutData(
        		new GridData(SWT.FILL, SWT.CENTER, true, false));
        rightmmText.addModifyListener(modTextListener);
        Button rightmmButton = new Button(metamodelsGroup, SWT.PUSH);
        rightmmButton.setText("Browse...");
        rightmmButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
        		rightmmText.setText(selectResource(
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

        // Left model
        new Label(modelsGroup, SWT.NONE).setText("Left:");
        leftmText = new Text(modelsGroup, SWT.BORDER);
        leftmText.setLayoutData(
        		new GridData(SWT.FILL, SWT.CENTER, true, false));
        leftmText.addModifyListener(modTextListener);
        Button leftmButton = new Button(modelsGroup, SWT.PUSH);
        leftmButton.setText("Browse...");
        leftmButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
        		leftmText.setText(selectResource(
        				"Select a resource as the left model",
        				IResource.FILE));
        		updateLaunchConfigurationDialog();
        	}
        });

        // Right model
        new Label(modelsGroup, SWT.NONE).setText("Right:");
        rightmText = new Text(modelsGroup, SWT.BORDER);
        rightmText.setLayoutData(
        		new GridData(SWT.FILL, SWT.CENTER, true, false));
        rightmText.addModifyListener(modTextListener);
        Button rightmButton = new Button(modelsGroup, SWT.PUSH);
        rightmButton.setText("Browse...");
        rightmButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
        		rightmText.setText(selectResource(
        				"Select a resource as the right model",
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
        transfGroup.setText("Correspondences specification");

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
        				"Select a resource as correspondences specification",
        				IResource.FILE));
        		updateLaunchConfigurationDialog();
        	}
        });

        // Trace model
        Group traceGroup = new Group(comp, SWT.NONE);
        traceGroup.setFont(comp.getFont());
        traceGroup.setLayout(new GridLayout(1, false));
        traceGroup.setLayoutData(
        		new GridData(SWT.FILL, SWT.CENTER, true, false));
        traceGroup.setText("Output");
        new Label(traceGroup, SWT.NONE).setText("Trace model:");
        traceText = new Text(traceGroup, SWT.BORDER);
        traceText.setLayoutData(
        		new GridData(SWT.FILL, SWT.CENTER, true, false));
        traceText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
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
			leftmmText.setText(configuration
				.getAttribute(LaunchConfigurationAttributes.LEFTMM_TEXT, ""));
			rightmmText.setText(configuration
				.getAttribute(LaunchConfigurationAttributes.RIGHTMM_TEXT, ""));
			leftmText.setText(configuration
				.getAttribute(LaunchConfigurationAttributes.LEFTM_TEXT, ""));
			rightmText.setText(configuration
				.getAttribute(LaunchConfigurationAttributes.RIGHTM_TEXT, ""));
			transfText.setText(configuration
				.getAttribute(LaunchConfigurationAttributes.TRANSF_TEXT, ""));
			traceText.setText(configuration
				.getAttribute(LaunchConfigurationAttributes.TRACE_TEXT, ""));
		} catch (CoreException e) {
			System.out.println("Unable to load the configuration data.");
			e.printStackTrace();
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(LaunchConfigurationAttributes.LEFTMM_TEXT,
				leftmmText.getText());
		configuration.setAttribute(LaunchConfigurationAttributes.RIGHTMM_TEXT,
				rightmmText.getText());
		configuration.setAttribute(LaunchConfigurationAttributes.LEFTM_TEXT,
				leftmText.getText());
		configuration.setAttribute(LaunchConfigurationAttributes.RIGHTM_TEXT,
				rightmText.getText());
		configuration.setAttribute(LaunchConfigurationAttributes.TRANSF_TEXT,
				transfText.getText());
		configuration.setAttribute(LaunchConfigurationAttributes.TRACE_TEXT,
				traceText.getText());
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
		String errorMsg = "";
		if (leftmmText.getText().equals("")) {
			errorMsg += ", the left metamodel";
		}
		if (rightmmText.getText().equals("")) {
			errorMsg += ", the right metamodel";
		}
		if (leftmText.getText().equals("")) {
			errorMsg += ", the left model";
		}
		if (rightmText.getText().equals("")) {
			errorMsg += ", the right model";
		}
		if (transfText.getText().equals("")) {
			errorMsg += ", the correspondences specification";
		}
		if (traceText.getText().equals("")) {
			errorMsg += ", the ouput trace model";
		}
		if (!errorMsg.equals("")) {
			errorMsg = "Please, select a path for " + errorMsg.substring(1) + ".";
			this.setErrorMessage(errorMsg);
			return false;
		}

		if (leftmmText.getText().contains(" ")) {
			errorMsg += "left metamodel, ";
		}
		if (rightmmText.getText().contains(" ")) {
			errorMsg += "right metamodel, ";
		}
		if (leftmText.getText().contains(" ")) {
			errorMsg += "left model, ";
		}
		if (rightmText.getText().contains(" ")) {
			errorMsg += "right model, ";
		}
		if (transfText.getText().contains(" ")) {
			errorMsg += "correspondences specification, ";
		}
		if (traceText.getText().contains(" ")) {
			errorMsg += "output trace model, ";
		}
		if (!errorMsg.equals("")) {
			errorMsg = errorMsg.substring(0, errorMsg.length() - 2) + " cannot contain spaces.";
			this.setErrorMessage(errorMsg);
			return false;
		}

		this.setErrorMessage(null);
		return super.isValid(launchConfig);
	}
}
