package ch.fhnw.algd2.a02;

public class ListElement<E> {
	//internal properties (default access modifier)
	E data;
	ListElement<E> next, prev;
	JPLinkedList<E> parent;
	ListElement(JPLinkedList<E> parent, E data, ListElement<E> next, ListElement<E> prev) {
		this.parent = parent;
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
	ListElement(JPLinkedList<E> parent, E data) {
		this.parent = parent;
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	public E get(){ return data; }
	public ListElement<E> next(){ return next; }
	public ListElement<E> prev(){ return prev; }
}
