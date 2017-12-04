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
	ArrayList<LinkedList<Pair<Integer, Double>>> adjacencyList;
	ArrayList<Pair<Integer, Double>> queue;
	private int edge;
	private int vertices;

	public Graph() {
		adjacencyList = new ArrayList<LinkedList<Pair<Integer, Double>>>(10000);
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
		Pair<Integer, Double> pair = new Pair<Integer, Double>(destination, weight);
		adjacencyList.get(source).add(pair);
	}

	
	
	
	/**
	 * This finds the neighbors of the source
	 * 
	 * @return an ArrayList of neighbors from the source
	 */
	public ArrayList<Pair<Integer, Double>> findNeighbors(int source) {
		ArrayList<Pair<Integer, Double>> neighbors = new ArrayList<Pair<Integer, Double>>();
		for (Pair<Integer, Double> current : adjacencyList.get(source)) {
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
	 * slides
	 * Each pair should have the property of the boolean "reached" to determine if it
	 * has been explored or not.
	 * 
	 * @param graph
	 * @param weight
	 * @param vertex
	 */
	public Graph Prim(double weight, int vertex) {
		// Queue of vertices
		Graph mingraph = new Graph();
		int current = vertex;
		while(!queue.isEmpty()) {
			current = ExtractMinimumEdge(current).x;
			
		}
		return mingraph;
	}

	
	
	/**
	 * This will find the minimum edge out of the queue (temporarily using
	 * ArrayList even though it looks horrendous)
	 * 
	 * @param source
	 * @param previous
	 * @return
	 */
	public Pair<Integer, Double> ExtractMinimumEdge(int source) {
		ArrayList<Pair<Integer, Double>> neighbors = findNeighbors(source);
		int counter = 0;
		int indexNeighbor = 0;
		int indexQueue = 0;
		Pair<Integer, Double> minEdgeNeighbor = neighbors.get(0);
		Pair<Integer, Double> minQueue = queue.get(0);
		for (Pair<Integer, Double> current : neighbors) {
			counter++;
			if (current.y < minEdgeNeighbor.y) {
				indexNeighbor = counter;
				minEdgeNeighbor = current;
			}
		}
		counter = 0;
		for (Pair<Integer, Double> current : queue) {
			counter++;
			if (current.y < minQueue.y) {
				indexQueue = counter;
				minQueue = current;
			}
		}
		if (minEdgeNeighbor.y < minQueue.y) {
			neighbors.remove(indexNeighbor);
			for(Pair<Integer,Double> current: neighbors)
				queue.add(current);
			return minEdgeNeighbor;
		} else {
			for(Pair<Integer,Double> current: neighbors)
				queue.add(current);
			queue.remove(indexQueue);
			return minQueue;
		}
	}

	/**
	 * Determines if this destination has been reached or not
	 * 
	 * @param source
	 * @return
	 */
	public boolean hasBeenReached(Pair<Integer, Double> minimumEdge) {
		return minimumEdge.reached;
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
			stringBuilder.append(String.format("%d: ", i));
			for (Pair<Integer, Double> pair : adjacencyList.get(i))
				stringBuilder.append(String.format("(%d, %f) ", pair.x, pair.y));
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}

}