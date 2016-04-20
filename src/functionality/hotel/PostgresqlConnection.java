package functionality.hotel;
import java.sql.*;

public class PostgresqlConnection {

	public static Connection getConnection(){
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/skulii/Downloads/TripSelector.db");
//			if(conn!=null) System.out.println("Connected to DB");
			return conn;
		}
		catch(Exception e){
			e.printStackTrace(); 
		}
		return null;
	}
}


