package org.howard.edu.lsp.assignment2;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * Name: Claude Cockfield 
 */

public class Aggregator {

	public static void main(String[] args) {
		
		if (args.length != 1 || 
				"-h".compareToIgnoreCase(args[0]) == 0) {
			Aggregator.usage();
			System.exit(args.length == 1 ? 0 : 1);
		}

		_logger.info("current directory is '",
				System.getProperty("user.dir"),
				"'",
				Logger._NEWLINE);

		_logger.info("using filename '", 
				args[0], 
				'\'',
				Logger._NEWLINE);

		Cache cache = new Cache(args[0]);

		if (!cache.ok()) {
			_logger.error("cache create invalid!");
			System.exit(1);
		}

		// additional output - disabled.
		//_logger.info("successfully loaded the following text from file.", 
		//		Logger._NEWLINE, 
		//		Logger._NEWLINE,
		//		cache.data());

		Aggregator aggregator = new Aggregator(cache.data());

		if (!aggregator.ok()) {
			_logger.error("aggregate failed!");
			System.exit(1);
		}

		long width = aggregator.widest() + _padding;
		
		_logger.info("results.", 
				Logger._NEWLINE);
		
		aggregator.aggregates().entrySet().
		stream().
		//sorted((x1, x2) -> x1.getKey().compareTo(x2.getKey())).
		forEach(e-> System.out.println(String.
				format("%-" + width + "s", e.getKey()) + e.getValue()));
	}

	private static void usage() {
		_logger.info("usage: ", Aggregator.class.getName() + " ( -h | <filename> ) ");
		_logger.info("");
		_logger.info(" -h:          display this help information.");
		_logger.info(" <filename>:  mandatory. path of input file for processing.");
		_logger.info();
		_logger.info(" e.g. read data from relative path");
		_logger.info();
		_logger.info("  java ", Aggregator.class.getName(), " ../../words.txt ");
		_logger.info();
		_logger.info(" e.g. read data from absolute path");
		_logger.info();
		_logger.info("  java ", Aggregator.class.getName(), " /tmp/words.txt ");
	}

	public Aggregator(String data) {

		_aggregates = 
				Arrays.stream(data.split(_letter)).
				filter(x -> { if (x.length() > _widest) _widest = x.length(); 
					return x.length() > _length && !Aggregator.numeric(x); }).
				map(x -> x.matches(_capital) ? x.toLowerCase() : x).  
				collect(Collectors.groupingBy(
						x -> x,
						Collectors.counting()));
		
		_ok = true;
	}

	public Map<String, Long> aggregates() {
		return _aggregates;
	}

	public boolean ok() {
		return _ok;
	}
	
	public long widest() {
		return _widest;
	}

	// put here instead of inline pattern match for more flexibility going forward 
	// for changing definition of 'numeric'.
	private static boolean numeric(String s) { 
		return s.matches(_number);
	}
	
	private long _widest = 0;
	
	private boolean _ok = false;

	// used a map because of associative format (value, counter) and HashMap is faster 
	// than HashSet.
	final private Map<String, Long> _aggregates; 

	// limited as per my reading of the specification. excludes scientific notation 
	// and floating point numbers.
	final private static String _letter = "\\P{Alnum}+"; 

	final private static String _capital = "^.*[A-Z].*$";

	final private static String _number = "^[0-9]+$";

	final private static int _length = 3;

	final private static int _padding = 2;

	// no concurrency so static here is fine. 
	final private static Logger _logger = new Logger(Aggregator.class.getName());
}
