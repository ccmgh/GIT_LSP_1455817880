package org.howard.edu.lsp.assignment2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

	// logger for easier logging of multi-part log statements and non-trvial objects.
	
	public Logger(String name) {
		_prefixes = new String[] { " " + name + "[error]: ", 
				" " + name + "[info]:  ", 
				" " + name + "[exception]: " };
	}

	public void error(Object... os) {
		this.stderr(Arrays.stream(os).
				map(Logger::concat).
				toArray(String[]::new));
	}

	public void error(String... os) {
		this.stderr(os);
	}

	public void info(Object... os) {
		this.stdout(Arrays.stream(os).
				map(Logger::concat).
				toArray(String[]::new));
	}

	public void info(String... os) {
		this.stdout(os);
	}
	
	public void exception(Exception e) {
		System.err.print(_format.format(LocalDateTime.now()));
		System.err.println(_prefixes[2]);
		System.err.println(e.toString());
		System.err.println(
				Arrays.stream(e.getStackTrace()).
				map(StackTraceElement::toString).
				collect(Collectors.joining()));
	}

	private void stdout(String... os) {
		System.out.print(_format.format(LocalDateTime.now()));
		System.out.print(_prefixes[1]);
		Arrays.stream(os).forEach(System.out::print);
		System.out.println();
	}

	private void stderr(String... os) {
		System.err.print(_format.format(LocalDateTime.now()));
		System.err.print(_prefixes[0]);
		Arrays.stream(os).forEach(System.err::print);
		System.err.println();
	}

	static private String concat(Object o) {

		StringBuilder buffer = new StringBuilder();

		if (o.getClass().isArray()) {

			buffer.append(Arrays.stream((Object[]) o).
					map(Logger::concat).
					collect(Collectors.joining(",", "[", "]")));

		} else if (o instanceof Collection<?>) {

			buffer.append(((Collection<?>) o).stream().
					map(Logger::concat).
					collect(Collectors.joining(",", "{", "}")));

		} else if (o instanceof Map<?, ?>) {

			buffer.append(
					((Map<?, ?>) o).entrySet().stream().
					map(Logger::concat).
					collect(Collectors.joining(",", "(", ")")));

		} else if (o instanceof Map.Entry<?, ?>) {

			buffer.append(Logger.concat(((Map.Entry<?, ?>) o).getKey()));
			buffer.append("=");
			buffer.append(Logger.concat(((Map.Entry<?, ?>) o).getValue()));

		} else {
			return o.toString();
		}

		return buffer.toString();
	}

	final private String[] _prefixes;

	final public static String _NEWLINE = System.getProperty("line.separator");
	
	final private static DateTimeFormatter _format = DateTimeFormatter.ofPattern("yyyyMMdd-HH:mm:ss");
}
