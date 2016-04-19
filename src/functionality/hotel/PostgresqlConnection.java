package functionality.hotel;
import java.sql.*;

public class PostgresqlConnection {

	public static Connection getConnection(){
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/HotelSearch", 
					"postgres", "gusti123");
//			if(conn!=null) System.out.println("Connected to DB");
			
			return conn;
		}
		catch(Exception e){
			e.printStackTrace(); 
		}
		return null;
	}
}


