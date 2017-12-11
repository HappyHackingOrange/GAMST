package sjsu.stowbunenko.cs146.project4;

/**
 * 
 * @author Vivian Hoang
 *
 */
public class Vertex {
	
	double key;
	int parent;
	static final int NIL = -1;
	boolean visited;

	/**
	 * This contains the beginning and ending vertices
	 * @param source
	 * @param destination
	 */
	public Vertex() {
		key = Double.POSITIVE_INFINITY;
		parent = NIL;
		visited = false;
	}
	
	/**
	 * This will assign the value of the vertex_number given by the txt files
	 * @param head
	 */
	public Vertex(double key) {
		this.key = key;
		parent = NIL;
		visited = false;
	}
	
	// Getters and setters

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
}
