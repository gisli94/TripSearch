/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionality.daytours;

/**
 *
 * @author Torfi Karl Ólafsson, Háskóli Íslands, tko2@hi.is
 */
//Class stores information about a reservation made by a user.
public class Reservation {
    private String username;
    private int tripID;
    private int numSeats;
    
    public Reservation(String username, int tripID, int numSeats){
        this.username = username;
        this.tripID = tripID;
        this.numSeats = numSeats;
    }
    
    public int getNumSeats(){ return numSeats; } 
    public String getUsername(){ return username; }
    public int getTripID(){ return tripID; }
}
