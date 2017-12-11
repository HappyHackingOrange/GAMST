package sjsu.stowbunenko.cs146.project4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.*;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * 
 * @author Vincent Stowbunenko
 *
 */
class HeapTester {

	private ArrayList<Integer> testArrayList;

	/**
	 * Run this code before each test.
	 */
	@BeforeEach
	public void runBeforeTests() {
		testArrayList = new ArrayList<>(Arrays.asList(38, 3, 33, 36, 5, 70, 24, 47, 7, 27, 15, 48, 53, 32, 93));
	}

	/**
	 * Tests the getting of the parent.
	 */
	@Test
	public void testGetParent() {
		assertEquals(3, testArrayList.get(Heap.getParent(4)).intValue());
	}

	/**
	 * Tests the getting of the left child.
	 */
	@Test
	public void testGetLeftChild() {
		assertEquals(27, testArrayList.get(Heap.getLeftChild(4)).intValue());
	}

	/**
	 * Tests the getting of the right child.
	 */
	@Test
	public void testGetRightChild() {
		assertEquals(15, testArrayList.get(Heap.getRightChild(4)).intValue());
	}

	/**
	 * Tests the swapping of two nodes.
	 */
	@Test
	public void testSwap() {
		Heap heap = new Heap(testArrayList);
		heap.swap(1, 13);
		ArrayList<Integer> expected = new ArrayList<>(
				Arrays.asList(38, 32, 33, 36, 5, 70, 24, 47, 7, 27, 15, 48, 53, 3, 93));
		assertEquals(expected, heap.getHeapArray());
	}

	/**
	 * Tests the heapifying of a heap starting at root.
	 */
	@Test
	public void testHeapify() {
		Heap heap = new Heap(testArrayList);
		heap.heapify(0);
		ArrayList<Integer> expected = new ArrayList<>(
				Arrays.asList(3, 5, 33, 36, 15, 70, 24, 47, 7, 27, 38, 48, 53, 32, 93));
		assertEquals(expected, heap.getHeapArray());
	}

	/**
	 * Tests the decreasing of a key in the heap.
	 */
	@Test
	public void testDecreaseKey() {
		Heap heap = new Heap(testArrayList);
		heap.decreaseKey(11, 1);
		ArrayList<Integer> expected = new ArrayList<>(
				Arrays.asList(1, 5, 3, 7, 15, 24, 32, 47, 36, 27, 38, 48, 53, 33, 93));
		assertEquals(expected, heap.getHeapArray());
	}

	/**
	 * Tests the inserting of an element to the heap.
	 */
	@Test
	public void testInsert() {
		Heap heap = new Heap(testArrayList.length + 1);
		double[] expected = new double[] { 1, 3, 24, 5, 15, 48, 32, 7, 36, 27, 38, 70, 53, 33, 93, 47 };
		heap.build(testArrayList);
		heap.insert(1);
		assertEquals(16, heap.getSize());
		assertArrayEquals(expected, heap.getKeyArray());
	}

	/**
	 * Test the getting the minimum element of the heap.
	 */
	@Test
	public void testGetMin() {
		Heap heap = new Heap(testArrayList.length);
		heap.build(testArrayList);
		assertEquals(3, heap.getMin().key);
		assertEquals(15, heap.getSize());
	}

	/**
	 * Tests the extracting of the minimum element of the heap.
	 */
	@Test
	public void testExtractMin() {
		Heap heap = new Heap(testArrayList.length);
		double[] expected = new double[] { 5, 7, 24, 36, 15, 48, 32, 47, 93, 27, 38, 70, 53, 33, 93 };
		heap.build(testArrayList);
		assertEquals(3, heap.extractMin().key);
		assertArrayEquals(expected, heap.getKeyArray());
		assertEquals(14, heap.getSize());
	}

	/**
	 * Tests the contains method.
	 */
	@Test
	public void testContains() {
		Heap heap = new Heap(testArrayList.length);
		heap.build(testArrayList);
		assertTrue(heap.contains(33));
		assertFalse(heap.contains(1));
	}

}
