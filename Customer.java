// Charlotte Bakalar
// 260568359
// COMP250

package Assignment1;

public class Customer {
	// ATTRIBUTES
	private String name;
	private int balance;
	private Basket reservations;
	
	
	// CONSTRUCTOR
	public Customer(String name, int balance) {
		this.name = name;
		this.balance = balance;
		Basket reserve = new Basket();
		this.reservations = reserve;
	}
	
	// GETTER METHODS
	public String getName() {
		return this.name;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public Basket getBasket() {
		return this.reservations;
	}
	
	
	// OTHER METHODS
	// adds funds to the Customer object's balance field
	public int addFunds(int add) {
		if(add < 0) {
			throw new IllegalArgumentException("You cannot add negative amounts to funds. Please try again.");
		}
		
		int newBalance = this.getBalance() + add;
		this.balance = newBalance;
		return this.balance;
	}
	
	
	// adds a Reservation object to the Customer's Basket
	public int addToBasket(Reservation r) {
		int prevResLength = reservations.getNumOfReservations();
		if(this.getName().equals(r.reservationName())) {
			this.reservations.add(r);
		}
		
		if(this.reservations.getNumOfReservations() <= prevResLength) {
			throw new IllegalArgumentException("Sorry, the desired reservation could not be added. Please try again");
		}
		
		return this.reservations.getNumOfReservations();
	}
	
	
	// overloading above method
	public int addToBasket(Hotel h, String room, int numNights, boolean breakfast) {
		if(breakfast == true) {
			BnBReservation bnb = new BnBReservation(this.name, h, room, numNights);
			reservations.add(bnb);
		}
		
		else if(breakfast == false) {
			HotelReservation hr = new HotelReservation(this.name, h, room, numNights);
			reservations.add(hr);
		}
		
		return this.reservations.getNumOfReservations();
	}
	
	
	// overloading above method
	public int addToBasket(Airport a, Airport b) {
		FlightReservation fr = new FlightReservation(this.name, a, b);
		reservations.add(fr);
		
		return this.reservations.getNumOfReservations();
	}
	
	
	// removes Reservation from Basket
	public boolean removeFromBasket(Reservation r) {
		int prevResLength = reservations.getNumOfReservations();
		this.reservations.remove(r);
		
		if(this.reservations.getNumOfReservations() >= prevResLength) {
			return false;
		}
		
		return true;
	}
	
	
	public int checkOut() {
		if(this.getBalance() < reservations.getTotalCost()) {
			throw new IllegalStateException("The amount in your balance is not enough to "
					+ "cover the amount due.");
		}
		
		int balanceLeft = this.getBalance() - reservations.getTotalCost();
		reservations.clear();
		
		return balanceLeft;
	}
	
	
}
