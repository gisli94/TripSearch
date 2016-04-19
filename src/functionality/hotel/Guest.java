package functionality.hotel;

public class Guest {
	
	private int GuestID;
	private String firstName;
	private String lastName;
//	private int reservationId;
	
//	public Guest(int GuestID, String firstName, String lastName, int reservationId) {
	public Guest(int GuestID, String firstName, String lastName) {
		this.setGuestID(GuestID);
		this.setFirstName(firstName);
		this.setLastName(lastName);
//		this.setReservationId(reservationId);
	}

	public int getGuestID() {
		return GuestID;
	}

	public void setGuestID(int guestID) {
		GuestID = guestID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

//	public int getReservationId() {
//		return reservationId;
//	}
//
//	public void setReservationId(int reservationId) {
//		this.reservationId = reservationId;
//	}
}
