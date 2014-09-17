package ch.fhnw.algd2.u01;

public class Counter {
	private int value = 0;
	public Counter(int init){ value = init; }
	public int get(){ return value; }
	public void inc(){ ++value; }
	@Override
	public String toString() {
		return String.format("%d", value);
	}
}
