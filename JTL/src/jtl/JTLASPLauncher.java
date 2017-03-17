package jtl;

import java.util.ArrayList;

import org.eclipse.core.resources.IFile;

public class JTLASPLauncher extends AbstractJTLLauncher {

	/**
	 * Launch the transformation process.
	 * @param sourcemmFile source metamodel file
	 * @param targetmmFile target metamodel file
	 * @param sourcemFile source model file
	 * @param targetmFolder folder where to save generated target models
	 * @param transfFile file specifying the transformation
	 */
	@Override
	public void launch(final IFile sourcemmFile,
					   final IFile targetmmFile,
					   final IFile sourcemFile,
					   final String targetmFolder,
					   final IFile transfFile) {
		// IFile filename to string
		String ASPFile = transfFile.getLocation().toOSString();
		
		// Run the solver
		ArrayList<String> modelsFiles = runSolver(ASPFile, targetmFolder);
		
		// Process target models
		processTargetModels(modelsFiles, targetmmFile);
	}

}
