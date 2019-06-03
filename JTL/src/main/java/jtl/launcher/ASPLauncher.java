package jtl.launcher;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface ASPLauncher  {
	public String appendTransformation(
			String ASPFile, String targetmmName, ByteArrayOutputStream asp);

	class ASPLauncherImpl implements ASPLauncher {

		/** Logger */
		private static Logger logger = LogManager.getLogger(ASPLauncherImpl.class);

		/**
		 * Keep the text from the '%%% TRANSFORMATION %%%' line on.
		 * @param ASPFile the file containing ASP code
		 * @param asp current ASP output
		 * @return filename of the final ASP program
		 */
		@Override
		public String appendTransformation(
				final String ASPFile,
				final String targetmmName,
				final ByteArrayOutputStream asp) {
			try (BufferedReader br =
					new BufferedReader(new FileReader(ASPFile))) {
				boolean append = false;
				String line;
				while ((line = br.readLine()) != null) {
					if (append) {
						if (line.startsWith("#const mmt")) {
							line = "#const mmt = " + targetmmName + ".";
						}
						asp.write((line + "\n").getBytes());
					} else if (line.equals("%%% TRANSFORMATION %%%")) {
						append = true;
						asp.write(("\n" + line + "\n").getBytes());
					}
				}
			} catch (FileNotFoundException e) {
				logger.error("File not found: " + ASPFile, e);
			} catch (IOException e) {
				logger.error("Unable to read the file: " + ASPFile, e);
			}
			return ASPFile;
		}
	}
}
