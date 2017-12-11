package sjsu.stowbunenko.cs146.project4;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A min-heap structure, represented by an array.
 * 
 * @author Vincent Stowbunenko
 *
 */
public class Heap {

	private ArrayList<Integer> heapArray;
	private HashMap<Integer, Vertex> vertexMap;

	// Constructors

	public Heap(HashMap<Integer, Vertex> vertexMap) {
		heapArray = new ArrayList<>();
		for (int vertexIndex = 0; vertexIndex < vertexMap.size(); vertexIndex++)
			heapArray.add(vertexIndex, vertexIndex);
		this.vertexMap = vertexMap;
		for (int vertexIndex : vertexMap.keySet())
			insert(vertexIndex);
	}

	// This constructor is for testing only
	public Heap(ArrayList<Integer> heapArray) {
		this.heapArray = heapArray;
		vertexMap = new HashMap<>();
		for (int heapIndex = 0; heapIndex < heapArray.size(); heapIndex++)
			vertexMap.put(heapArray.get(heapIndex), new Vertex(heapArray.get(heapIndex)));
	}

	// Getters and setters

	public ArrayList<Integer> getHeapArray() {
		return heapArray;
	}

	public int size() {
		return heapArray.size();
	}

	/**
	 * Get the parent given index i of node.
	 * 
	 * @param heapIndex
	 *            the index i of the node
	 * @return the index of the parent
	 */
	public static int getParent(int heapIndex) {
		return (heapIndex - 1) / 2;
	}

	/**
	 * Get the left child given index i of the node.
	 * 
	 * @param heapIndex
	 *            the index i of the node
	 * @return the index of the left child
	 */
	public static int getLeftChild(int heapIndex) {
		return 2 * heapIndex + 1;
	}

	/**
	 * Get the right child given index i of the node.
	 * 
	 * @param heapIndex
	 *            the index i of the node
	 * @return the index of the right child
	 */
	public static int getRightChild(int heapIndex) {
		return 2 * heapIndex + 2;
	}

	/**
	 * Swaps two heap nodes at index1 and index2.
	 * 
	 * @param heapIndex1
	 * @param heapIndex2
	 */
	public void swap(int heapIndex1, int heapIndex2) {
		int tempVertexIndex = heapArray.get(heapIndex1);
		heapArray.set(heapIndex1, heapArray.get(heapIndex2));
		heapArray.set(heapIndex2, tempVertexIndex);
	}

	/**
	 * Maintain min-heap property at subtree starting at index i.
	 *
	 * @param heapIndex
	 */
	public void heapify(int heapIndex) {

		int heapIndexSmallest = heapIndex;
		Vertex vertexCurrent = vertexMap.get(heapIndex);

		int heapIndexLeftChild = getLeftChild(heapIndex);
		if (heapIndexLeftChild < size()) {
			int vertexIndexLeftChild = heapArray.get(heapIndexLeftChild);
			Vertex vertexLeftChild = vertexMap.get(vertexIndexLeftChild);
			if (vertexLeftChild.key < vertexCurrent.key)
				heapIndexSmallest = heapIndexLeftChild;
		}

		int heapIndexRightChild = getRightChild(heapIndex);
		if (heapIndexRightChild < size()) {
			int vertexIndexRightChild = heapArray.get(heapIndexRightChild);
			Vertex vertexRightChild = vertexMap.get(vertexIndexRightChild);
//			if (vertexRightChild != null && vertexRightChild.key < vertexMap.get(heapArray.get(heapIndexSmallest)).key)
			if (vertexRightChild.key < vertexMap.get(heapArray.get(heapIndexSmallest)).key)
				heapIndexSmallest = heapIndexRightChild;
		}

		if (heapIndexSmallest != heapIndex) {
			swap(heapIndex, heapIndexSmallest);
			heapify(heapIndexSmallest);
		}
	}

	/**
	 * Decreases the value of the key to a new value.
	 * 
	 * @param heapIndex
	 * @param vertexIndex
	 */
	public void decreaseKey(int heapIndex, int vertexIndex) {
		if (vertexMap.get(vertexIndex).key > vertexMap.get(heapArray.get(heapIndex)).key)
			throw new Error("new key is larger than current key");
		heapArray.set(heapIndex, vertexIndex);
		while (heapIndex > 0 && vertexMap.get(heapArray.get(getParent(heapIndex))).key > vertexMap
				.get(heapArray.get(heapIndex)).key) {
			swap(heapIndex, getParent(heapIndex));
			heapIndex = getParent(heapIndex);
		}
	}

	/**
	 * Inserts a vertex in the heap.
	 * 
	 * @param vertex
	 *            the vertex to be inserted in the heap
	 */
	public void insert(int vertexIndex) {
		decreaseKey(size() - 1, vertexIndex);
	}

	/**
	 * Extracts the minimum element from the heap.
	 * 
	 * @return the extracted minimum element.
	 */
	public int extractMin() {
		if (size() < 1)
			throw new Error("heap underflow");
		int min = heapArray.get(0);
		int heapLastIndex = size() - 1;
		if (heapLastIndex == 0)
			heapArray.remove(0);
		else
			heapArray.set(0, heapArray.remove(heapLastIndex));
		heapify(0);
		return min;
	}

	/**
	 * Checks if the heap contains the element.
	 *
	 * @param element
	 * @return true if it contains, false otherwise
	 */
	public boolean contains(int vertexIndex) {
		for (int i = 0; i < size(); i++) {
			if (heapArray.get(i) == vertexIndex)
				return true;
		}
		return false;
	}

}
