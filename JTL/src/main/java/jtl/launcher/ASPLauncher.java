package jtl.launcher;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public interface ASPLauncher  {
	public String appendTransformation(
			File ASPFile, String targetmmName, ByteArrayOutputStream asp);

	class ASPLauncherImpl implements ASPLauncher {
		/**
		 * Keep the text from the '%%% TRANSFORMATION %%%' line on.
		 * @param ASPFile the file containing ASP code
		 * @param asp current ASP output
		 * @return filename of the final ASP program
		 */
		@Override
		public String appendTransformation(
				final File ASPFile,
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
				System.out.println("File not found: " + ASPFile);
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Unable to read the file: " + ASPFile);
				e.printStackTrace();
			}
			return ASPFile.getPath();
		}
	}
}
