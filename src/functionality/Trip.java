/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package functionality;

/**
 *
 * @author Torfi Karl Ólafsson, Háskóli Íslands, tko2@hi.is
 */
//Class stores information about a trip.
public class Trip {
    private final int id;
    private String type;
    private String date;
    private String departureTime;
    private String duration;
    private String location;
    private int maxSeats;
    private int freeSeats;
    private int price;
    
    public Trip(int id, String type, String date, String departureTime,
            String duration, String location, int maxSeats, int freeSeats, int price){
        this.id = id;
        this.type = type;
        this.date = date;
        this.departureTime = departureTime;
        this.duration = duration;
        this.location = location;
        this.maxSeats = maxSeats;
        this.freeSeats = freeSeats;
        this.price = price;
    }
    
    public int getId(){ return id; }
    public String getType(){ return type; }
    public String getDate(){ return date; }
    public String getDepartureTime(){ return departureTime; }
    public String getDuration(){ return duration; }
    public String getLocation(){ return location; }
    public int getMaxSeats(){ return maxSeats; }
    public int getFreeSeats() { return freeSeats; }
    public int getPrice(){ return price; }

}
