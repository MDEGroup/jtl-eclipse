package jtl.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Jar {

	/**
	 * Extract a file from the jar we are running from.
	 * @param file path of the file inside the jar
	 * @param destination where to extract the file
	 * @return path of the extracted file
	 */
	public static String extractFile(final String file, final String destination) {

		final File tempFile = (new File(destination).isDirectory()) ?
				Paths.get(destination, file).toFile() : new File(file);
		tempFile.deleteOnExit();
		try {
			try (final InputStream is = Jar.class.getClassLoader().getResourceAsStream(file)) {
				Files.copy(is, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
			}
			return tempFile.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
