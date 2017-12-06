package sjsu.stowbunenko.cs146.project4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Undirected and weighted graph represented by adjacency list.
 * 
 * @author Vincent Stowbunenko
 *
 */
public class Graph {

	// Instance variables
	ArrayList<LinkedList<Pair>> adjacencyList;
	ArrayList<Vertex> vertexList;
	private int edges;
	private int vertices;

	/**
	 * Constructs the graph from a graph file.
	 * 
	 * @param filename
	 *            the filename to load the graph.
	 */
	public Graph(String filename) {
		load(new File(filename));
	}

	/**
	 * Add a weighted edge to the graph.
	 * 
	 * @param source
	 *            the source vertex identified by an integer
	 * @param destination
	 *            the destination vertex identified by an integer
	 * @param weight
	 *            the weight on the edge between vertices u and v
	 */
	public void addEdge(int source, int destination, double weight) {
		adjacencyList.get(source).add(new Pair(destination, weight));
		adjacencyList.get(destination).add(new Pair(source, weight));
	}

	/**
	 * This finds the neighbors of the source
	 * 
	 * @param source
	 *            the source vertex identified by an integer
	 * @return an ArrayList of neighbors from the source
	 */

	public ArrayList<Pair> findNeighbors(int source) {
		ArrayList<Pair> neighbors = new ArrayList<Pair>();
		for (Pair pair : adjacencyList.get(source))
			neighbors.add(pair);
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
			adjacencyList = new ArrayList<>(vertices);
			vertexList = new ArrayList<>(vertices);
			for (int i = 0; i < vertices; i++) {
				adjacencyList.add(new LinkedList<>());
				vertexList.add(new Vertex());
			}
			edges = Integer.parseInt(br.readLine());
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
	 * slides This will return the ROOT vertex
	 * 
	 * @param weight
	 * @param vertex
	 */

	public Vertex mstPrim(double weight, int vertex) {
		// Queue of vertices
		return null;
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
		for (int i = 0; i < vertices; i++) {
			stringBuilder.append(String.format("%d: ", i));
			for (Pair pair : adjacencyList.get(i))
				stringBuilder.append(String.format("(%d, %.2f) ", pair.destination, pair.weight));
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}

}