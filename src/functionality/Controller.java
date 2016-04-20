/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionality;

import functionality.daytours.SearchCriteriaIsInvalidException;
import java.sql.SQLException;
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
    
    public functionality.flight.Flight[] searchFlights(String departureLocation, String arrivalLocation, int noOfAdults, int noOfChildren, Date startTime, Date returnTime, boolean flexDates) {
        FlightSearch fs = new FlightSearch(departureLocation, arrivalLocation, noOfAdults, noOfChildren, startTime, flexDates);
        functionality.flight.Flight[] flights = fs.getCurrentFlights();
        quickSort(flights, 0, flights.length);
        return flights;
    }
    
    public functionality.hotel.Hotel[] searchHotels(String location, Date startTime, Date finishTime, int numberOfGuests) throws SQLException {
        HotelSearch hs = new HotelSearch(location, startTime, finishTime, numberOfGuests);
        functionality.hotel.Hotel[] hotels = hs.getCurrentHotels();
        quickSort(hotels, 0, hotels.length);
        return hotels;
    }
    
    public functionality.daytours.Trip[] searchTours(Date date, String type, String location, int numSeats) throws SearchCriteriaIsInvalidException {
        TourSearch ts = new TourSearch(date, type, location, numSeats);
        return ts.getCurrentTours();
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
    
    private void quickSort(functionality.hotel.Hotel[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		int middle = low + (high - low) / 2;
		functionality.hotel.Hotel pivot = arr[middle];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i].getPrice() < pivot.getPrice()) {
				i++;
			}
 
			while (arr[j].getPrice() > pivot.getPrice()) {
				j--;
			}
 
			if (i <= j) {
				functionality.hotel.Hotel temp = arr[i];
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
