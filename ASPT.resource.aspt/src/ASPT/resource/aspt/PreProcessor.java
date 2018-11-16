package ASPT.resource.aspt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ASPT.resource.aspt.mopp.AsptInputStreamProcessor;

public class PreProcessor extends AsptInputStreamProcessor implements IAsptOptionProvider, IAsptInputStreamProcessorProvider {

	private BufferedReader reader;
	private String line;

	@Override
	public AsptInputStreamProcessor getInputStreamProcessor(InputStream inputStream) {
		reader = new BufferedReader(new InputStreamReader(inputStream));
		return this;
	}

	@Override
	public Map<?, ?> getOptions() {
		return Collections.singletonMap(IAsptOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER, this);
	}

	@Override
	public String getOutputEncoding() {
		return "UTF-8";
	}

	@Override
	public int read() throws IOException {
		int read = -1;
		if (line == null) {
			line = process(reader.readLine());
		}
		if (line != null) {
			if (line.equals("")) {
				line = null;
				read = '\n';
			} else {
				read = line.charAt(0);
				line = line.substring(1);
			}
		}
		return read;
	}

	private String process(String line) {
		if (line == null) {
			return line;
		}

		// Escape double quotes in lists
		// and wrap lists definitions in double quotes
		Pattern p = Pattern.compile("\\w+\\(\\[[^\\]]+\\]\\)");
		Matcher m = p.matcher(line);
		if (m.find()) {
			line = line.substring(0, m.start()) + "\"" +
				   line.substring(m.start(), m.end()).replaceAll("\"", "\\\\\"") + "\"" +
				   line.substring(m.end());
		}
		return line;
	}

}