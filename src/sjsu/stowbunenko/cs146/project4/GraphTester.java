package sjsu.stowbunenko.cs146.project4;

import static org.junit.Assert.*;

import java.io.File;
import java.util.*;

import org.junit.jupiter.api.Test;

class GraphTester {

	/**
	 * Tests the loading of a graph text file.
	 */
	@Test
	public void testLoad() {
		Graph graph = new Graph("WeightedGraphExamples/tinyEWG.txt");
		StringBuilder strBldr = new StringBuilder();
		strBldr.append("0: (7, 0.16) (4, 0.38) (2, 0.26) (6, 0.58) \n");
		strBldr.append("1: (5, 0.32) (7, 0.19) (2, 0.36) (3, 0.29) \n");
		strBldr.append("2: (3, 0.17) (0, 0.26) (1, 0.36) (7, 0.34) (6, 0.40) \n");
		strBldr.append("3: (2, 0.17) (1, 0.29) (6, 0.52) \n");
		strBldr.append("4: (5, 0.35) (7, 0.37) (0, 0.38) (6, 0.93) \n");
		strBldr.append("5: (4, 0.35) (7, 0.28) (1, 0.32) \n");
		strBldr.append("6: (2, 0.40) (3, 0.52) (0, 0.58) (4, 0.93) \n");
		strBldr.append("7: (4, 0.37) (5, 0.28) (0, 0.16) (1, 0.19) (2, 0.34) \n");
		assertEquals(strBldr.toString(), graph.toString());
	}

	/**
	 * Finds the neighbors of the specific vertex and returns an ArrayList of
	 * Integers of the neighbors
	 */
	@Test
	void findNeighbors() {
		Graph graph = new Graph("WeightedGraphExamples/tinyEWG.txt");
		ArrayList<Pair> actuals = graph.findNeighbors(0);
		ArrayList<Pair> expecteds = new ArrayList<>();
		expecteds.add(new Pair(7, 0.16));
		expecteds.add(new Pair(4, 0.38));
		expecteds.add(new Pair(2, 0.26));
		expecteds.add(new Pair(6, 0.58));
		assertTrue(actuals.size() == expecteds.size());
		for (int i = 0; i < actuals.size(); i++) {
			Pair expected = expecteds.get(i);
			Pair actual = actuals.get(i);
			assertEquals(actual.destination, expected.destination);
			assertEquals(actual.weight, expected.weight, 1e-15);
		}
	}

	/**
	 * Tests to see if the edge has been added to the list
	 */
	@Test
	void addtheEdge() {
//		Graph graph = new Graph();
//		graph.addEdge(0, 4, 0.38);
//		assertEquals("0: (4, 0.38) \n4: (0, 0.38) \n", graph.toString());
	}

	/**
	 * Tests for Depth-First Search and the order it finds its neighbors
	 */
	// @Test
	void testDFS() {

	}

	/**
	 * Tests to find the minimum spanning tree
	 */
	// @Test
	void testPrim() {

	}

	/**
	 * Tests the new algorithm which incorporates DFS
	 */
	// @Test
	void testnewAlgorithm() {

	}
}