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
//Class stores information about a users search criteria.
public class SearchCriteria {
    private String date;
    private String type;
    private String location;
    private int numSeats;

    public SearchCriteria(String date, String type, String location, int numSeats){
        this.date = date;
        this.type = type;
        this.location = location;
        this.numSeats = numSeats;
    }

    public String getDate() { return date; }
    public String getType() { return type; }
    public String getLocation() { return location; }
    public int getNumSeats() { return numSeats; }
}
