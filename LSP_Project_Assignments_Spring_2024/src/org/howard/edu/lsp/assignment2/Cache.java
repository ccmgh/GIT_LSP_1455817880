package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Cache {

	// cache loads the file using buffered line reading. fills back in
	// newlines for later processing.
	public Cache(String filename) {

		StringBuilder buffer = new StringBuilder();

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {

			String line;

			while ((line = bufferedReader.readLine()) != null) {

				if (!buffer.isEmpty()) {
					buffer.append(Logger._NEWLINE);
				}

				buffer.append(line);
			}

			_data = buffer.toString();

			_ok = true;

		} catch (IOException e) {
			_logger.exception(e);
		}
	}

	public String data() {
		return _data;
	}

	public boolean ok() {
		return _ok;
	}

	private boolean _ok = false;

	private String _data = "";

	final private Logger _logger = new Logger(Cache.class.getName());
}
