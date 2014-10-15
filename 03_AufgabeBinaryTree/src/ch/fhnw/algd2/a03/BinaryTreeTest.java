package ch.fhnw.algd2.a03;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {

	BinaryTree t1, t2, t3;
	@Before
	public void setUp() throws Exception {
		t1 = new BinaryTree();
		t2 = new BinaryTree();
		t2.insert(5);
		t3 = new BinaryTree();
		t3.insert(10);
			t3.insert(5);
				t3.insert(2);
				t3.insert(7);
			t3.insert(15);
				t3.insert(12);
				t3.insert(17);
	}

	@Test
	public void testEmpty(){
		assertFalse(t1.remove(5));
		assertFalse(t1.search(5));
	}

	@Test
	public void testInsert(){
		//Test no exception, rest is tested in testSearch
		t1.insert(5);
		t1.insert(2);
		t1.insert(3);
		t1.insert(10);
	}

	@Test
	public void testSearch(){
		assertTrue(t2.search(5));
		assertFalse(t2.search(6));
		assertFalse(t2.search(4));

		assertTrue(t3.search(10));
		assertTrue(t3.search(5));
		assertTrue(t3.search(2));
		assertTrue(t3.search(7));
		assertTrue(t3.search(15));
		assertTrue(t3.search(12));
		assertTrue(t3.search(17));
		assertFalse(t3.search(6));
		assertFalse(t3.search(4));
	}

	@Test
	public void testRemove(){
		assertFalse(t2.remove(4));
		assertFalse(t2.remove(6));
		assertTrue(t2.search(5));
		assertTrue(t2.remove(5));
		assertFalse(t2.search(5));
		assertFalse("Can't remove a value twice", t2.remove(5));

		assertFalse(t3.remove(4));
		assertFalse(t3.remove(6));
		assertTrue(t3.search(5));
		assertTrue(t3.remove(5));
		assertFalse(t3.search(5));

		assertTrue(t3.search(10));
//		assertTrue(t3.search(5)); all expect this one
		assertTrue(t3.search(2));
		assertTrue(t3.search(7));
		assertTrue(t3.search(15));
		assertTrue(t3.search(12));
		assertTrue(t3.search(17));
		assertFalse(t3.search(6));
		assertFalse(t3.search(4));

		assertTrue(t3.remove(17));
		assertFalse(t3.search(17));
		assertFalse(t3.remove(17));

		assertTrue(t3.search(10));
//		assertTrue(t3.search(5));
		assertTrue(t3.search(2));
		assertTrue(t3.search(7));
		assertTrue(t3.search(15));
		assertTrue(t3.search(12));
//		assertTrue(t3.search(17));
		assertFalse(t3.search(6));
		assertFalse(t3.search(4));

		assertTrue(t3.remove(10));
		assertFalse(t3.search(10));
		assertFalse(t3.remove(10));

//		assertTrue(t3.search(10));
//		assertTrue(t3.search(5));
		assertTrue(t3.search(2));
		assertTrue(t3.search(7));
		assertTrue(t3.search(15));
		assertTrue(t3.search(12));
//		assertTrue(t3.search(17));
		assertFalse(t3.search(6));
		assertFalse(t3.search(4));
	}
}
