import java.util.ArrayList;
import java.util.LinkedList;

public class AP implements Comparable<AP>{

	public final String name;
	public ArrayList<Flight> neighbors;
	public LinkedList<AP> path;
	public double minDistance = Double.POSITIVE_INFINITY;
	public AP previous;
	
	// Each of the Airports constructor
	public AP(String name) {
		this.name = name;
		neighbors = new ArrayList<Flight>();
		path = new LinkedList<AP>();
	}

	public int compareTo(AP other) {
		return Double.compare(minDistance, other.minDistance);
	}
	
	public String toString() {
		return name;
	}
	
}