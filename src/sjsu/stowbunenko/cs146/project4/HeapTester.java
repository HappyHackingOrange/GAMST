package sjsu.stowbunenko.cs146.project4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class HeapTester {
	
	private Heap heap;

	@BeforeEach
	public void runBeforeTests() {
		heap = new Heap(new int[] { 38, 3, 33, 36, 5, 70, 24, 47, 7, 27, 15, 48, 53, 32, 93 });
	}

	@Test
	public void testHeapify() {
		int[] expected = new int[] { 3, 5, 33, 36, 15, 70, 24, 47, 7, 22, 38, 48, 53, 32, 93 };
		heap.heapify(0);
		assertArrayEquals(expected, heap.getArray());
	}

	@Test
	public void testBuild() {
		
	}

}
