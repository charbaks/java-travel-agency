// Charlotte Bakalar
// 260568359
// COMP250

package Assignment1;

public class Basket {
	// ATTRIBUTE
	private Reservation[] res;
	
	// CONSTRCTOR
	public Basket() {
		Reservation[] reservation = new Reservation[0];
		
		this.res = reservation;
	}
	
	
	// GETTER METHOD
	public Reservation[] getProducts() {
		Reservation[] getProdRes = this.res;
		
		return getProdRes;
 	}
	
	
	// OTHER METHODS
	// add a Reservation to the end of the Reservation array attribute, "res", in the Basket object
	public int add(Reservation r) {
		Reservation[] resAdd = new Reservation[this.res.length+1];
		for(int i=0; i<resAdd.length-1; i++) {
			resAdd[i] = this.res[i];
		}
		resAdd[resAdd.length-1] = r;
		this.res = resAdd;
		
		return res.length;
	}
	
	
	// removes the first occurrence of the specified element from "res" as long as the reservation exists and returns true
	// if reservation does not exist, the method returns false
	public boolean remove(Reservation r) {
		int temp = -1;

		for(int i=0; i<this.res.length; i++) {
			if(this.res[i].equals(r)) {
				temp = i;
				break;
			}
		}
		
		if(temp < 0)
			return false;
		
		Reservation[] resRemove = new Reservation[this.res.length-1];
		
		for(int j=0; j<temp; j++) {
			resRemove[j] = res[j];
		}
		
		for(int k=temp; k<resRemove.length; k++) {
			resRemove[k] = res[k+1];
		}
		
		this.res = resRemove;
		
		return true;
	}
	
	
	// empties the array of Reservations, res
	public void clear() {
		Reservation[] clearRes = new Reservation[0];
		this.res = clearRes;
	}
	
	
	// GETTER for number of reservations in the Reservations array of the Basket object
	public int getNumOfReservations() {
		return this.res.length;
	}
	
	
	// returns combined cost of all reservations in the basket
	public int getTotalCost() {
		int totalCost = 0;
		
		for(int i=0; i<this.res.length; i++) {
			totalCost += this.res[i].getCost();
		}
		
		return totalCost;
	}
		
	
}
