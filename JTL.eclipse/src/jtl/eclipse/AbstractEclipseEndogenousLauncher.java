package jtl.eclipse;

import java.io.File;

import org.eclipse.core.resources.ResourcesPlugin;

import jtl.launcher.AbstractEndogenousLauncher;

public abstract class AbstractEclipseEndogenousLauncher extends AbstractEclipseJTLLauncher {

	private AbstractEndogenousLauncher launcher;

	/**
	 * Default constructor to be used by implementing classes.
	 * @param sourcemmFile source metamodel file
	 * @param targetmmFile target metamodel file
	 * @param sourcemFile source model file
	 * @param targetmFolder folder where to save generated target models
	 * @param transfFile file specifying the transformation
	 */
	public AbstractEclipseEndogenousLauncher(
			final File sourcemmFile,
			final File sourcemFile,
			final File targetmFolder,
			final File transfFile) {
		super(sourcemmFile, sourcemmFile, sourcemFile, targetmFolder, transfFile);
		launcher = new AbstractEndogenousLauncher(
				sourcemmFile, sourcemFile, targetmFolder, transfFile) {	};
		this.asp = launcher.getASP();
		launcher.setWorkingDir(ResourcesPlugin.getWorkspace().getRoot().getLocation().toString());
	}

	/**
	 * Process the source metamodel to generate the corresponding ASP code.
	 * @param sourcemmFile source metamodel file
	 */
	@Override
	public void processSourceMetamodel() {
		launcher.processSourceMetamodel();
	}

	/**
	 * Process the target metamodel to generate the corresponding ASP code.
	 * @param targetmmFile target metamodel file
	 * @return name of the target metamodel
	 */
	@Override
	public String processTargetMetamodel() {
		return launcher.processTargetMetamodel();
	}

	/**
	 * Process the source model to generate the corresponding ASP code.
	 * @param sourcemmFile source metamodel file
	 * @param sourcemFile source model file
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
