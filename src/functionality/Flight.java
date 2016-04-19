/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionality;

import java.util.Date;

/**
 *
 * @author Gisli
 */
public class Flight {
    
    private String departureLocation;
    private String arrivalLocation;
    private Date departureTime;
    //private Date arrivalTime;
    private int availableSeats;
    private String airline;
    private int price;
    
    public Flight(String dl, String al, Date dt,/* Date at,*/ int as, String airl, int p) {
        departureLocation = dl;
        arrivalLocation = al;
        departureTime = dt;
        //arrivalTime = at;
        availableSeats = as;
        airline = airl;
        price = p;
    }
    
    public String getDepartureLocation() {
        return departureLocation;
    }
    
    public String getArrivalLocation() {
        return arrivalLocation;
    }
    
    public Date getDepartureTime() {
        return departureTime;
    }
    
    /*
    public Date getArrivalTime() {
        return arrivalTime;
    }
    */
    
    public int getAvailableSeats() {
        return availableSeats;
    }
    
    public String getAirline() {
        return airline;
    }
    
    public int getPrice() {
        return price;
    }
}
