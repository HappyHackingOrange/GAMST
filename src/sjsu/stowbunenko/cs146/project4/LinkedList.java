package sjsu.stowbunenko.cs146.project4;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Self-made singly linked list which each node only points to next node.
 *
 * @author Vincent Stowbunenko
 * 
 **/

public class LinkedList<Item> implements Iterable<Item> {

	// Instance variables
	private Node head;
	private int size;

	/**
	 * A node class.
	 */
	public class Node {

		// Instance variables
		Item item;
		Node next;

		/**
		 * Creates a node containing an item and is pointing to next node.
		 * 
		 * @param item
		 *            the item to be inserted after creating a node
		 * @param next
		 *            the next node to point to
		 */
		public Node(Item item, Node next) {
			this.item = item;
			this.next = next;
		}

	}
	
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
	public void push(Item item) {
		head = new Node(item, head);
		size++;
	}

	/**
	 * Iterator is added so that this class can use foreach loop
	 */
	@Override
	public Iterator<Item> iterator() {
		
		return new Iterator<Item>() {

			private Node currentNode = head;

			@Override
			public boolean hasNext() {
				return currentNode != null;
			}

			@Override
			public Item next() {
				if (currentNode == null)
					throw new NoSuchElementException();
				Item currentItem = currentNode.item;
				currentNode = currentNode.next;
				return currentItem;
			}

		};

	}

}