package functionality.hotel;

public class Room {
	
	private int hotelID;
	private int roomID;
	private String type;			
	private double price;

//	private int MAX_PERSONS = 2;	

	
	public Room(int roomid, int hotelid, String roomtype, double price) {
		setRoomID(roomid);
		setHotelID(hotelid);
		setType(roomtype);
		setPrice(price);
	}

        public int getHotelID() {
            return hotelID;
        }
        
	private void setHotelID(int id) {
		hotelID = id;		
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int i) {
		this.roomID = i;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

//	public boolean getAvailability(int startDate, int nrOfDays) {
//		
//		boolean isFree = true;
//		
//		for(int i = startDate; i < startDate+nrOfDays; i++) {
//			if(availableDates[i] == false) {
//				isFree = false;
//				break;
//			}
//		}
//		
//		return isFree;
//	}
//
//	public void setAvailableDates(int startDate, int nrOfDays, boolean value) {
//		for(int i = startDate; i < startDate+nrOfDays; i++) {
//			availableDates[i] = value;
//		}
//	}
}