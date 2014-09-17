package ch.fhnw.algd2.u01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Aufgabe01Kopfbahnhof {
	private Stack<TrainType> s1 = new Stack<>(); //As at the end
	private Stack<TrainType> s2 = new Stack<>(); //Bs at the end
	private Stack<TrainType> s3 = new Stack<>();

	private void readStack(Stack<TrainType> s, BufferedReader reader) throws IOException {
		System.out.print("Stack: ");
		String line = reader.readLine();
		line.chars().mapToObj(c -> Character.toUpperCase(c) == 'A' ? TrainType.A : TrainType.B).forEach(t -> s.push(t));
	}

	public void readInput() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			readStack(s1, reader);
			readStack(s2, reader);
			readStack(s3, reader);
		} catch (IOException e) { e.printStackTrace(); }
	}

	/**
	 * Sorts the stacks: All As to S1, all Bs to S2
	 */
	public void sort(){
		while(!s1.isEmpty()){ s3.push(s1.pop()); }
		while(!s2.isEmpty()){ (s2.peek() == TrainType.A ? s1 : s3).push(s2.pop()); }
		while(!s3.isEmpty()){ (s3.peek() == TrainType.A ? s1 : s2).push(s3.pop()); }
	}

	public static void main(String[] args) {
		Aufgabe01Kopfbahnhof obj = new Aufgabe01Kopfbahnhof();
		obj.readInput();
		obj.sort();
		System.out.println("S1: " + obj.s1);
		System.out.println("S2: " + obj.s2);
		System.out.println("S3: " + obj.s3);
	}
}
