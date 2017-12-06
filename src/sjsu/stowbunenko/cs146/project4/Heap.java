package sjsu.stowbunenko.cs146.project4;

/**
 * A min-heap structure, represented by an array.
 * 
 * @author Vincent Stowbunenko
 *
 */
public class Heap {

	private Vertex[] array;
	private int size; // the size of the heap with valid elements (not the length of the array)

	// Constructors

	public Heap(int capacity) {
		array = new Vertex[capacity];
		for (int i = 0; i < capacity; i++)
			array[i] = new Vertex();
		size = 0;
	}

	public Heap(double[] array) {
		this.array = new Vertex[array.length];
		for (int i = 0; i < array.length; i++) {
			this.array[i] = new Vertex(array[i]);
		}
		size = array.length;
	}

	// Getters and setters

	public double[] getKeyArray() {
		double[] array = new double[this.array.length];
		for (int i = 0; i < array.length; i++)
			array[i] = this.array[i].key;
		return array;
	}

	public void setKeyArray(double[] array) {
		for (int i = 0; i < array.length; i++)
			this.array[i].key = array[i];
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
		Vertex temp = array[index1];
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
		int smallest = (leftChild <= size && array[leftChild].key < array[index].key) ? leftChild : index;
		if (rightChild <= size - 1 && array[rightChild].key < array[smallest].key)
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
		setKeyArray(array);
		for (int i = size / 2 - 1; i >= 0; i--)
			heapify(i);
	}

	/**
	 * Decreases the value of the key to a new value.
	 * 
	 * @param key
	 */
	public void decreaseKey(int i, double newValue) {
		if (newValue > array[i].key)
			throw new Error("new key is larger than current key");
		array[i].key = newValue;
		while (i > 0 && array[getParent(i)].key > array[i].key) {
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
		array[++size - 1].key = Double.MAX_VALUE;
		decreaseKey(size - 1, element);
	}

	/**
	 * Gets the minimum element from the heap.
	 * 
	 * @return the minimum element
	 */
	public Vertex getMin() {
		return array[0];
	}

	/**
	 * Extracts the minimum element from the heap.
	 * 
	 * @return the extracted minimum element.
	 */
	public Vertex extractMin() {
		if (array.length < 1)
			throw new Error("heap underflow");
		Vertex min = array[0];
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
			if (array[i].key == element)
				return true;
		}
		return false;
	}

}
