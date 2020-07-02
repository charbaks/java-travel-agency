// Charlotte Bakalar
// 260568359
// COMP250

package Assignment1;

public class Airport {
	// ATTRIBUTES
	private int xCoordinate;
	private int yCoordinate;
	private int airportFees;
	
	// CONSTRUCTOR
	public Airport(int xCoord, int yCoord, int fees) {
		this.xCoordinate = xCoord; 
		this.yCoordinate = yCoord;
		this.airportFees = fees;
	}
	
	
	// GETTER METHOD --> returns fees attribute of given object
	public int getFees() {
		return this.airportFees;
	}
	
	
	// OTHER METHODS
	// returns distance between Airport objects a and b
	public static int getDistance(Airport a, Airport b) {
		int aX = a.xCoordinate;
		int aY = a.yCoordinate;
		int bX = b.xCoordinate;
		int bY = b.yCoordinate;
		
		// implements the distance formula and then rounds the answer up to the nearest double
		double distance = Math.ceil(Math.sqrt(Math.pow((aX - bX), 2) + Math.pow((aY - bY), 2)));
		
		return (int)distance; // type casts double variable "distance" into an integer and returns it
	}
	
	
}
