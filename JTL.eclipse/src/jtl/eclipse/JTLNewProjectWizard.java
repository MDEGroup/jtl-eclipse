package jtl.eclipse;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

public class JTLNewProjectWizard extends Wizard implements INewWizard {

	/**
	 * The single page provided by this base implementation. It provides all the
	 * functionality required to capture the name and location of the target project.
	 */
	private WizardNewProjectCreationPage wizardNewProjectCreationPage;

	/**
	 * The constructor.
	 */
	public JTLNewProjectWizard() {
		super();
		setNeedsProgressMonitor(true);
	}

	/**
	 * Creates the sole wizard page contributed by this base implementation; the
	 * standard Eclipse WizardNewProjectCreationPage.
	 *
	 * @see
	 * org.eclipse.ui.dialogs.WizardNewProjectCreationPage#org.eclipse.ui.dialogs.Wizar
	 * dNewProjectCreationPage(String)
	 */
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// Set default image for all wizard pages
		URL url = null;
		try {
			url = new URL("platform:/plugin/JTL.eclipse/icons/newprj_wiz.png");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		setDefaultPageImageDescriptor(ImageDescriptor.createFromURL(url));

		wizardNewProjectCreationPage =new WizardNewProjectCreationPage("New JTL project");
		wizardNewProjectCreationPage.setTitle("New JTL project");
		wizardNewProjectCreationPage.setDescription("Enter a name and select a location where the new project shall be created.");
		wizardNewProjectCreationPage.setInitialProjectName("");

		this.addPage(wizardNewProjectCreationPage);
	}

	/**
	 * Performs the bulk of the wizard functionality: project creation, the unzip
	 * operation and classpath update.
	 *
	 * @see org.eclipse.jface.wizard.Wizard#performFinish
	 */
	@Override
	public boolean performFinish() {

		try {
			IRunnableWithProgress operation = new WorkspaceModifyOperation() {

				@Override
				protected void execute(IProgressMonitor monitor) throws InterruptedException {
					monitor.beginTask("Creating JTL Project", 100);

					// Create the project folder
					IPath projectPath = wizardNewProjectCreationPage.getLocationPath();

					String projectName = wizardNewProjectCreationPage.getProjectName();
					String projectFolder = projectPath.toOSString() + File.separator + projectName;
					File projectFolderFile = new File(projectFolder);

					IWorkspace workspace = ResourcesPlugin.getWorkspace();
					IProject project = workspace.getRoot().getProject(projectName);

					// If the project does not exist, we will create it and populate it.
					if (!project.exists()) {
						projectFolderFile.mkdirs();

						// 10%
						monitor.worked(10);
						if (monitor.isCanceled()) {
							throw new InterruptedException();
						}

						// Create the directories
						new File(projectFolder + File.separator + "metamodels").mkdir();
						new File(projectFolder + File.separator + "models").mkdir();
						new File(projectFolder + File.separator + "target").mkdir();
						new File(projectFolder + File.separator + "transformations").mkdir();

						// 20%
						monitor.worked(10);
						if (monitor.isCanceled()) {
							throw new InterruptedException();
						}

						// Set the project description
						IProjectDescription desc = workspace.newProjectDescription(project.getName());
						if (!projectPath.equals(workspace.getRoot().getLocation())) {
							desc.setLocation(new Path(projectFolder));
						}

						// 30%
						monitor.worked(10);
						if (monitor.isCanceled()) {
							throw new InterruptedException();
						}

						// Create and open the project
						try {
							project.create(desc, monitor);
							project.open(monitor);
						} catch (Exception e) {
							throw new RuntimeException(e);
						} finally {
							monitor.done();
						}
					}
				}
			};

			getContainer().run(false, true, operation);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
