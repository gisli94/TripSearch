package functionality.hotel;
import java.sql.*;

public class Controller {
	
	public static void main(String[] args) throws SQLException{
//		Connection conn = PostgresqlConnection.getConnection();
//		Statement stmt = conn.createStatement();
//		String sql;
//	    sql = "SELECT hotelID, name FROM hotels";
//	    ResultSet rs = stmt.executeQuery(sql);
//	    
//	    while(rs.next()){
//	         //Retrieve by column name
//	         int id  = rs.getInt("hotelid");
//	         String name = rs.getString("name");
//
//	         //Display values
//	         System.out.print("ID: " + id);
//	         System.out.println(" Name: " + name);
//	    }

//	    getAvailability(20160404, 20160411, 16);
//		getHotel(1);
//	    setAvailability(2, 3, 3, 4);
//	    createReservation(1, 5, 20160328, 20160329, 1);
//	    createNewGuest("Gustaf", "Gustafsson");
	}
	
	public static Room[] getAvailability(int checkIn, int checkOut, int nrOfRooms) throws SQLException{

		if(checkOut <= checkIn) return null;		// Bad if the checkOut date precedes checkIn date
		
		Room[] avlRooms = new Room[nrOfRooms];
		
		Connection conn = PostgresqlConnection.getConnection();
		Statement stmt = conn.createStatement();
		String sql;
		
		// Pt.1 of Finding the rooms available on the requested dates
	    sql = "SELECT roomid "
	    		+ "FROM occupied_room "
	    		+ "WHERE ((check_in <= "+checkOut+" AND "+checkOut+" <= check_out) "
	    		+ "OR (check_in <= "+checkIn+" AND "+checkIn+" < check_out) "
	    		+ "OR ("+checkIn+" < check_in AND "+checkOut+" > check_out))";	
	    
	    // Pt.2 of Finding the rooms available on the requested dates
	    String sql2 = "SELECT * FROM rooms GROUP BY roomid HAVING roomid NOT IN ("+sql+")";
	   	    
	    ResultSet rs = stmt.executeQuery(sql2);		// rs contains rooms that are available on the specified dates
	    int i = 0; 
	    
	    while(rs.next()){
	    	avlRooms[i] = new Room(rs.getInt("roomid"), rs.getInt("hotelid"), "Double", rs.getDouble("price"));
	    	i++;
	    	if (i == nrOfRooms) return avlRooms;
	    }
	    
	    // Made it through the while loop which means there weren't enough rooms available to fulfill the request
	    return null;
	}

		// Below is the original function, before the changes on the 18th of April 2016
//	public Room[] getAvailability(int checkIn, int checkOut, int nrOfRooms) throws SQLException{
//
//		if(checkOut <= checkIn) return null;		// Bad if the checkOut date precedes checkIn date
//		
//		Room[] avlRooms = new Room[nrOfRooms];
//		
//		Connection conn = PostgresqlConnection.getConnection();
//		Statement stmt = conn.createStatement();
//		String sql;
//		
//		// Pt.1 of Finding the rooms available on the requested dates
//	    sql = "SELECT roomid "
//	    		+ "FROM occupied_room "
//	    		+ "WHERE ((check_in <= "+checkOut+" AND "+checkOut+" <= check_out) "
//	    		+ "OR (check_in <= "+checkIn+" AND "+checkIn+" < check_out) "
//	    		+ "OR ("+checkIn+" < check_in AND "+checkOut+" > check_out))";	
//	    
//	    // Pt.2 of Finding the rooms available on the requested dates
//	    String sql2 = "SELECT * FROM rooms GROUP BY roomid HAVING roomid NOT IN ("+sql+")";
//	   	    
//	    ResultSet rs = stmt.executeQuery(sql2);		// rs contains rooms that are available on the specified dates
//	    int i = 0; 
//	    
//	    while(rs.next()){
//	    	avlRooms[i] = new Room(rs.getInt("roomid"), rs.getInt("hotelid"), "Double", rs.getDouble("price"));
//	    	i++;
//	    	if (i == nrOfRooms) return avlRooms;
//	    }
//	    
//	    // Made it through the while loop which means there weren't enough rooms available to fulfill the request
//	    return null;
//	}
	
	// dates are of the format 20160327, which means year 2016, month 03 and day 27.
	public void setAvailability(int roomid, int guestid, int checkin, int checkout) throws SQLException{
		
		Connection conn = PostgresqlConnection.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "insert into occupied_room values("+roomid+","+guestid+","+checkin+","+checkout+")";
		stmt.execute(sql);
		stmt.close();
	
	}
	
	// Returns instance of the newly created reservation and call setAvailability function
	public Reservation createReservation(int hotelid, int roomid, int checkin, int checkout, int guestid) throws SQLException {
		Connection conn = PostgresqlConnection.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "select id from reservations";
		ResultSet rs = stmt.executeQuery(sql);
		
		// Figure out the next reservation id in line
		// --------
		int id = -1;
		while(rs.next()){
			if(rs.isLast()) id = rs.getInt("id");
		}
		
		if(id != -1) id += 1;
		else id = 1;
		// --------
		
		sql = "insert into reservations values("+hotelid+","+roomid+","+id+","+guestid+","+checkin+","+checkout+")";
		stmt.execute(sql);
		
		Reservation newRes = new Reservation(id, hotelid, roomid, checkin, checkout, guestid);
		setAvailability(roomid, guestid, checkin, checkout);
		return newRes;
	}
	
	// Returns instance of the newly created guest
	public Guest createNewGuest(String firstname, String lastname) throws SQLException {
		Connection conn = PostgresqlConnection.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "select id from guest";
		ResultSet rs = stmt.executeQuery(sql);
		
		// Figure out the next guest id in line
		// --------
		int id = -1;
		while(rs.next()){
			if(rs.isLast()) id = rs.getInt("id");
		}
		
		if(id != -1) id += 1;
		else id = 1;
		// --------
	
		
		sql = "insert into guest values("+id+",'"+firstname+"', '"+lastname+"')";
		stmt.execute(sql);
		
		Guest newGuy = new Guest(id, firstname, lastname);
		return newGuy;
	}
	
	public static Hotel getHotel(int id) throws SQLException{
		Connection conn = PostgresqlConnection.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "select * from hotels where hotelid ="+id;
		ResultSet rs = stmt.executeQuery(sql);
		
	    while(rs.next()){
	         //Retrieve by column name
	         int hotid  = rs.getInt("hotelid");
	         String name = rs.getString("name");
	         String locCity = rs.getString("location_city");
	         String locStreet = rs.getString("location_street");

	         //Display values
//	         System.out.print("ID: " + hotid);
//	         System.out.println(" Name: " + name);
//	         System.out.println(" loccity: " + locCity);
//	         System.out.println(" locstreet: " + locStreet);
	         Hotel hotel = new Hotel(name, locCity, "Double room", 23999);
	         return hotel;
	    }
		return null;	    
	    
	}
	
	
	// See if checkin/checkout clashes with "start" and "end" (the dates to check against)
	// 3 cases: checkin is before start and checkout is between start and end
	//				checkin --- start <= checkout <= end
	//
	//			checkin is between start and end and checkout is after end
	//				start <= checkin < end --- checkout
	//
	//			checkin is before start and checkout is after end
	//				checkin --- start --- end --- checkout
	//			
//	public boolean isOccupied(long start, long end, long checkin, long checkout){
//		
//		if(start <= checkout && checkout <= end) {
//			System.out.println("TRUE");
//			return true;
//		}
//		
//		if(start <= checkin && checkin < end) {
//			System.out.println("TRUE");
//			return true;
//		} 
//			
//		if(checkin < start && checkout > end) {
//			System.out.println("TRUE");
//			return true;
//		}
//		
//		System.out.println("FALSE");
//		return false;
//	}
		
}
