package sjsu.stowbunenko.cs146.project4;

/**
 * A pair (2-tuple) to store a destination vertex and the weight edge that
 * connects from source vertex to destination vertex.
 * 
 * Source: https://stackoverflow.com/a/2671052/3718280
 */
public class Pair {

	// Instance variables
	public final int destination;
	public final double weight;

	// Constructor
	public Pair(int destination, double weight) {
		this.destination = destination;
		this.weight = weight;
	}
	
}
