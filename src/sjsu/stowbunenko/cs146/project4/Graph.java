package sjsu.stowbunenko.cs146.project4;

import java.util.*;

/**
 * Undirected and weighted graph represented by adjacency list.
 * 
 * @author Vincent Stowbunenko
 *
 */
public class Graph {

	// Instance variables
	ArrayList<LinkedList<Pair<Integer, Double>>> adjacencyList;

	/**
	 * Add a weighted edge to the graph.
	 * 
	 * @param u
	 *            vertex u
	 * @param v
	 *            vertex v
	 * @param wt
	 *            the weight on the edge between vertices u and v
	 */
	public void addEdge(int source, int destination, double weight) {
		// TODO
	}

	/**
	 * String representation of the adjacency list of this graph.
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < adjacencyList.size(); i++) {
			stringBuilder.append(String.format("%d: ", i));
			for (Pair<Integer, Double> pair : adjacencyList.get(i))
				stringBuilder.append(String.format("(%d, %f) ", pair.x, pair.y));
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}

}
