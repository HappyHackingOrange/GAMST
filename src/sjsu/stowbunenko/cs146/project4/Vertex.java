package sjsu.stowbunenko.cs146.project4;

public class Vertex {
	
	double key;
	Vertex head;
	Vertex child;
	/**
	 * This contains the beginning and ending vertices
	 * @param source
	 * @param destination
	 */
	public Vertex() {
		key = Double.MAX_VALUE;
		head = null;
		child = null;
	}
	
	/**
	 * This will assign the value of the vertex_number given by the txt files
	 * @param head
	 */
	public Vertex(int head) {
		key = head;
	}
	
}
