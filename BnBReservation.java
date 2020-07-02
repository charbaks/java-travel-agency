// Charlotte Bakalar
// 260568359
// COMP250

package Assignment1;

public class BnBReservation extends HotelReservation {
	// CONSTRUCTOR
	public BnBReservation(String name, Hotel hotel, String roomType, int numOfNights) {
		super(name, hotel, roomType, numOfNights);
	}
	
	
	// GETTER METHOD
	public int getCost() {
		return (super.getCost()) + (super.getNumOfNights() * 1000);
	}
	

}
