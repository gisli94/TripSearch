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
        Flight[] fl = new Flight[0];
        if (!flexDates) {
            functionality.flight.Flight[] flights = sc.searchOne(departureLocation, arrivalLocation, noOfAdults, noOfChildren, startTime, flexDates);
            fl = createFlightArray(flights);
        }
        return fl;
    }
    
    private Flight[] getCurrentFlights() {
        return currentFlights;
    }
    
    private Flight[] createFlightArray(functionality.flight.Flight[] f) {
        Flight[] flights = new Flight[f.length];
        for (int i = 0; i < f.length; i++) {
            flights[i] = new Flight(f[i].getDeparture(), f[i].getArrival(), f[i].getDateAndTime(), f[i].getAvailableSeats(), f[i].getCompany(), f[i].getStartPrice());
        }
        return flights;
    }
    
}
