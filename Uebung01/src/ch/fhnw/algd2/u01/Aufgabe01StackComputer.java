package ch.fhnw.algd2.u01;

import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.function.BinaryOperator;

public class Aufgabe01StackComputer {

	private static Stack<Integer> s = new Stack<>();

	/**
	 * @param op
	 * @throws EmptyStackException If to few values are on the Stack
	 */
	private static void operate(BinaryOperator<Integer> op){
		int a = s.pop();
		a = op.apply(s.pop(), a);
		s.push(a);
	}

	public static void main(String[] args) {
		StackCalcState state = StackCalcState.BeforeIn;
		char in = ' ';
		int input = 0;
		while(state != StackCalcState.End){
			try {
				in = (char)System.in.read();
			} catch (IOException e) { e.printStackTrace(); }
			switch (state) {
				case BeforeIn:
					if(Character.isDigit(in)){
						input = Character.getNumericValue(in);
						state = StackCalcState.NumberIn;
					}
					else if(!Character.isWhitespace(in)){
						switch(in){
							case '+': operate((a, b) -> a + b); break;
							case '-': operate((a, b) -> a - b); break;
							case '/': operate((a, b) -> a / b); break;
							case '*': operate((a, b) -> a * b); break;
							default: state = StackCalcState.End; break;
						}
					} else if(in != ' ') {
						state = StackCalcState.End;
					}
					break;
				case NumberIn:
					if(Character.isDigit(in)){ input = (input * 10) + Character.getNumericValue(in); }
					else {
						s.push(input);
						state = StackCalcState.BeforeIn;
					}
					break;
				default: break;
			}
		}
		System.out.println(s.peek());
	}
}
