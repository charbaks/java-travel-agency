// Charlotte Bakalar
// 260568359
// COMP250

package Assignment1;

public class Room {
	// ATTRIBUTES
	private String roomType;
	private int price;
	private boolean roomAvailable;
	
	// CONSTRUCTOR
	public Room(String roomType) {
		// checks if the input type is allowed, if not, throws and error and returns message to user explaining it was an illegal input
		if(!(roomType.equalsIgnoreCase("double") || roomType.equalsIgnoreCase("queen") || 
				roomType.equalsIgnoreCase("king"))) {
			throw new IllegalArgumentException("I'm sorry, a room of type \"" + roomType + "\" cannot be created. Please try again.");
		}
		
		else if(roomType.equalsIgnoreCase("double")) {
			this.roomType = roomType;
			this.price = 90 * 100; // sets price to 90$ and converts it into cents --> 9000 cents
			roomAvailable = true;
		}
		
		else if(roomType.equalsIgnoreCase("queen")) { 
			this.roomType = roomType;
			this.price = 110 * 100; // sets price to 110$ and converts it into cents --> 11000 cents
			roomAvailable = true;
		}
		
		else if(roomType.equalsIgnoreCase("king")) { 
			this.roomType = roomType;
			this.price = 150 * 100; // sets price to 150$ and converts it into cents --> 15000 cents
			roomAvailable = true;
		}
	}
	
	public Room(Room r) {
		this.roomType = r.roomType;
		this.price = r.price;
		this.roomAvailable = r.roomAvailable;
	}
	
	
	// GETTER METHODS
	public String getType() {
		return this.roomType;
	}
	
	
	public int getPrice() {
		return this.price;
	}
	
	
	// OTHER METHODS:
	// sets value stored in roomAvailable to be the opposite of what it was
	public void changeAvailability() {
		if(this.roomAvailable)
			this.roomAvailable = !this.roomAvailable;
		else
			this.roomAvailable = !this.roomAvailable;
	}
	
	
	// goes through array of Rooms to see if there is an available room that matches the requested type
	public static Room findAvailableRoom(Room[] r, String type) {
		for(int i=0; i<r.length; i++) {
			if(r[i].roomAvailable == true && r[i].roomType.equalsIgnoreCase(type)) {
				return r[i];
			}
		}
		
		return null;
	}
	
	
	// looks through an array of Rooms and makes the first unavailable Room of the specified type available
	public static boolean makeRoomAvailable(Room[] r, String type) {
		for(int i=0; i<r.length; i++) {
			if(r[i].getType().equalsIgnoreCase(type) && r[i].roomAvailable == false) {
				r[i].changeAvailability();
				return true;
			}
		}
		
		return false;
	}
	
	
}
