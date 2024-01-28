package org.howard.edu.lsp.assignment2;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Aggregator {
		
	public Aggregator(String data) {

		_aggregates = 
				Arrays.stream(data.split(_alnum)).
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
	final private static String _alnum = "\\P{Alnum}+"; 

	final private static String _capital = "^.*[A-Z].*$";

	final private static String _number = "^[0-9]+$";

	final private static int _length = 3;
}
