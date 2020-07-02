// Charlotte Bakalar
// 260568359
// COMP250

package Assignment1;

public class HotelReservation extends Reservation {
	// ATTRIBUTES
	private Hotel hotelRes;
	private String roomType;
	private int numNights;
	private int pricePerNight;
	
	// CONSTRUCTOR
	public HotelReservation(String name, Hotel hotel, String roomType, int nights) {
		super(name);
		
		int h1 = hotel.reserveRoom(roomType);
		Room r = new Room(roomType);
		
		// if there are no available rooms of "roomType" in hotel "hotel", return exception
		if(h1 != r.getPrice()) {
			throw new IllegalArgumentException("I'm sorry. We are unable to reserve you a room of type \"" + roomType +
					"\"this type in the specified hotel. The room type either does not exist or all rooms of that type "
					+ "are already booked. Please try again.");
		}
		
		else {
			this.hotelRes = hotel;
			this.roomType = roomType;
			this.numNights = nights;
			this.pricePerNight = r.getPrice();
		}
		
	}
	
	
	// GETTER METHODS
	// getter method for number of nights
	public int getNumOfNights() {
		return this.numNights;
	}
	
	// returns total cost of given room over the amount of specified time
	public int getCost() {
		return this.numNights * this.pricePerNight;
	}
	
	
	// OTHER METHODS
	// overriding equals method to see if two HotelReservation objects are the same or not
	public boolean equals(Object obj) {
		if(obj instanceof HotelReservation) {
			HotelReservation hrEquals = (HotelReservation)obj;
			
			return this.hotelRes == hrEquals.hotelRes && this.roomType == hrEquals.roomType &&
					this.numNights == hrEquals.numNights && this.getCost() == hrEquals.getCost() &&
					this.reservationName() == hrEquals.reservationName();
		}
		
		return false;
	}

	
}
