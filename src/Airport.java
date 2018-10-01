import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Airport {

	public static void main(String[] args) {
		
		Airport ap = new Airport();
		Graph g = new Graph(10);
		
		// Denver's connecting flights
		g.addFlight(0, 1, 188); g.addFlight(0, 2, 463);g.addFlight(0, 7, 450);
		g.addFlight(0, 5, 248); g.addFlight(0, 6, 133);
		// Dallas's connecting flights
		g.addFlight(1, 2, 275);g.addFlight(1, 3, 325);g.addFlight(1, 4, 63);
		g.addFlight(1, 6, 300);g.addFlight(1, 9, 275);
		// Orlando's connecting flights
		g.addFlight(2, 1, 275);g.addFlight(2, 3, 225);g.addFlight(2, 4, 250);
		g.addFlight(2, 7, 275);g.addFlight(2, 8, 725);
		// Washington Dulles flights
		g.addFlight(3, 1, 325);g.addFlight(3, 2, 225);g.addFlight(3, 5, 175);
		g.addFlight(3, 6, 500);g.addFlight(3, 7, 63);
		// George Bush flights 
		g.addFlight(4, 0, 250);g.addFlight(4, 1, 63);g.addFlight(4, 2, 250);
		g.addFlight(4, 6, 375);
		// O'Hare flights 
		g.addFlight(5, 0, 248);g.addFlight(5, 1, 225);g.addFlight(5, 4, 275);
		g.addFlight(5, 8, 538);g.addFlight(5, 9, 75);
		// Salt lake City flights
		g.addFlight(6, 0, 133);g.addFlight(6, 2, 575);g.addFlight(6, 4, 375);
		g.addFlight(6, 8, 188);g.addFlight(6, 9, 413);
		// JFK Flights
		g.addFlight(7, 1, 400);g.addFlight(7, 2, 275);g.addFlight(7, 3, 63);
		g.addFlight(7, 4, 413);g.addFlight(7, 5, 188);
		// San Francisco Flights 
		g.addFlight(8, 0, 313);g.addFlight(8, 3, 700);g.addFlight(8, 4, 475);
		g.addFlight(8, 6, 188);g.addFlight(8, 9, 600);
		// Detroit flights
		g.addFlight(9, 0, 313);g.addFlight(9, 5, 75);g.addFlight(9, 6, 413);
		g.addFlight(9, 7, 150);g.addFlight(9, 8, 600);
		
		
		
		
		System.out.println("Airports: ");
		for (int i = 0; i < g.getVertices().size(); i++) {
			System.out.println(i + ". " + g.getAP(i));
		}
		System.out.println();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Departing from? (Enter number) ");
		int dep = scan.nextInt();
		
		System.out.println("Arriving to? ");
		Scanner scan2 = new Scanner(System.in);
		int arr = scan2.nextInt();
		
		ap.calculate(g.getAP(dep));
		System.out.println("The Source Airport: " + g.getName(dep));
		System.out.println();
		System.out.println("The destination Airport: " + g.getName(arr));
		System.out.println();
		for(AP vex : g.getAP(arr).path) {
			System.out.println(vex + " ");
		}
		System.out.println(g.getAP(arr));
		System.out.println("Price: " + g.getAP(arr).minDistance);
		
	}
	
	// Dijkstra's algorithm 
	public void calculate(AP source) {
		source.minDistance = 0;
		PriorityQueue<AP> queue = new PriorityQueue<AP>();
		queue.add(source);
	
		while(!queue.isEmpty()) {
			
			AP u = queue.poll();
			
			for(Flight neighbor : u.neighbors) {
				Double newDis = u.minDistance+neighbor.price;
				
				if(neighbor.destination.minDistance > newDis) {
					
					queue.remove(neighbor.destination);
					neighbor.destination.minDistance = newDis;

					neighbor.destination.path = new LinkedList<AP>(u.path);
					neighbor.destination.path.add(u);
					queue.add(neighbor.destination);
					
				}
			}
			
			
		}
	}
}