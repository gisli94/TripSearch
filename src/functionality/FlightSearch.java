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
public class FlightSearch {
    
    Flight[] currentFlights;
    
    public FlightSearch(String departureLocation, String arrivalLocation, int noOfAdults, int noOfChildren, Date startTime, boolean flexDates) {
        currentFlights = searchFlights(departureLocation, arrivalLocation, noOfAdults, noOfChildren, startTime, flexDates);
    }
    
    private Flight[] searchFlights(String departureLocation, String arrivalLocation, int noOfAdults, int noOfChildren, Date startTime, boolean flexDates) {
        functionality.flight.SearchController sc = new functionality.flight.SearchController();
        if (!flexDates) {
            functionality.flight.Flight[] flights = sc.searchOne(departureLocation, arrivalLocation, noOfAdults, noOfChildren, startTime, flexDates);
        }
        return null;
    }
    
    private Flight[] getCurrentFlights() {
        return currentFlights;
    }
    
}
