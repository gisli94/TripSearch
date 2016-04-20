/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionality.flight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Date;

public class DBController {

    // Works!
    private boolean update(String sql) {
        boolean didComplete = false;
        Connection c;
        Statement stmt;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://pellefant-01.db.elephantsql.com:5432/jrfelwfu",
                    "jrfelwfu", "BhAw_gJWfAV49aOHk0eB_iHiccl6gE35");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
            didComplete = true;
            System.out.println("bla");

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);

        }
        return didComplete;
    }

    // Works!
    public boolean addFlight(
        String company, String departure, String arrival, String dateAndTime,
        int seatsAvailable, int totalSeats, int startPrice)
        {

        //inserts flight into database with given parameters
        String sql = "INSERT INTO FLIGHTS " + 
                     "(Company , Departure , Arrival, DateAndTime, SeatsAvailable, TotalSeats, StartPrice) " +
                      "VALUES ('" + company + "', '" + departure + "', '" + arrival + "', '" + dateAndTime + "' , " + 
                      seatsAvailable + ", " + totalSeats + ", " + startPrice + ");";

        return update(sql);
    }

    // Works!
    public boolean removeFlightByID(int flightID) {
        String sql1 = "DELETE FROM BOOKINGS "
                    + "WHERE flightid = " + flightID + ";";
        boolean b = update(sql1);
        String sql = "DELETE FROM FLIGHTS "
                + "WHERE id = " + flightID + ";";
        boolean out = update(sql);
        return out&&b;
    }

    // Works!
    public Flight[] getFlights(String departure, String arrival, String date, int noOfSeatsNeeded) {
        //searches database for flights with given parameters

        Connection c;
        Statement stmt;
        Flight[] out = null;

        try {

            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://pellefant-01.db.elephantsql.com:5432/jrfelwfu",
                    "jrfelwfu", "BhAw_gJWfAV49aOHk0eB_iHiccl6gE35");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = 
            "SELECT * FROM FLIGHTS WHERE Departure = '" + departure + "' AND Arrival = '" + arrival 
            + "' AND DateAndTime LIKE '%" + date.substring(0, 10) + "%' AND DateAndTime LIKE '%" + date.substring(10) + 
            "%' AND seatsAvailable >= " + noOfSeatsNeeded + ";";

            ResultSet rs = stmt.executeQuery(sql);
            
            Flight[] flights = new Flight[10];
            int counter = 0;
            
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                String depart = rs.getString("Departure");
                String arrive = rs.getString("Arrival");
                String time = rs.getString("DateAndTime");
                String airline = rs.getString("Company");
                int availableSeats = rs.getInt("SeatsAvailable");
                int totalSeats = rs.getInt("TotalSeats");
                int startingPrice = rs.getInt("StartPrice");
                
                // Convert String format of date to Date format.
                DateFormatter dateFormatter = new DateFormatter();
                Date dateAndTime = dateFormatter.stringToDate(time);
                Flight flight = new Flight(airline, availableSeats, totalSeats, arrive, depart, startingPrice, id, dateAndTime);
                flights[counter] = flight;
                counter++;
                
                if (counter==flights.length) {
                    Flight[] temp = new Flight[counter*2];
                    for (int i=0;i<counter;i++) temp[i]=flights[i];
                    flights = temp;
                }
            }
            
            out = new Flight[counter];
            for (int i=0;i<counter;i++) out[i]=flights[i];
                
            rs.close();

            stmt.close();
            c.commit();
            c.close();            
        } catch (Exception e) {

            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);

        }
        return out;
    }

    // Works!
    public Flight[] getFlightById(int flightId) {
        //searches database for flights with given id

        Connection c = null;
        Statement stmt = null;
        Flight[] out = null;

        try {

            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://pellefant-01.db.elephantsql.com:5432/jrfelwfu",
                    "jrfelwfu", "BhAw_gJWfAV49aOHk0eB_iHiccl6gE35");
            c.setAutoCommit(false);

            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = 
            "SELECT * FROM FLIGHTS WHERE id = " + flightId + ";";

            ResultSet rs = stmt.executeQuery(sql);
            
            Flight[] flights = new Flight[10];
            int counter = 0;
            
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                String depart = rs.getString("Departure");
                String arrive = rs.getString("Arrival");
                String time = rs.getString("DateAndTime");
                String airline = rs.getString("Company");
                int availableSeats = rs.getInt("SeatsAvailable");
                int totalSeats = rs.getInt("TotalSeats");
                int startingPrice = rs.getInt("StartPrice");
                
                // Convert String format of date to Date format.
                DateFormatter dateFormatter = new DateFormatter();
                Date dateAndTime = dateFormatter.stringToDate(time);
                Flight flight = new Flight(airline, availableSeats, totalSeats, arrive, depart, startingPrice, id, dateAndTime);
                flights[counter] = flight;
                counter++;
                
                if (counter==flights.length) {
                    Flight[] temp = new Flight[counter*2];
                    for (int i=0;i<counter;i++) temp[i]=flights[i];
                    flights = temp;
                }
            }
            
            out = new Flight[counter];
            for (int i=0;i<counter;i++) out[i]=flights[i];
                
            rs.close();

            stmt.close();
            c.commit();
            c.close();            
        } catch (Exception e) {

            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);

        }
        return out;
    }

    // Works!
    public boolean addCustomer(Customer cus) {
        //adds customer to database with given parameters
        String sql = "INSERT INTO CUSTOMERS (firstName, lastName, dateOfBirth, phoneNumber, emailaddress) "
                + "VALUES ('" + cus.getFirstName() + "', '" + cus.getLastName() + "', '" + cus.getDateOfBirth().toString()
                + "', '" + cus.getPhonenumber() + "', '" + cus.getEmailAddress() + "');";
        return update(sql);
    }

    // Works
    public Customer getCustomer(String emailAddress){
        
        Connection c = null;
        Statement stmt = null;
        Customer out = null;

        try {

            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://pellefant-01.db.elephantsql.com:5432/jrfelwfu",
                    "jrfelwfu", "BhAw_gJWfAV49aOHk0eB_iHiccl6gE35");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = 
            "SELECT * FROM CUSTOMERS WHERE emailaddress = '" + emailAddress+ "';";

            ResultSet rs = stmt.executeQuery(sql);
            
            Customer customer = new Customer();
            
            while(rs.next()){
                //Retrieve by column name
                String firstName = rs.getString("firstname");
                String lastName = rs.getString("lastname");
                String dateOfBirth = rs.getString("dateofbirth");
                int phoneNumber = rs.getInt("phonenumber");
                String email = rs.getString("emailaddress");
                
                // Convert String format of date to Date format.
                DateFormatter dateFormatter = new DateFormatter();
                Date dob = dateFormatter.stringToDate(dateOfBirth);
                customer = new Customer(firstName, lastName, dob, phoneNumber, email);
            }
            rs.close();
            stmt.close();
            c.commit();
            c.close();   

        } catch (Exception e) {

            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);

        }
        return out;
    }

    // Works!
    public boolean removeCustomer(String email) {
        //removes customer that has this id.
        String sql1 = "DELETE FROM BOOKINGS " 
                    + "WHERE customerEmail = '" + email + "' ;";

        boolean b = update(sql1);
        
        String sql = "DELETE FROM CUSTOMERS "
                + "WHERE emailaddress = '"+email+"';";
        boolean out = update(sql);
        return out;
    }
    
    // Works!
    public boolean changeSeatAvailability(int flightID, int noOfSeats) {
        //adds value of 'increment' parameter to matching flight's seatCount attribute in the database
        //fails if seatCount becomes negative
        int seatAvailability = getSeatAvailability(flightID);
        if (noOfSeats>seatAvailability) {return false;}
        else {
            seatAvailability = seatAvailability - noOfSeats;
            String sql = "UPDATE flights SET seatsavailable = " + seatAvailability + " WHERE id ="+ flightID + ";";
            boolean out = update(sql);
            return out;
        }
    }

    // Works!
    private int getSeatAvailability(int flightID) {

        Connection c = null;
        Statement stmt = null;
        int numOfSeats = 0;

        try {

            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://pellefant-01.db.elephantsql.com:5432/jrfelwfu",
                    "jrfelwfu", "BhAw_gJWfAV49aOHk0eB_iHiccl6gE35");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "SELECT seatsavailable FROM FLIGHTS WHERE id = "+ flightID +";";

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){

            numOfSeats = rs.getInt("seatsavailable");
        }

            rs.close();

            stmt.close();
            c.commit();
            c.close();
            
        } catch (Exception e) {

            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);

        }
        return numOfSeats;
    }

    // Works!
    public boolean addTicket(Ticket ticket) {
        String sql = "INSERT INTO BOOKINGS (flightID, customeremail) "
                + "VALUES ('" + ticket.getFlight().getFlightId() + "', '" + ticket.getCustomer().getEmailAddress() + "');";

        boolean out = update(sql);
        return out;
    } 

    // Works!    
    public Ticket getTicket(Ticket ticket) {
        //searches database for flights with given parameters
        Connection c = null;
        Statement stmt = null;

        try {

            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://pellefant-01.db.elephantsql.com:5432/jrfelwfu",
                    "jrfelwfu", "BhAw_gJWfAV49aOHk0eB_iHiccl6gE35");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            
            String sql = "SELECT * FROM BOOKINGS WHERE flightid = " + ticket.getFlight().getFlightId() + 
            " AND customeremail = '" + ticket.getCustomer().getEmailAddress() + "';";

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                //Retrieve by column name
                int flightId  = rs.getInt("flightid");
                String customerEmail = rs.getString("customeremail");

                Customer customer = getCustomer(customerEmail);
                Flight[] flight = new Flight[1];
                flight = getFlightById(flightId);

                ticket = new Ticket(customer, flight[0]);
            }

            rs.close();
            stmt.close();
            c.commit();
            c.close();

        } catch (Exception e) {

            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);

        }

        return ticket;

    }
}
