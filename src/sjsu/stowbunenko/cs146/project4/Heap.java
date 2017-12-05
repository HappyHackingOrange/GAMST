package sjsu.stowbunenko.cs146.project4;

/**
 * A min-heap structure, represented by an array.
 * 
 * @author Vincent Stowbunenko
 *
 */
public class Heap {

	private double[] array;
	private int size; // the size of the heap with valid elements (not the length of the array)

	// Constructors

	public Heap(int capacity) {
		array = new double[capacity];
		size = 0;
	}

	public Heap(double[] array) {
		this.array = array;
		size = array.length;
	}

	// Getters and setters

	public double[] getArray() {
		return array;
	}

	public void setArray(double[] array) {
		this.array = array;
	}

	public int getSize() {
		return size;
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
	public static int getLeftChild(int i) {
		return 2 * i + 1;
	}

	/**
	 * Get the right child given index i of the node.
	 * 
	 * @param i
	 *            the index i of the node
	 * @return the index of the right child
	 */
	public static int getRightChild(int i) {
		return 2 * i + 2;
	}

	/**
	 * Swaps two heap nodes at index1 and index2.
	 * 
	 * @param index1
	 * @param index2
	 */
	public void swap(int index1, int index2) {
		double temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	/**
	 * Maintain min-heap property at subtree starting at index i.
	 * 
	 * @param index
	 */
	public void heapify(int index) {
		int leftChild = getLeftChild(index);
		int rightChild = getRightChild(index);
		int smallest = (leftChild <= size && array[leftChild] < array[index]) ? leftChild : index;
		if (rightChild <= size - 1 && array[rightChild] < array[smallest])
			smallest = rightChild;
		if (smallest != index) {
			swap(index, smallest);
			heapify(smallest);
		}
	}

	/**
	 * Produce min-heap from unordered input array.
	 * 
	 * @param array
	 *            the unordered input array
	 */
	public void build(double[] array) {
		size = array.length;
		System.arraycopy(array, 0, this.array, 0, size);
		for (int i = size / 2 - 1; i >= 0; i--)
			heapify(i);
	}

	/**
	 * Decreases the value of the key to a new value.
	 * 
	 * @param key
	 */
	public void decreaseKey(int i, double newValue) {
		if (newValue > array[i])
			throw new Error("new key is larger than current key");
		array[i] = newValue;
		while (i > 0 && array[getParent(i)] > array[i]) {
			swap(i, getParent(i));
			i = getParent(i);
		}
	}

	/**
	 * Inserts an element in the heap.
	 * 
	 * @param element
	 *            the element to be inserted in the heap
	 */
	public void insert(double element) {
		array[++size - 1] = Double.MAX_VALUE;
		decreaseKey(size - 1, element);
	}

	/**
	 * Gets the minimum element from the heap.
	 * 
	 * @return the minimum element
	 */
	public double getMin() {
		return array[0];
	}

	/**
	 * Extracts the minimum element from the heap.
	 * 
	 * @return the extracted minimum element.
	 */
	public double extractMin() {
		if (array.length < 1)
			throw new Error("heap underflow");
		double min = array[0];
		array[0] = array[--size];
		heapify(0);
		return min;
	}

	/**
	 * Checks if the heap contains the element.
	 * 
	 * @param element
	 * @return true if it contains, false otherwise
	 */
	public boolean contains(double element) {
		for (int i = 0; i < size; i++) {
			if (array[i] == element)
				return true;
		}
		return false;
	}

}
