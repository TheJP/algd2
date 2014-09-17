package ch.fhnw.algd2.u01;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class WordCount {
	private Map<String, Counter> count = new TreeMap<>();
	public void countFromReader(BufferedReader reader){
		reader.lines().forEach(l ->
			Arrays.stream(l.split("\\W"))
				.map(s -> s.toLowerCase().trim())
				.filter(s -> !s.isEmpty())
				.forEach(s -> {
					if(count.containsKey(s)){ count.get(s).inc(); }
					else { count.put(s, new Counter(1)); }
				})
		);
	}
	public void printOrdered(PrintStream writer){
		writer.println("ABC ^");
		count.entrySet().forEach(
			e -> writer.println(String.format("%s: %s", e.getKey(), e.getValue()))
		);
		writer.println();
		writer.println();
		writer.println("---------");
		writer.println();
		writer.println();
		writer.println("Number v");
		count.entrySet().stream()
			.sorted((a,b) -> Integer.compare(b.getValue().get(), a.getValue().get()))
			.forEach(
				e -> writer.println(String.format("%s: %s", e.getKey(), e.getValue()))
			);
	}
}
