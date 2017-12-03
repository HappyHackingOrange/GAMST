/**
 * Implements a node that stores an item and a pointer to the next node in the
 * singly linked list.
 * 
 * @author Vincent Stowbunenko
 * 
 */

public class SinglyLinkedListNode<Item> {

	// Instance variables
	Item item;
	SinglyLinkedListNode<Item> next;

	// Constructors

	// Creates a node containing an item and not pointing to next root.
	public SinglyLinkedListNode(Item item) {
		this.item = item;
		next = null;
	}

	// Creates a node containing an item and is pointing to next node.
	public SinglyLinkedListNode(Item item, SinglyLinkedListNode<Item> next) {
		this.item = item;
		this.next = next;
	}

	// Instance methods

	// Item getter
	public Item getItem() {
		return item;
	}

	// Next getter
	public SinglyLinkedListNode<Item> getNext() {
		return next;
	}

}