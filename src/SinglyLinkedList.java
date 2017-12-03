/* SinglyLinkedList.java */

/**
 * Creates a singly linked list which each node only points to next node.
 *
 * @author Vincent Stowbunenko
 * 
 **/

public class SinglyLinkedList<E> {

	// Instance variables
	private SinglyLinkedListNode<E> head;
	private SinglyLinkedListNode<E> tail;
	private int size;

	// Instance methods

	// Checks if the list is empty.
	public boolean isEmpty() {
		return size == 0;
	}

	// Gets the size of the list.
	public int length() {
		return size;
	}

	// Adds a node to the front of the list.
	public void insertFront(E e) {
		head = new SinglyLinkedListNode<E>(e, head);
		if (tail == null)
			tail = head;
		size++;
	}

	// Adds a node to the back of the list.
	public void insertEnd(E e) {
		if (head == null)
			tail = head = new SinglyLinkedListNode<E>(e);
		else {
			tail.next = new SinglyLinkedListNode<E>(e);
			tail = tail.next;
		}
		size++;
	}

	// Removes a node from the front of the list.
	public E removeFront() {
		if (isEmpty())
			return null;
		SinglyLinkedListNode<E> temp = head;
		head = (size == 1) ? null : temp.next;
		size--;
		return temp.item;
	}

}