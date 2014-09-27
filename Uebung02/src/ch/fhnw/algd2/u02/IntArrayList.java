/**
 * 
 */
package ch.fhnw.algd2.u02;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Christoph Stamm
 *
 */
public class IntArrayList extends AbstractList<Integer> {
	public int[] m_array;
	public int m_size;
	
	public IntArrayList() {
		this(16);
	}
	
	public IntArrayList(int capacity) {
		m_array = new int[capacity];
	}
	
	public int getInt(int index) {
		if (index < 0 || index >= m_size) throw new IndexOutOfBoundsException();
		return m_array[index];
	}
	
    public int set(int index, int element) {
		if (index < 0 || index >= m_size) throw new IndexOutOfBoundsException();

		int old = m_array[index];
        m_array[index] = element;
        return old;
    }
    
	public void add(int val) {
		ensureCapacity();
		m_array[m_size++] = val;
	}
	
	public int remove() {
		if (m_size == 0) throw new IndexOutOfBoundsException();
		return m_array[--m_size];
	}
	
	public int binarySearch(int key) {
		return Arrays.binarySearch(m_array, 0, m_size, key);
	}
	
	public int binarySearch(int startInclusive, int endExclusive, int key) { //Will result in chaos, if called without sorting it first
		if (startInclusive < 0 || startInclusive > m_size) throw new IndexOutOfBoundsException();
		if (endExclusive   < 0 || endExclusive   > m_size) throw new IndexOutOfBoundsException();
		return Arrays.binarySearch(m_array, startInclusive, endExclusive, key);
	}
	
	public void reverse() {
		int last = m_size - 1;
		for(int i=0; i < m_size/2; i++) {
			int t = m_array[i]; m_array[i] = m_array[last - i]; m_array[last - i] = t;
		}
	}
	
	public void sort() {
		Arrays.sort(m_array, 0, m_size);
	}
	
	public void sort(int startInclusive, int endExclusive) {
		if (startInclusive < 0 || startInclusive > m_size) throw new IndexOutOfBoundsException();
		if (endExclusive   < 0 || endExclusive   > m_size) throw new IndexOutOfBoundsException();
		Arrays.sort(m_array, startInclusive, endExclusive);
	}
	
	public void parallelSort() {
		Arrays.parallelSort(m_array, 0, m_size);
	}
	
	public void parallelSort(int startInclusive, int endExclusive) {
		if (startInclusive < 0 || startInclusive > m_size) throw new IndexOutOfBoundsException();
		if (endExclusive   < 0 || endExclusive   > m_size) throw new IndexOutOfBoundsException();
		Arrays.parallelSort(m_array, startInclusive, endExclusive);
	}
	
	public IntStream toIntStream() {
		return Arrays.stream(m_array, 0, m_size);
	}
	
	public IntStream toIntStream(int startInclusive, int endExclusive) {
		if (startInclusive < 0 || startInclusive > m_size) throw new IndexOutOfBoundsException();
		if (endExclusive   < 0 || endExclusive   > m_size) throw new IndexOutOfBoundsException();
		return Arrays.stream(m_array, startInclusive, endExclusive);
	}
	
	public int[] toIntArray() {
		return Arrays.copyOf(m_array, m_size);
	}
	
	public int[] toIntArray(int startInclusive, int endExclusive) {
		if (startInclusive < 0 || startInclusive > m_size) throw new IndexOutOfBoundsException();
		if (endExclusive   < 0 || endExclusive   > m_size) throw new IndexOutOfBoundsException();
		return Arrays.copyOfRange(m_array, startInclusive, endExclusive);
	}

	@Override
	public int size() {
		return m_size;
	}

	@Override
	public void clear() {
		//Only done this way, because the array stores primitives
		//(if it had stored objects, every element would have to be set to null because of the gc) 
		m_size = 0;
	}
	
	@Override
	public Integer get(int index) {
		if (index < 0 || index > m_size) throw new IndexOutOfBoundsException();
		return m_array[index];
	}

	@Override
    public Integer set(int index, Integer element) {
		if (index < 0 || index > m_size) throw new IndexOutOfBoundsException();
		m_array[index] = element;
		return element;
    }
	
	/**
	 * Partly unsupported operation. Inserting only at the end of the list.
	 */
	@Override
    public void add(int index, Integer element) { //Not what I would do
		if(index != m_size){ throw new RuntimeException(); } //TODO: Change exception type
		add(element.intValue());
    }
	
	/**
	 * Partly unsupported operation. Removing only at the end of the list.
	 */
	@Override
    public Integer remove(int index) {
		if(index != m_size){ throw new RuntimeException(); } //TODO: Change exception type
		return remove();
    }
	
	/**
	 * Makes sure that the capacity of the array is large enough
	 */
	private void ensureCapacity() {
		if(m_size >= m_array.length){
			int[] newArray = new int[m_array.length * 2 + 1];
			System.arraycopy(m_array, 0, newArray, 0, m_array.length);
			m_array = newArray;
		}
	}
}
