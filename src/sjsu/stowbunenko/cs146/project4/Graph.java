package sjsu.stowbunenko.cs146.project4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeSet;

/**
 * Undirected and weighted graph represented by adjacency list.
 * 
 * @author Vincent Stowbunenko
 *
 */
public class Graph {

	// Constants
	private static final int NIL = -1;

	// Instance variables
	private ArrayList<LinkedList<Pair>> adjacencyList;
	private HashMap<Integer, Vertex> vertexMap;
	private ArrayList<Edge> edgeList;
	private int edges;
	private int vertices;

	/**
	 * Constructs the graph from a graph file.
	 * 
	 * @param filename
	 *            the filename to load the graph.
	 */
	public Graph(String filename) {
		vertexMap = new HashMap<>();
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
	 * Add a weighted edge to the specified adjacencyList.
	 * 
	 * @param source
	 *            the source vertex identified by an integer
	 * @param destination
	 *            the destination vertex identified by an integer
	 * @param weight
	 *            the weight on the edge between vertices u and v
	 */
	public void addEdge(ArrayList<LinkedList<Pair>> adjacencyList, int source, int destination, double weight) {
		adjacencyList.get(source).add(new Pair(destination, weight));
		adjacencyList.get(destination).add(new Pair(source, weight));

	}

	/**
	 * This sorts the edges from greatest to least
	 * 
	 * @return
	 */
	public ArrayList<Edge> sortEdges() {
		TreeSet<Edge> sorting = new TreeSet<Edge>(edgeList);
		edgeList = new ArrayList<Edge>(sorting);
		ArrayList<Edge> returnSorted = new ArrayList<Edge>(sorting);
		return returnSorted;
	}

	/**
	 * This finds the neighbors of the source
	 * 
	 * @param source
	 *            the source vertex identified by an integer
	 * @return an ArrayList of neighbors from the source
	 */

	public ArrayList<Integer> findNeighbors(int source) {
		ArrayList<Integer> neighbors = new ArrayList<Integer>();
		for (Pair pair : adjacencyList.get(source))
			neighbors.add(pair.destination);
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
			edgeList = new ArrayList<Edge>(edges);
			for (int i = 0; i < vertices; i++) {
				adjacencyList.add(new LinkedList<>());
				vertexMap.put(i, new Vertex());
			}
			// visited = new boolean[vertexMap.size()];
			edges = Integer.parseInt(br.readLine());
			while ((line = br.readLine()) != null) {
				String[] data = line.split(" ");
				addEdge(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Double.parseDouble(data[2]));
				edgeList.add(
						new Edge(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Double.parseDouble(data[2])));
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
	public boolean isPartOfCycle(int currentVertexIndex, int endVertexIndex) {
		if (currentVertexIndex == endVertexIndex)
			return true;
		vertexMap.get(currentVertexIndex).setVisited(true);
		for (Pair nextVertex : adjacencyList.get(currentVertexIndex)) {
			int nextVertexIndex = nextVertex.destination;
			if (!vertexMap.get(nextVertexIndex).isVisited())
				if (isPartOfCycle(nextVertexIndex, endVertexIndex))
					return true;
		}
		return false;
	}

	/**
	 * Iterative version of isPartOfCycle
	 */
	public boolean isPartOfCycle(Edge edge) {
		Stack<Integer> stack = new Stack<>();
		stack.push(edge.v1);
		while (!stack.empty()) {
			int currentVertexIndex = stack.pop();
			if (currentVertexIndex == edge.v2)
				return true;
			vertexMap.get(currentVertexIndex).setVisited(true);
			for (Pair nextVertex : adjacencyList.get(currentVertexIndex)) {
				int nextVertexIndex = nextVertex.destination;
				if (!vertexMap.get(nextVertexIndex).isVisited())
					stack.push(nextVertexIndex);
			}
		}
		return false;
	}

	/**
	 * This should remove the edge from the adjacencyList
	 * 
	 * @param source
	 * @param destination
	 * @param weight
	 */
	public void removeEdge(int source, int destination, double weight) {
		Pair find = new Pair(destination, weight);
		int indexOfPair = adjacencyList.get(source).indexOf(find);
		adjacencyList.get(source).remove(indexOfPair);
		indexOfPair = adjacencyList.get(destination).indexOf(new Pair(source, weight));
		adjacencyList.get(destination).remove(indexOfPair);
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
	 * @param rootIndex
	 */

	public void mstPrim(int rootIndex) {
		ArrayList<LinkedList<Pair>> newAdjacencyList = new ArrayList<>();
		for (int i = 0; i < vertices; i++)
			newAdjacencyList.add(i, new LinkedList<>());
		Heap queue = new Heap(vertexMap);
		Vertex root = vertexMap.get(rootIndex);
		root.key = 0;
		while (queue.size() != 0) {
			int currentIndex = queue.extractMin();
			for (int nextIndex : findNeighbors(currentIndex)) {
				Vertex nextVertex = vertexMap.get(nextIndex);
				double weight = getWeight(currentIndex, nextIndex);
				if (queue.contains(nextIndex) && weight < nextVertex.key) {
					nextVertex.parent = currentIndex;
					nextVertex.key = weight;
				}
			}
			System.out.printf("Creating MST... %.2f%% done!%n", (1 - (double) queue.size() / vertexMap.size()) * 100);
		}

		for (int i = 0; i < vertexMap.size(); i++)
			if (vertexMap.get(i).parent != NIL)
				addEdge(newAdjacencyList, i, vertexMap.get(i).parent, getWeight(i, vertexMap.get(i).parent));

		adjacencyList = newAdjacencyList;
	}

	/**
	 * Gets the edge weight between two vertices. If it doesn't exist, return NaN.
	 * 
	 * @param vertexIndex1
	 * @param vertexIndex2
	 * @return the edge weight between two vertices
	 */
	public double getWeight(int vertexIndex1, int vertexIndex2) {
		for (Pair pair : adjacencyList.get(vertexIndex1)) {
			if (pair.destination == vertexIndex2)
				return pair.weight;
		}
		return Double.NaN;
	}

	/**
	 * Finds the minimum spanning tree using THE new algorithm.
	 */
	public void newAlgorithm() {
		sortEdges();
		for (int i = 0; i < edgeList.size(); i++) {
			for (Vertex vertex : vertexMap.values())
				vertex.setVisited(false);
			int source = edgeList.get(i).v1;
			int destination = edgeList.get(i).v2;
			double weight = edgeList.get(i).weight;
			removeEdge(source, destination, weight);
			if (!isPartOfCycle(edgeList.get(i)))
				addEdge(source, destination, weight);
			System.out.printf("Creating MST... %.2f%% done!%n", (double) i * 100 / edgeList.size());
		}
		System.out.println("Creating MST... 100% done!");
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

	/**
	 * String representation of minimal spanning tree.
	 */
	public String stringizeMST() {
		StringBuilder stringBuilder = new StringBuilder();
		return stringBuilder.toString();
	}

	// Getters and setters

	public HashMap<Integer, Vertex> getVertexMap() {
		return vertexMap;
	}

	public static void main(String[] args) {
		Graph graph = new Graph("WeightedGraphExamples/10000EWG.txt");
		// graph.newAlgorithm();
		graph.mstPrim(0);
		System.out.println(graph.toString());

	}

}