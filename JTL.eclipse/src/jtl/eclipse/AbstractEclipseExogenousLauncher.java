package jtl.eclipse;

import org.eclipse.core.resources.ResourcesPlugin;

import jtl.launcher.AbstractExogenousLauncher;

public class AbstractEclipseExogenousLauncher extends AbstractEclipseJTLLauncher {

	private AbstractExogenousLauncher launcher;

	/**
	 * Default constructor to be used by implementing classes.
	 * @param leftmmFile source metamodel file
	 * @param rightmmFile target metamodel file
	 * @param leftmFile source model file
	 * @param rightmFile folder where to save generated target models
	 * @param transfFile file specifying the transformation
	 */
	public AbstractEclipseExogenousLauncher(
			final String leftmmFile,
			final String rightmmFile,
			final String leftmFile,
			final String rightmFile,
			final String transfFile) {
		super(leftmmFile, rightmmFile, leftmFile, rightmFile, transfFile);
		launcher = new AbstractExogenousLauncher(
				leftmmFile, rightmmFile, leftmFile, rightmFile, transfFile) {	 };
		this.asp = launcher.getASP();
		launcher.setWorkingDir(ResourcesPlugin.getWorkspace().getRoot().getLocation().toString());
	}

	/**
	 * Process the source metamodel to generate the corresponding ASP code.
	 */
	@Override
	public void processSourceMetamodel() {
		launcher.processSourceMetamodel();
	}

	/**
	 * Process the target metamodel to generate the corresponding ASP code.
	 * @return name of the target metamodel
	 */
	@Override
	public String processTargetMetamodel() {
		return launcher.processTargetMetamodel();
	}

	/**
	 * Process the source model to generate the corresponding ASP code.
	 */
	@Override
	public void processSourceModel() {
		launcher.processSourceModel();
	}

	/**
	 * Process the traces model to generate the corresponding ASP code.
	 */
	@Override
	public void processTracesModel() {
		launcher.processTracesModel();
	}
}
