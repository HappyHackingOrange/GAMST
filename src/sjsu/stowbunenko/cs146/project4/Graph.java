package sjsu.stowbunenko.cs146.project4;
import java.io.File;
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
		// Incomplete
		Pair<Integer, Double> pair = new Pair<Integer, Double>(destination, weight);
		adjacencyList.get(source).add(pair);
	}

	/**
	 * This finds the neighbors of the source
	 * 
	 * @return an ArrayList of neighbors from the source
	 */
	public ArrayList<Integer> findNeighbors(int source) {
		// Incomplete
		ArrayList<Integer> neighbors = new ArrayList<Integer>();
		return neighbors;
	}

	/**
	 * 
	 */
	public void load() {
		File tinyEWG = new File("WeightedGraphExamples/tinyEWG.txt");
	}

	/**
	 * Explores all the vertices in the order of exploring the newly discovered vertext
	 */
	public void DFS(Graph graph, double weight, int vertex) {

	}

	/**
	 * Prim's algorithm based on what the Professor has given according to the
	 * slides
	 * 
	 * @param graph
	 * @param weight
	 * @param vertex
	 */
	public Graph Prim(Graph graph, double weight, int vertex) {
		return graph;
	}

	/**
	 * Sort the edges in descending order according to their weights for each edge 
	 * @param graph
	 * @param weight
	 * @param vertex
	 * 
	 */
	public void newAlgorithm(Graph graph, double weight, int vertex) {

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