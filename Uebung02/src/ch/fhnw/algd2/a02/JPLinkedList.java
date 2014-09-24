package ch.fhnw.algd2.a02;

public class JPLinkedList<E> {
	private ListElement<E> top = null;
	public ListElement<E> insertElement(ListElement<E> e,  E data){
		if(e.parent != this){ throw new IllegalArgumentException(); }
		ListElement<E> newElement = new ListElement<E>(this, data);
		if(e.next != null){
			e.next.prev = newElement;
			newElement.next = e.prev;
		}
		e.next = newElement;
		newElement.prev = e;
		return newElement;
	}
	public ListElement<E> remove(ListElement<E> e){
		if(e.parent != this){ throw new IllegalArgumentException(); }
		if(e.prev != null){ e.prev.next = e.next; }
		if(e.next != null){ e.next.prev = e.prev; }
		if(e == top){ top = e.next; }
		return e;
	}
	public ListElement<E> top(){ return top; }
	public ListElement<E> pop(){
		ListElement<E> old = top;
		top = top == null ? null : top.next;
		return old;
	}
	public JPLinkedList<E> push(E data){
		ListElement<E> newElement = new ListElement<>(this, data, top, null);
		top.prev = newElement;
		top = newElement;
		return this;
	}
}
