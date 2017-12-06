package sjsu.stowbunenko.cs146.project4;

public class Vertex {
	
	double key;
	int source;
	int destination;
	Vertex head;
	Vertex child;
	/**
	 * This contains the beginning and ending vertices
	 * @param source
	 * @param destination
	 */
	public Vertex(int source, int destination) {
		this.source = source;
		this.destination = destination;
		key = Double.MAX_VALUE;
		head = null;
		child = null;
	}
	
}
