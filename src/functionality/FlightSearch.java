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
    
    public FlightSearch(String departureLocation, String arrivalLocation, Date startTime, Date finishTime, boolean flexDates) {
        currentFlights = searchFlights(departureLocation, arrivalLocation, startTime, finishTime, flexDates);
    }
    
    private Flight[] searchFlights(String departureLocation, String arrivalLocation, Date startTime, Date finishTime, boolean flexDates) {
        //
        return null;
    }
    
    private Flight[] getCurrentFlights() {
        return currentFlights;
    }
    
}
