package functionality.hotel;

public class Hotel {

	private int ID;
	private String NAME;
	private String LOCATION_CITY;
	private String LOCATION_STREET;

	public Hotel(int id, String name, String locCity, String locStreet) {
		this.setId(id);
		this.setName(name);
		this.setLocationCity(locCity);
		this.setLocationStreet(locStreet);
	}
	
	public String getName() {
		return NAME;
	}

	public void setName(String name) {
		NAME = name;
	}

	public String getLocationCity() {
		return LOCATION_CITY;
	}

	public void setLocationCity(String loc) {
		LOCATION_CITY = loc;
	}

	public String getLocationStreet() {
		return LOCATION_STREET;
	}

	public void setLocationStreet(String loc) {
		LOCATION_STREET = loc;
	}

	public int getId() {
		return this.ID;
	}

	public void setId(int iD) {
		ID = iD;
	}
	
//	public Room [] getRoomAvailability(int startDate, int nrOfDays){
//		
//		Room [] availableRooms = new Room[getNR_OF_ROOMS()];
//		int index = 0;
//		
//		for(int i = 0; i < getNR_OF_ROOMS(); i++) {
//			
//			boolean isFree = true;
//		
//			for(int j = startDate; j < startDate + nrOfDays; j++) {
//				if(this.rooms[i].getAvailability(startDate, nrOfDays) == false)
//					isFree = false;
//			}
//			
//			if(isFree)
//				availableRooms[index++] = rooms[i];
//		}
//		
//		return availableRooms;
//	}
	
}