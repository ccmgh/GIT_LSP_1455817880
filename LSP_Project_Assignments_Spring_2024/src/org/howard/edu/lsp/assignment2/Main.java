package org.howard.edu.lsp.assignment2;

import java.io.File;
import java.net.URL;

/*
 * Name: Claude Cockfield 
 */

public class Main {

	public static void main(String[] args) {
		
		Logger logger = new Logger(Main.class.getName());

		logger.info("current directory is '",
				System.getProperty("user.dir"),
				"'",
				Logger._NEWLINE);
		
		logger.info("using file '", 
				_filepath, 
				'\'',
				Logger._NEWLINE);

		Cache cache = new Cache(_filepath);

		if (!cache.ok()) {
			logger.error("cache create failed!");
			System.exit(1);
		}

		logger.info("successfully loaded the following text from file.", 
				Logger._NEWLINE, 
				Logger._NEWLINE,
				cache.data(),
				Logger._NEWLINE);

		Aggregator aggregator = new Aggregator(cache.data());

		if (!aggregator.ok()) {
			logger.error("aggregator failed!");
			System.exit(1);
		}

		long width = aggregator.widest() + _padding;
		
		logger.info("results.", 
				Logger._NEWLINE);
		
		aggregator.aggregates().entrySet().
		stream().
		sorted((x1, x2) -> x1.getKey().compareTo(x2.getKey())).
		forEach(e-> System.out.println(String.
				format("%-" + width + "s", e.getKey()) + e.getValue()));
	}
	
	final private static int _padding = 2;

	final private static String _filepath = "src/org/howard/edu/lsp/assignment2/words.txt";
}

