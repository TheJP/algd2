package ch.fhnw.algd2.u01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Aufgabe02WordCounter {

	public static void main(String[] args) {
		WordCount wc = new WordCount();
		try {
			wc.countFromReader(new BufferedReader(new FileReader("res/file.txt")));
		} catch (FileNotFoundException e) { e.printStackTrace(); }
		wc.printOrdered(System.out);
	}

}
