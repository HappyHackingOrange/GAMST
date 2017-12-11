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
	
	
	public int compareTo(Pair that) {
		if(weight < that.weight)
			return -1;
		else if (weight > that.weight)
			return 1;
		return 0;
	}
	
	public boolean equals(Object that) {
		return this.compareTo((Pair)that) == 0;
	}
	
}
