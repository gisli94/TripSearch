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
public class Controller {
    
    private functionality.flight.Flight[] flightCart;
    private functionality.hotel.Hotel currentHotel;
    private functionality.daytours.Trip currentTour;
    
    public Controller() {
        
    }
    
    public void searchFlights(String departureLocation, String arrivalLocation, int noOfAdults, int noOfChildren, Date startTime, boolean flexDates) {
        FlightSearch fs = new FlightSearch(departureLocation, arrivalLocation, noOfAdults, noOfChildren, startTime, flexDates);
        functionality.flight.Flight[] flights = fs.getCurrentFlights();
        quickSort(flights, 0, flights.length);
    }
    
    private void quickSort(functionality.flight.Flight[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		int middle = low + (high - low) / 2;
		functionality.flight.Flight pivot = arr[middle];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i].getStartPrice() < pivot.getStartPrice()) {
				i++;
			}
 
			while (arr[j].getStartPrice() > pivot.getStartPrice()) {
				j--;
			}
 
			if (i <= j) {
				functionality.flight.Flight temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
	}
    
}
