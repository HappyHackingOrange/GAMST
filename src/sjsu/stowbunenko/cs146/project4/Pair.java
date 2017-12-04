package sjsu.stowbunenko.cs146.project4;

/**
 * A pair (2-tuple) to store a destination vertex and the weight edge that
 * connects from source vertex to destination vertex.
 * 
 * Source: https://stackoverflow.com/a/2671052/3718280
 */
public class Pair<X, Y> {

	// Instance variables
	public final X x;
	public final Y y;

	// Constructor
	public Pair(X x, Y y) {
		this.x = x;
		this.y = y;
	}

}
