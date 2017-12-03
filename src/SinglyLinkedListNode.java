/* SinglyLinkedListNode.java */

/**
 * Implements a node that stores an item and a pointer to the next node in the
 * singly linked list.
 * 
 * @author Vincent Stowbunenko
 * 
 */

public class SinglyLinkedListNode<E> {

	// Instance variables
	E item;
	SinglyLinkedListNode<E> next;

	// Constructors

	// Creates a node containing an item and not pointing to next root.
	public SinglyLinkedListNode(E e) {
		item = e;
		next = null;
	}

	// Creates a node containing an item and is pointing to next node.
	public SinglyLinkedListNode(E e, SinglyLinkedListNode<E> next) {
		item = e;
		this.next = next;
	}

	// Instance methods

	// Item getter
	public E getItem() {
		return item;
	}

	// Next getter
	public SinglyLinkedListNode<E> getNext() {
		return next;
	}

}