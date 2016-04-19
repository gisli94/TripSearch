/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionality.daytours;

import functionality.daytours.InvalidReservationException;
import functionality.daytours.ReservationAlreadyExistsException;
import functionality.daytours.ReservationNotFoundException;
import functionality.daytours.Reservation;
import functionality.daytours.Trip;
import functionality.daytours.User;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author Torfi Karl Ólafsson, Háskóli Íslands, tko2@hi.is
 */
public class DatabaseConnection {
    private Connection dbConnection;
    private Statement stmt;
    private String databaseLocation = "C:/DTPDatabase/DayTripsDatabase.db";
    
    //A list of trips based on a users search criteria
    public ArrayList<Trip> getTripsFromDatabase(String sqlSearchCriteria){
        ArrayList<Trip> trips = new ArrayList<>();
        try{
            Class.forName("org.sqlite.JDBC");
            dbConnection = DriverManager.getConnection("jdbc:sqlite:" + databaseLocation);
            dbConnection.setAutoCommit(false);
            
            stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(sqlSearchCriteria);
            
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String type = rs.getString("type");
                String date  = rs.getString("date");
                String departureTime = rs.getString("departuretime");
                String duration = rs.getString("duration");
                String location = rs.getString("location");
                int maxSeats = rs.getInt("maxSeats");
                int freeSeats = rs.getInt("freeSeats");
                int price = rs.getInt("price");   
                trips.add( new Trip(id, type, date, departureTime, duration, location, maxSeats, freeSeats, price));
            }        
            rs.close();
            stmt.close();
            dbConnection.close();
        } catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }       
        return trips;
    }
    
    //A list of reservations made by a user
    public ArrayList<Reservation> getReservationsFromDatabase(String usr){
        ArrayList<Reservation> reservations = new ArrayList<>();
        try{
            Class.forName("org.sqlite.JDBC");
            dbConnection = DriverManager.getConnection("jdbc:sqlite:" + databaseLocation);
            dbConnection.setAutoCommit(false);
            
            stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * From Reservations "+ "where username = '" + usr + "';");
            
            while ( rs.next() ) {
                    String username = rs.getString("username");
                    int tripID = rs.getInt("tripID"); 
                    int seats = rs.getInt("seats");
                    reservations.add( new Reservation( username, tripID, seats));
                }  
            stmt.close();
            dbConnection.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return reservations;
    }
    
    //A new user is added to the database
    public void addUserToDatabase(String username, String password){
        try{
            Class.forName("org.sqlite.JDBC");
            dbConnection = DriverManager.getConnection("jdbc:sqlite:" + databaseLocation);
            dbConnection.setAutoCommit(false);
            
            stmt = dbConnection.createStatement();
            
            String sqlString = "Insert into Users " +
                    "Values ('" + username + "', '" + password + "');";
            
            stmt.executeUpdate(sqlString);
            
            stmt.close();
            dbConnection.commit();
            dbConnection.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    //A new reservation is added to the database.
    //The corresponding trips freeSeats value is updated accordingly
    public void addReservationToDatabase(String username, int tripID, int numSeats) throws ReservationAlreadyExistsException, InvalidReservationException{
        try{
            Class.forName("org.sqlite.JDBC");
            dbConnection = DriverManager.getConnection("jdbc:sqlite:" + databaseLocation);
            dbConnection.createStatement().execute("PRAGMA foreign_keys = ON");
            dbConnection.setAutoCommit(false);
  
            stmt = dbConnection.createStatement();
            
            String sqlString = "Insert into Reservations Values ( '" + username + "', " + tripID + ", " + numSeats + ");";
            
            stmt.executeUpdate(sqlString);
            
            sqlString = "Update Trips Set freeSeats = freeSeats - " + numSeats + " Where id = " + tripID + ";";
            
            stmt.executeUpdate(sqlString);
            
            stmt.close();
            dbConnection.commit();
            dbConnection.close();
        }catch (SQLException | ClassNotFoundException e){
            if(e.getMessage().equals("UNIQUE constraint failed: Reservations.Username, Reservations.TripID")){
                throw new ReservationAlreadyExistsException();
            }
            if(e.getMessage().equals("FOREIGN KEY constraint failed")){
                throw new InvalidReservationException();
            }
            e.printStackTrace();
        }
    }
    
    //An existing reservation is removed from the database.
    //The corresponding trips freeSeats value is updated accordingly
    public void removeReservationFromDatabase(String username, int tripID) throws ReservationNotFoundException{
        try{
            Class.forName("org.sqlite.JDBC");
            dbConnection = DriverManager.getConnection("jdbc:sqlite:" + databaseLocation);
            dbConnection.setAutoCommit(false);
            
            stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT seats From Reservations where username = '" + username + "' AND tripID = " + tripID + ";"); 
            
            int numSeats = rs.getInt("seats");
            
            String sqlString = "Delete from reservations where username = '" + username + "' and tripID = " + tripID + ";";
            stmt.executeUpdate(sqlString);
            
            sqlString = "Update Trips Set freeSeats = freeSeats + " + numSeats + " Where id = " + tripID + ";";
            stmt.executeUpdate(sqlString);
            
            stmt.close();
            dbConnection.commit();
            dbConnection.close();    
        }catch (SQLException | ClassNotFoundException e){
            if(e.getMessage().equals("ResultSet Closed")){
                throw new ReservationNotFoundException();
            }
        }
            
            
            
    }
    
    //A list of all the users in the database.
    public ArrayList<User> getUsersFromDatabase(){
        ArrayList<User> users = new ArrayList<>();
        try{
            Class.forName("org.sqlite.JDBC");
            dbConnection = DriverManager.getConnection("jdbc:sqlite:" + databaseLocation);
            dbConnection.setAutoCommit(false);
            
            stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * From users");
            
            while ( rs.next() ) {
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                    
                users.add(new User(username, password));
            }
            rs.close();
            stmt.close();
            dbConnection.close();
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return users;
    }  
}
