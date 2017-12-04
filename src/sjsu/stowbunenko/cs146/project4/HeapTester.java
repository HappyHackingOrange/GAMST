package sjsu.stowbunenko.cs146.project4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

/**
 * 
 * @author Vincent Stowbunenko
 *
 */
class HeapTester {

	private int[] testArray;

	/**
	 * Run this code before each test.
	 */
	@BeforeEach
	public void runBeforeTests() {
		testArray = new int[] { 38, 3, 33, 36, 5, 70, 24, 47, 7, 27, 15, 48, 53, 32, 93 };
	}

	/**
	 * Tests the getting of the parent.
	 */
	@Test
	public void testGetParent() {
		assertEquals(3, testArray[Heap.getParent(4)]);
	}

	/**
	 * Tests the getting of the left child.
	 */
	@Test
	public void testGetLeftChild() {
		assertEquals(27, testArray[Heap.getLeftChild(4)]);
	}

	/**
	 * Tests the getting of the right child.
	 */
	@Test
	public void testGetRightChild() {
		assertEquals(15, testArray[Heap.getRightChild(4)]);
	}

	/**
	 * Tests the swapping of two nodes.
	 */
	@Test
	public void testSwap() {
		Heap heap = new Heap(testArray);
		int[] expected = new int[] { 38, 32, 33, 36, 5, 70, 24, 47, 7, 27, 15, 48, 53, 3, 93 };
		heap.swap(1,  13);
		assertArrayEquals(expected, heap.getArray());
	}
	
	/**
	 * Tests the heapifying of a heap starting at root.
	 */
	@Test
	public void testHeapify() {
		Heap heap = new Heap(testArray);
		int[] expected = new int[] { 3, 5, 33, 36, 15, 70, 24, 47, 7, 27, 38, 48, 53, 32, 93 };
		heap.heapify(0);
		assertArrayEquals(expected, heap.getArray());
	}

	/**
	 * Tests the building of a heap.
	 */
	@Test
	public void testBuild() {
		Heap heap = new Heap(testArray.length);
		int[] expected = new int[] { 3, 5, 24, 7, 15, 48, 32, 47, 36, 27, 38, 70, 53, 33, 93 };
		heap.build(testArray);
		assertArrayEquals(expected, heap.getArray());
	}

	/**
	 * Tests the decreasing of a key in the heap.
	 */
	@Test
	public void testDecreaseKey() {
		Heap heap = new Heap(testArray.length);
		int [] expected = new int[] {1, 5, 3, 7, 15, 24, 32, 47, 36, 27, 38, 48, 53, 33, 93};
		heap.build(testArray);
		heap.decreaseKey(11, 1);
		assertArrayEquals(expected, heap.getArray());
	}

	/**
	 * Tests the inserting of an element to the heap.
	 */
	@Test
	public void testInsert() {
		Heap heap = new Heap(testArray.length + 1);
		int[] expected = new int[] { 1, 3, 24, 5, 15, 48, 32, 7, 36, 27, 38, 70, 53, 33, 93, 47};
		heap.build(testArray);
		heap.insert(1);
		assertEquals(16, heap.getSize());
		assertArrayEquals(expected, heap.getArray());
	}
	
	/**
	 * Test the getting the minimum element of the heap.
	 */
	@Test
	public void testGetMin() {
		Heap heap = new Heap(testArray.length);
		heap.build(testArray);
		assertEquals(3, heap.getMin());
		assertEquals(15, heap.getSize());
	}
	
	/**
	 * Tests the extracting of the minimum element of the heap.
	 */
	@Test
	public void testExtractMin() {
		Heap heap = new Heap(testArray.length);
		int[] expected = new int[] {5, 7, 24, 36, 15, 48, 32, 47, 93, 27, 38, 70, 53, 33, 93};
		heap.build(testArray);
		assertEquals(3, heap.extractMin());
		assertArrayEquals(expected, heap.getArray());
		assertEquals(14, heap.getSize());
	}

}
