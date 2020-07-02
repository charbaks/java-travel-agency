// Charlotte Bakalar
// 260568359
// COMP250

package Assignment1;

public class FlightReservation extends Reservation {
	// ATTRIBUTES
	private Airport depart;
	private Airport arrive;
	
	// CONSTRUCTOR
	public FlightReservation(String name, Airport depart, Airport arrive) {
		super(name);
		
		if(depart.equals(arrive)) {
			throw new IllegalArgumentException("The two input airports are the same. Please try again.");
		}
		else {
			this.depart = depart;
			this.arrive = arrive;
		}
		
	}
	
	
	// OTHER METHODS
	// calculates the cost of flight between two airports
	public int getCost() {
		double airportFees = this.depart.getFees() + this.arrive.getFees();
		double fuelCost = (124.00 * ((Airport.getDistance(this.depart, this.arrive)) / 167.52));
		double cost = Math.ceil(airportFees + fuelCost + 5375);
		int totalCost = (int)cost;
		
		return totalCost;
	}
	
	
	// overrides the equals method to check if two FlighReservations are the same
	public boolean equals(Object obj) {
		if(obj instanceof FlightReservation) {
			FlightReservation frEquals = (FlightReservation)obj;
			
			return this.reservationName() == frEquals.reservationName() && this.depart == frEquals.depart &&
					this.arrive == frEquals.arrive;
		}
		
		return false;
	}
	
	
}
