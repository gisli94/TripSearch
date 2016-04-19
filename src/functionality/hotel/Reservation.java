package functionality.hotel;

public class Reservation {
	private int reservationID;
	private int hotelId;
	private int roomId;
	private int checkIn;
	private int checkOut;
	private int guestId;
	
	
	public Reservation(int id, int hotelid, int roomId, int checkin, int checkout, int guestid) {
		this.setReservationId(id);
		this.setHotelId(hotelid);
		this.setRoomId(roomId);
		this.setCheckIn(checkin);
		this.setCheckOut(checkout);
		this.setGuestId(guestid);
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelid) {
		this.hotelId = hotelid;
	}

	public int getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(int checkin) {
		this.checkIn = checkin;
	}

	public int getReservationId() {
		return reservationID;
	}

	public void setReservationId(int reservationID) {
		this.reservationID = reservationID;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public long getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(int checkOut) {
		this.checkOut = checkOut;
	}

	public int getGuestId() {
		return guestId;
	}

	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}
}
