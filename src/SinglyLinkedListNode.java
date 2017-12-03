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

	/**
	 * Creates a node containing an item and not pointing to next root.
	 * 
	 * @param item
	 *            the item to be inserted after creating a node
	 */
	public SinglyLinkedListNode(Item item) {
		this.item = item;
		next = null;
	}

	/**
	 * Creates a node containing an item and is pointing to next node.
	 * 
	 * @param item
	 *            the item to be inserted after creating a node
	 * @param next
	 *            the next node to point to
	 */
	public SinglyLinkedListNode(Item item, SinglyLinkedListNode<Item> next) {
		this.item = item;
		this.next = next;
	}

	// Instance methods

	/**
	 * An item getter.
	 * 
	 * @return the item containing in the node
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * A next getter.
	 * 
	 * @return the next node that the node is pointing to
	 */
	public SinglyLinkedListNode<Item> getNext() {
		return next;
	}

}