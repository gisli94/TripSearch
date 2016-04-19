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
import java.util.ArrayList;

/**
 *
 * @author Torfi Karl Ólafsson, Háskóli Íslands, tko2@hi.is
 */
public class ReservationController {
    private DatabaseConnection dbc;
    
    public ReservationController(){
        dbc = new DatabaseConnection();
    }
    
    
    public void bookReservation(String username, int tripID, int numSeats) throws ReservationAlreadyExistsException, InvalidReservationException{
        dbc.addReservationToDatabase(username, tripID, numSeats);
    }
    
    public void cancelReservation(String username, int tripID) throws ReservationNotFoundException{
        dbc.removeReservationFromDatabase(username, tripID);
    }
    
    public ArrayList<Reservation> getReservations(String username){
        return dbc.getReservationsFromDatabase(username);
    }
}
