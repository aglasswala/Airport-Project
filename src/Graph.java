import java.util.ArrayList;

public class Graph {
	
	private ArrayList<AP> vertices;
	
	// Creates the graph and addes vertices
	public Graph(int numberVertices) {
		vertices = new ArrayList<AP>(numberVertices);
		vertices.add(new AP("DEN - Denver/Colorado"));
		vertices.add(new AP("DFW - Dallas/Texas"));
		vertices.add(new AP("MCO - Orlando/Florida"));
		vertices.add(new AP("IAD - Washington Dulles/Washington D.C."));
		vertices.add(new AP("IAH - George Bush/Texas"));
		vertices.add(new AP("ORD - O'Hare/Chicago"));
		vertices.add(new AP("SLC - Salt Lake City/Utah"));
		vertices.add(new AP("JFK - John F Kennedy/New York"));
		vertices.add(new AP("SFO - San Franciso/California"));
		vertices.add(new AP("DTW - Detroit/Michigan"));
		
	}
	
	public void addFlight(int src, int dest, int price) {
		AP s = vertices.get(src);
		Flight add_Flight = new Flight(vertices.get(dest), price);
		s.neighbors.add(add_Flight);
	}
	
	public ArrayList<AP> getVertices() {
		return vertices;
	}
	
	public AP getAP(int ap) {
		return vertices.get(ap);
	}
	
	public String getName(int ap) {
		return vertices.get(ap).name.substring(0, 3);
	}
}