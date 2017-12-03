/**
 * Creates a singly linked list which each node only points to next node.
 *
 * @author Vincent Stowbunenko
 * 
 **/

public class SinglyLinkedList<Item> {

	// Instance variables
	private SinglyLinkedListNode<Item> head;
//	private SinglyLinkedListNode<Item> tail;
	private int size;

	// Instance methods

	/**
	 * Checks if the list is empty.
	 * 
	 * @return boolean value of whether the list is empty or not
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Gets the size of the list.
	 * 
	 * @return the size of the list
	 */
	public int length() {
		return size;
	}

	/**
	 * Adds a node to the front of the list.
	 * 
	 * @param item
	 *            the item to be inserted to the front of the list
	 */
	public void insertFront(Item item) {
		head = new SinglyLinkedListNode<Item>(item, head);
//		if (tail == null)
//			tail = head;
		size++;
	}

//	/**
//	 * Adds a node to the back of the list.
//	 * 
//	 * @param item
//	 *            the item to be inserted to the back of the list
//	 */
//	public void insertEnd(Item item) {
//		if (head == null)
//			tail = head = new SinglyLinkedListNode<Item>(item);
//		else {
//			tail.next = new SinglyLinkedListNode<Item>(item);
//			tail = tail.next;
//		}
//		size++;
//	}

	/**
	 * Removes the node from the front of the list.
	 * 
	 * @return the node that was removed from the list
	 */
	public Item removeFront() {
		if (isEmpty())
			return null;
		SinglyLinkedListNode<Item> temp = head;
		head = (size == 1) ? null : temp.next;
		size--;
		return temp.item;
	}

}