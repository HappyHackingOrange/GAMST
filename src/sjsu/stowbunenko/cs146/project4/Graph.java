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
	HashMap<Vertex, LinkedList<Pair<Vertex,Double>>> adjacencyList;
	private int edge;
	private int vertices;

	public Graph() {
		adjacencyList = new HashMap<Vertex, LinkedList<Pair<Vertex,Double>>>(10001);
		for (int x = 0; x < 10001; x++) {
			adjacencyList.put(new Vertex(), new LinkedList<Pair<Vertex, Double>>());
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
		Map<Vertex, LinkedList<Pair<Vertex,Double>>> map = adjacencyList;
		Vertex theSource = new Vertex(source);
		Vertex theDestination = new Vertex(destination);
		
		LinkedList<Pair<Vertex, Double>> neighbor = map.get(theSource);
		LinkedList<Pair<Vertex, Double>> neighborReturn = map.get(theDestination);
		
		Pair<Vertex, Double> pair = new Pair<Vertex, Double>(theSource, weight);
		Pair<Vertex, Double> reversePair = new Pair<Vertex, Double>(theDestination, weight);
		neighbor.add(reversePair);
		neighborReturn.add(pair);

	}

	/**
	 * This finds the neighbors of the source
	 * 
	 * @return an ArrayList of neighbors from the source
	 */
	public ArrayList<Pair<Vertex, Double>> findNeighbors(Vertex source) {
		Map<Vertex, LinkedList<Pair<Vertex,Double>>> map = adjacencyList;
		ArrayList<Pair<Vertex, Double>> neighbors = new ArrayList<Pair<Vertex, Double>>();
		for (Pair<Vertex, Double> current : map.get(source)) {
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
	 * This will return the ROOT vertex
	 * 
	 * @param graph
	 * @param weight
	 * @param vertex
	 */

	public Vertex Prim(double weight, int vertex) {
		// Queue of vertices
		
		
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
/*		Map<Vertex, LinkedList<Pair<Vertex,Double>>> map = adjacencyList;
		Set set = adjacencyList.entrySet();
		Iterator i = set.iterator();
		while(i.hasNext()) {
			Map.Entry entry = (Map.Entry)i.next();
			Vertex current = (Vertex) entry.getKey();
			stringBuilder.append(current.key + ": ");
			for(Pair<Vertex,Double> pair: (LinkedList) entry.getValue()) {
				
			}
		}*/
		
		
		/*
		for (int i = 0; i < adjacencyList.size(); i++) {
			if (adjacencyList.get(i).peek() != null) {
				stringBuilder.append(String.format("%d: ", i));
				for (Pair<Vertex, Double> pair : adjacencyList.get(i))
					stringBuilder.append(String.format("(%d, %.2f) ", pair.x, pair.y));
				stringBuilder.append("\n");
			}
		}*/
		return stringBuilder.toString();
	}

}