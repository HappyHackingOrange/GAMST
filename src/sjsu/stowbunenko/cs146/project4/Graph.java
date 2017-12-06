package sjsu.stowbunenko.cs146.project4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Undirected and weighted graph represented by adjacency list.
 * 
 * @author Vincent Stowbunenko
 *
 */
public class Graph {

	// Instance variables
	ArrayList<LinkedList<Pair<Vertex, Double>>> adjacencyList;
	ArrayList<Pair<Integer, Double>> queue;
	private int edge;
	private int vertices;

	public Graph() {
		adjacencyList = new ArrayList<LinkedList<Pair<Vertex, Double>>>(10001);
		for (int x = 0; x < 10001; x++) {
			adjacencyList.add(x, new LinkedList<Pair<Vertex, Double>>());
		}
		vertices = 0;
		edge = 0;
	}

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
		Vertex theSource = new Vertex(source,destination);
		Vertex theDestination = new Vertex(destination,source);
		Pair<Vertex, Double> pair = new Pair<Vertex, Double>(theSource, weight);
		Pair<Vertex, Double> reversePair = new Pair<Vertex, Double>(theDestination, weight);
		adjacencyList.get(source).add(pair);
		adjacencyList.get(destination).add(reversePair);
	}

	/**
	 * This finds the neighbors of the source
	 * 
	 * @return an ArrayList of neighbors from the source
	 */
	public ArrayList<Pair<Vertex, Double>> findNeighbors(int source) {
		ArrayList<Pair<Vertex, Double>> neighbors = new ArrayList<Pair<Vertex, Double>>();
		for (Pair<Vertex, Double> current : adjacencyList.get(source)) {
			neighbors.add(current);
		}
		return neighbors;
	}

	/**
	 * Loads the the data from the file for testing and saves into the graph
	 * 
	 * @param input
	 */
	public void load(File input) {
		String line = "";
		try {
			FileReader fr = new FileReader(input);
			BufferedReader br = new BufferedReader(fr);
			vertices = Integer.parseInt(br.readLine());
			edge = Integer.parseInt(br.readLine());
			while ((line = br.readLine()) != null) {
				String[] data = line.split(" ");
				addEdge(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Double.parseDouble(data[2]));
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!: " + e);
		} catch (IOException s) {
			System.out.println("IOException: " + s);
		}
	}

	/**
	 * Explores all the vertices in the order of exploring the newly discovered
	 * vertex
	 */
	public void DFS(Graph graph, double weight, int vertex) {

	}

	/**
	 * Prim's algorithm based on what the Professor has given according to the
	 * slides Each pair should have the property of the boolean "reached" to
	 * determine if it has been explored or not.
	 *
	 * Prim's algorithm based on what the Professor has given according to the
	 * slides
	 * 
	 * @param graph
	 * @param weight
	 * @param vertex
	 */

	public Graph Prim(double weight, int vertex) {
		// Queue of vertices
		Graph mingraph = new Graph();
		int current = vertex;
		while (!queue.isEmpty()) {
			current = ExtractMinimumEdge(current).x.destination;

		}
		return mingraph;
	}


	
	
	/**
	 * This will find the minimum edge out of the queue (temporarily using ArrayList
	 * even though it looks horrendous)
	 * 
	 * @param source
	 * @param previous
	 * @return
	 */
	public Pair<Vertex, Double> ExtractMinimumEdge(int source) {
		
	}


	/**
	 * Sort the edges in descending order according to their weights for each edge
	 * 
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
			if (adjacencyList.get(i).peek() != null) {
				stringBuilder.append(String.format("%d: ", i));
				for (Pair<Vertex, Double> pair : adjacencyList.get(i))
					stringBuilder.append(String.format("(%d, %.2f) ", pair.x.destination, pair.y));
				stringBuilder.append("\n");
			}
		}
		return stringBuilder.toString();
	}

}