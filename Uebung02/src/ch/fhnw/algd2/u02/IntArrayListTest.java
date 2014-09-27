package ch.fhnw.algd2.u02;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class IntArrayListTest {
	private final int size = 10000000;
	private List<Integer> list1, list2;
	private IntArrayList ilist;
	
	@Before
	public void setUp() throws Exception {
		list1 = new IntArrayList();
		list2 = new ArrayList<Integer>();
		ilist = (IntArrayList)list1;
	}

	@Test
	public void testAddInt() {
		System.out.println("Adding");
		Clock clock = new Clock();
		
		for(int i=0; i < size; i++) {
			list1.add(i);
		}
		clock.stop();
		System.out.println(clock);
		
		clock.start();
		for(int i=0; i < size; i++) {
			list2.add(i);
		}
		clock.stop();
		System.out.println(clock);
		
		equals();
	}

	@Test
	public void testGet() {
		fillIn();
		int i = 0;
		for(int val: ilist) {
			assertEquals((int)list2.get(i++), val);
		}
		equals();
	}
	
	@Test
	public void testRemove() {
		System.out.println("Removing");
		fillIn();
		Clock clock = new Clock();
		
		for(int i=list1.size() - 1; i >= 0; i--) {
			ilist.remove();
		}
		clock.stop();
		System.out.println(clock);
		
		clock.start();
		for(int i=list2.size() - 1; i >= 0; i--) {
			list2.remove(i);
		}
		clock.stop();
		System.out.println(clock);
		
		equals();
	}

	@Test
	public void testBinarySearch() {
		fillIn();
		assertEquals(Arrays.binarySearch(list2.toArray(), 99), ilist.binarySearch(99));
		assertEquals(Arrays.binarySearch(list2.toArray(), -45), ilist.binarySearch(-45));
	}

	@Test
	public void testSort() {
		System.out.println("Sorting");
		fillIn();
		ilist.reverse();
		
		Clock clock = new Clock();
		ilist.sort();
		clock.stop();
		System.out.println(clock);
		
		int last = list2.size() - 1;
		for(int i=0; i < list2.size()/2; i++) {
			int t = list2.get(i); list2.set(i, list2.get(last - i)); list2.set(last - i, t);
		}
		clock.start();
		Collections.sort(list2);;
		clock.stop();
		System.out.println(clock);
		
		equals();
	}

	@Test
	public void testParallelSort() {
		System.out.println("Parallel Sorting");
		fillIn();
		ilist.reverse();
		
		Clock clock = new Clock();
		ilist.parallelSort();
		clock.stop();
		System.out.println(clock);
		
		int last = list2.size() - 1;
		for(int i=0; i < list2.size()/2; i++) {
			int t = list2.get(i); list2.set(i, list2.get(last - i)); list2.set(last - i, t);
		}
		clock.start();
		Integer[] array = new Integer[list2.size()];
		array = list2.toArray(array);
		Arrays.parallelSort(array);
		for(int i=0; i < list2.size(); i++) {
			list2.set(i, array[i]);
		}
		clock.stop();
		System.out.println(clock);
		
		equals();
	}

	@Test
	public void testReverse() {
		fillIn();
		ilist.reverse();
		int i = list2.size() - 1;
		for(int val: ilist) {
			assertEquals(val, (int)list2.get(i--));
		}
	}
	
	@Test
	public void testIsEmpty() {
		assertTrue(ilist.isEmpty());
		assertTrue(list2.isEmpty());
	}
	
	private void fillIn() {
		for(int i=0; i < size; i++) {
			list1.add(i);
			list2.add(i);
		}
	}
	
	private void equals() {
		assertEquals(list2.size(), list1.size());
		assertArrayEquals(list2.toArray(), list1.toArray());
	}
}
