// Charlotte Bakalar
// 260568359
// COMP250

package Assignment1;

public class Hotel {
	// ATTRIBUTES
	private String hotelName;
	private Room[] hotelRooms;
	
	// CONSTRUCTOR
	public Hotel(String hotelName, Room[] hotelRooms) {
		this.hotelName = hotelName;
		
		// creates a new Room[] that points to different reference in space
		Room[] deepCopyRooms = new Room[hotelRooms.length];
		// for each Room in the hotelRooms array, a new Room is created with the same attributes/values and is then saved into the deep copy
		// each element in "deepCopyRooms" will thus point to a total different reference in space, but share the same values
		for(int i=0; i<deepCopyRooms.length; i++) {
			Room newRoom = new Room(hotelRooms[i]);
			deepCopyRooms[i] = newRoom;
		}
		
		this.hotelRooms = deepCopyRooms;
	}
	
	
	// OTHER METHODS
	// reserves this first available room of the desired type, then changes it to unavailable and returns the price
	public int reserveRoom(String desiredRoomType) {
		Room reserve = Room.findAvailableRoom(this.hotelRooms, desiredRoomType);
		
		if(reserve == null) {
			throw new IllegalArgumentException("Unable to make reservation. The room of type \"" + desiredRoomType + 
					"\" is unavailable or does not exist. Please try again.");
		}

		reserve.changeAvailability();
		
		return reserve.getPrice();
	}
	
	
	// takes the type of room wishing to be cancelled and makes it available again
	public boolean cancelRoom(String typeCancel) {
		boolean isCancelled = Room.makeRoomAvailable(this.hotelRooms, typeCancel);
		if(isCancelled) {
			return true;
		}
		
		return false;
	}
	

}
