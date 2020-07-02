// Charlotte Bakalar
// 260568359
// COMP250

package Assignment1;

public abstract class Reservation {
	// ATTTRIBUTE
	private String name;
	
	// CONSTRUCTOR
	public Reservation(String clientName) {
		this.name = clientName;
	}
	
	
	// OTHER METHODS
	// getter method for the name of the reservation
	public final String reservationName() {
		return this.name;
	}
	
	
	// ABSTRACT METHODS for use of subclasses, i.e., HotelReservation and FlightReservation
	// returns the cost of the specific reservation type
	public abstract int getCost();
	
	// determines whether two reservations are considered equal, depending on the type
	public abstract boolean equals(Object obj);
	
	
}
