/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionality.daytours;

import functionality.daytours.InvalidReservationException;
import functionality.daytours.LoginAttemptFailedException;
import functionality.daytours.ReservationAlreadyExistsException;
import functionality.daytours.ReservationNotFoundException;
import functionality.daytours.SearchCriteriaIsInvalidException;
import functionality.daytours.SearchCriteria;
import functionality.daytours.Trip;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Torfi Karl Ólafsson, Háskóli Íslands, tko2@hi.is
 */
public class DayTripsProject {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatabaseConnection dbConn = new DatabaseConnection();
        UserController userController = UserController.getInstance();
        SearchController searchController = new SearchController();
        ReservationController resController = new ReservationController();
        
        //Testing the search mechanism.
        try {
            ArrayList<Trip> trips = searchController.searchForTrips(new SearchCriteria("21.05.2016", "Spa", "Reykjavik", 4));
            if(!trips.isEmpty()){
                for (Trip trip: trips){
                    System.out.println(trip.getId());
                }
            }
        } catch (SearchCriteriaIsInvalidException ex) {
            System.out.println("The search criteria contained invalid information, please try again.");
        }
        
        //Testing the login mechanism. 
        //Currently tko2 is the only registered user, and lalala0909 is the password. Any other username/password combination should fail.
        String inputUsername = "tko2";
        String inputPassword = "lalala0909"; 
        try {
            if(userController.attemptLogin(inputUsername, inputPassword)){
                System.out.println("Success. You're logged in with the username " + userController.currentUser().getUsername());
            }
            else{
                System.out.println("Incorrect username or password.");
                //User/Pass combination invalid.
            }
        } catch (LoginAttemptFailedException ex) {
            System.out.println("Something went wrong. Please try again");
            //Something went wrong. User/Pass combination not comfirmed. (probably the password encryption failed)
        }
        
        
        //Testing the booking mechanism
        int tripID = 5;
        int seats = 4;
        
        if(userController.activeLogin()){
            try {
                dbConn.addReservationToDatabase(userController.currentUser().getUsername(), tripID, seats);
            } catch (ReservationAlreadyExistsException ex) {
                //Can't have two reservations with the same username and tripID.
            } catch (InvalidReservationException ex) {
                //Either the username or tripID doesn't exist in the database.
            }
        }
        else{
            //Prompt the user to login before reserving.
        }
        
        //Testing the unbooking mechanism.
        try {
            dbConn.removeReservationFromDatabase("username", 4);
        } catch (ReservationNotFoundException ex) {
            //No reservation with this username and tripID exists.
            System.out.println("Reservation not found.");
        }
        
        
        
                
       
        
        /*try {
            userController.createNewUser("SOME_USERNAME", "SOME_PASSWORD");
        } catch (UserCreationFailedException ex) {
            //User creation didn't complete. Probable failure with password encryption.
        }*/
    }
    
}
