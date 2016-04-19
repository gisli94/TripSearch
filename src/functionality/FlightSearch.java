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
    
    functionality.flight.Flight[] currentFlights;
    
    public FlightSearch(String departureLocation, String arrivalLocation, int noOfAdults, int noOfChildren, Date startTime, boolean flexDates) {
        currentFlights = searchFlights(departureLocation, arrivalLocation, noOfAdults, noOfChildren, startTime, flexDates);
    }
    
    private functionality.flight.Flight[] searchFlights(String departureLocation, String arrivalLocation, int noOfAdults, int noOfChildren, Date startTime, boolean flexDates) {
        functionality.flight.SearchController sc = new functionality.flight.SearchController();
        //Flight[] fl = new Flight[0];
        functionality.flight.Flight[] flights = sc.searchOne(departureLocation, arrivalLocation, noOfAdults, noOfChildren, startTime, flexDates);
        return flights;
    }
    
    private functionality.flight.Flight[] getCurrentFlights() {
        return currentFlights;
    }
    
    /*
    private Flight[] createFlightArray(functionality.flight.Flight[] f) {
        Flight[] flights = new Flight[f.length];
        for (int i = 0; i < f.length; i++) {
            flights[i] = new Flight(f[i].getDeparture(), f[i].getArrival(), f[i].getDateAndTime(), f[i].getAvailableSeats(), f[i].getCompany(), f[i].getStartPrice());
        }
        return flights;
    }
    */
    
    /*
    private Flight[] createFlightArray(functionality.flight.Flight[][] f) {
        Flight[] flights1 = new Flight[f[0].length];
        Flight[] flights2 = new Flight[f[1].length];
        for (int i = 0; i < flights1.length; i++) {
            flights1[i] = new Flight(f[0][i].getDeparture(), f[0][i].getArrival(), f[0][i].getDateAndTime(), f[0][i].getAvailableSeats(), f[0][i].getCompany(), f[0][i].getStartPrice());
        }
        for (int i = 0; i < flights2.length; i++) {
            flights2[i] = new Flight(f[1][i].getDeparture(), f[1][i].getArrival(), f[1][i].getDateAndTime(), f[1][i].getAvailableSeats(), f[1][i].getCompany(), f[1][i].getStartPrice());
        }
        return concat(flights1, flights2);
    }
    */
    
    /*
    
    private Flight[] concat (Flight[] a, Flight[] b) {
        Flight[] c = new Flight[a.length+b.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }
        for (int i = 0; i < a.length+b.length; i++) {
            c[i-a.length] = b[i];
        }
        return c;
    }

    */
    
}
