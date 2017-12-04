package sjsu.stowbunenko.cs146.project4;

import java.util.*;

/**
 * A min-heap structure, represented by an array.
 * 
 * @author Vincent Stowbunenko
 *
 */
public class Heap {

	private int[] array;
	private int size; // current size
	private int capacity; // max possible size

	// Constructor
	public Heap(int capacity) {
		array = new int[capacity];
		size = 0;
		this.capacity = capacity;
	}

	/**
	 * Get the parent given index i of node.
	 * 
	 * @param i
	 *            the index i of the node
	 * @return the index of the parent
	 */
	public static int getParent(int i) {
		return (i - 1) / 2;
	}

	/**
	 * Get the left child given index i of the node.
	 * 
	 * @param i
	 *            the index i of the node
	 * @return the index of the left child
	 */
	public static int getLeft(int i) {
		return 2 * i + 1;
	}

	/**
	 * Get the right child given index i of the node.
	 * 
	 * @param i
	 *            the index i of the node
	 * @return the index of the right child
	 */
	public static int getRight(int i) {
		return 2 * i + 2;
	}

	/**
	 * Maintain min-heap property at subtree starting at index i.
	 */
	public void heapify(int index) {
		// TODO
	}

	/**
	 * Produce min-heap from unordered input array.
	 */
	public void build(int[] array) {
		// TODO
	}

	/**
	 * Sorts the array in place.
	 */
	public void sort() {
		// TODO
	}

	/**
	 * Inserts an element in the heap.
	 * 
	 * @param element
	 *            the element to be inserted in the heap
	 */
	public void insert(int element) {
		// TODO
	}

	/**
	 * Gets the minimum element from the heap.
	 * 
	 * @return the minimum element
	 */
	public int getMin() {
		return array[0];
	}

	/**
	 * Extracts the minimum element from the heap.
	 * 
	 * @return the extracted minimum element.
	 */
	public int extractMin() {
		if (array.length < 1) {
			throw new java.lang.Error("heap underflow");
		}
		int max = array[0];
		// TODO
		return max;
	}

	/**
	 * Decreases the value of the key to a new value.
	 * 
	 * @param key
	 */
	public void decreaseKey(int i, int newValue) {

	}

}
