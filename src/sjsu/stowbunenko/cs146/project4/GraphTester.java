package sjsu.stowbunenko.cs146.project4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class GraphTester {

	/**
	 * Finds the neighbors of the specific vertex and returns an ArrayList of Integers of the neighbors
	 */
	//@Test
	void findNeighbors(){
		Graph graph = new Graph();
		int vertice = 1; // using file ""tinyEWG.txt" for the neighbors
		ArrayList<Integer> results = new ArrayList<Integer>(4);
		results.add(5);
		results.add(7);
		results.add(2);
		results.add(3);
		for(int current: results ) {
			assertTrue(graph.findNeighbors(vertice).contains(current));
		}
	}
	
	/**
	 * Tests to see if the edge has been added to the list
	 */
	@Test
	void addtheEdge() {
		Graph graph = new Graph();
		graph.addEdge(0, 4, 0.38);
		assertEquals("0: (4, 0.38)\n 4: (0, 0.38)",graph.toString());		
	}
	
	/**
	 * Tests for Depth-First Search and the order it finds its neighbors
	 */
	//@Test
	void testDFS() {
		
	}
	
	/**
	 * Tests to find the minimum spanning tree
	 */
	//@Test
	void testPrim() {
		
	}
	
	/**
	 * Tests the new algorithm which incorporates DFS
	 */
	//@Test
	void testnewAlgorithm() {
		
	}
}