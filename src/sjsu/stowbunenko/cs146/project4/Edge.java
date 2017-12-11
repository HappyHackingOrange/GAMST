package sjsu.stowbunenko.cs146.project4;

public class Edge implements Comparable<Edge>{
	int v1;
	int v2;
	double weight;
	
	
	public  Edge(int v1,int v2, double weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}
	
	public int compareTo(Edge that) {
		if(weight < that.weight)
			return 1;
		else if(weight > that.weight)
			return -1;
		return 0;
	}
	
	public boolean equals(Object that) {
		return this.compareTo((Edge)that) == 0;
	}
	
	public String toString() {
		String returnString = v1 +"-" + v2 + " " + weight;
		return returnString;
	}
	
}
