package ch.fhnw.algd2.u02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Aufgabe02Mittelwert {
	public Clock test(){
		Clock c = new Clock();
		c.start();
		IntArrayList array = new IntArrayList();
		for(int i = 0; i < 100000; ++i){
			array.add(i);
		}
		Collections.shuffle(array);
		array.sort();
		c.stop();
		return c;
	}
	public static void main(String[] args){
		List<Clock> clocks = new ArrayList<>();
		Aufgabe02Mittelwert a = new Aufgabe02Mittelwert();
		for(int i = 0; i < 100; ++i){
			clocks.add(a.test());
		}
		Clock ref = clocks.get(50);
		System.out.println(clocks.stream().mapToInt(c -> c.getMillis()).summaryStatistics());
		System.out.println(clocks.stream().filter(c -> !c.tookMuchLongerThan(ref)).mapToInt(c -> c.getMillis()).summaryStatistics());
	}
}
