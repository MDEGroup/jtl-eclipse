package jtl.solver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ASPSolver extends AbstractASPSolver {

	/**
	 * Extract the solver executable from the JAR.
	 */
	private File extractSolver(final String solverFile) {
		try {
			// Get the launch location
			URI uri = jtl.solver.ASPSolver.class
				.getProtectionDomain()
				.getCodeSource()
				.getLocation()
				.toURI();

			File location = new File(uri);

			// Verify it is not in a directory
			if (location.isDirectory()) {
				return null;
			}

			// Extract to a temporary file
			final ZipFile zip = new ZipFile(location);
			final File tempFile = File.createTempFile(solverFile,
					Long.toString(System.currentTimeMillis()));
			tempFile.deleteOnExit();
			final ZipEntry entry = zip.getEntry(solverFile);
			if (entry == null) {
				zip.close();
				throw new FileNotFoundException(
						"Cannot find file: " + solverFile +
						" in archive: " + zip.getName());
			}
			final InputStream zipStream = zip.getInputStream(entry);
			final OutputStream fileStream = new FileOutputStream(tempFile);
			final byte[] buf = new byte[1024];
			while (zipStream.read(buf) != -1) {
				fileStream.write(buf);
			}
			zipStream.close();
			fileStream.close();
			zip.close();
			return tempFile;
		} catch (URISyntaxException | IOException e) {
			System.err.println(
					"Cannot extract the solver executable from the JAR archive.");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Locate the solver executable
	 */
	@Override
	protected String getSolverPath(final String solverFile)
			throws MalformedURLException, IOException {
		// FIXME cross-platform support
		//return extractSolver(solverFile).getAbsolutePath();
		return getWorkingDir() + '/' + solverFile;
	}

	/**
	 * Get the current working directory
	 */
	@Override
	protected String getWorkingDir() {
		return System.getProperty("user.dir");
	}
}
