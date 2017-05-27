package jtl;

import java.io.File;
import java.util.ArrayList;

public class ASPLauncher extends AbstractJTLLauncher {

	/**
	 * Launch the transformation process.
	 * @param sourcemmFile source metamodel file
	 * @param targetmmFile target metamodel file
	 * @param sourcemFile source model file
	 * @param targetmFolder folder where to save generated target models
	 * @param transfFile file specifying the transformation
	 */
	@Override
	public void launch(final File sourcemmFile,
					   final File targetmmFile,
					   final File sourcemFile,
					   final File targetmFolder,
					   final File transfFile) {
		// Run the solver
		ArrayList<String> modelsFiles = runSolver(transfFile, targetmFolder, sourcemFile);

		// Process target models
		processTargetModels(modelsFiles, targetmmFile);
	}

}
