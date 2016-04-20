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
        //FlightSearch fs = new FlightSearch(departureLocation, arrivalLocation, noOfAdults, noOfChildren, startTime, flexDates);
        //functionality.flight.Flight[] flights = fs.getCurrentFlights();
        
        // Dummy stuff =)
          functionality.flight.Flight[] flights = new functionality.flight.Flight[10];
           flights[5] = new functionality.flight.Flight("Flugfélag Íslands", 10, 100, "Reykjavík", "Akureyri", 14999, 150, new Date());
            flights[6] = new functionality.flight.Flight("Eagle Air", 10, 100, "Reykjavík", "Akureyri", 21999, 150, new Date());
            flights[7] = new functionality.flight.Flight("Flugfélag Íslands", 10, 100, "Reykjavík", "Akureyri", 11000, 150, new Date());
            flights[8] = new functionality.flight.Flight("Færeyjar Air", 10, 100, "Reykjavík", "Akureyri", 24000, 150, new Date());
            flights[9] = new functionality.flight.Flight("Flugfélag Íslands", 10, 100, "Reykjavík", "Akureyri", 12500, 150, new Date());
      
        flights[0] = new functionality.flight.Flight("Flugfélag Íslands", 10, 100, "Akureyri", "Reykjavík", 24999, 150, new Date());
        flights[1] = new functionality.flight.Flight("Flugfélag Íslands", 10, 100, "Akureyri", "Reykjavík", 19999, 150, new Date());
        flights[2] = new functionality.flight.Flight("Færeyjar Air", 10, 100, "Akureyri", "Reykjavík", 21000, 150, new Date());
        flights[3] = new functionality.flight.Flight("Flugfélag Íslands", 10, 100, "Akureyri", "Reykjavík", 11000, 150, new Date());
        flights[4] = new functionality.flight.Flight("Eagle Air", 10, 100, "Akureyri", "Reykjavík", 12500, 150, new Date());
        
      
        //quickSort(flights, 0, flights.length);
        return flights;
    }
    
    public functionality.hotel.Hotel[] searchHotels(String location, Date startTime, Date finishTime, int numberOfGuests) {
        //HotelSearch hs = new HotelSearch(location, startTime, finishTime, numberOfGuests);
        //functionality.hotel.Hotel[] hotels = hs.getCurrentHotels();
        //quickSort(hotels, 0, hotels.length);
        
        // Dummy
        functionality.hotel.Hotel[] hotels = new functionality.hotel.Hotel[4];
        hotels[0] = new functionality.hotel.Hotel("Hótel Eyrin", "Akureyri", "Double room", 14999);
        hotels[1] = new functionality.hotel.Hotel("Akureyri Hostel", "Akureyri", "Double room", 56999);
        hotels[2] = new functionality.hotel.Hotel("KEA Hótel", "Akureyri", "Double room", 99999);
        hotels[3] = new functionality.hotel.Hotel("Fosshótel", "Akureyri", "Double room", 105999);
        return hotels;
    }
    
    public functionality.daytours.Trip[] searchTours(Date date, String type, String location, int numSeats) {
        //TourSearch ts = new TourSearch(date, type, location, numSeats);
        //return ts.getCurrentTours();
        
        // Dummy
        functionality.daytours.Trip[] trips = new functionality.daytours.Trip[5];
         trips[0] = new functionality.daytours.Trip(0, "Sightseeing", "20/04/2016", "8:00", "7:30", "Golden Circle", 10, 8, 24999);
        trips[1] = new functionality.daytours.Trip(1, "Glacier", "20/04/2016", "8:00", "7:30", "Langjökull", 10, 8, 54999);
        trips[2] = new functionality.daytours.Trip(2, "Snowmobiling", "21/04/2016", "8:00", "8:30", "Vatnajökull", 10, 8, 104999);
        trips[3] = new functionality.daytours.Trip(3, "Northern Lights", "24/04/2016", "20:00", "4:00", "Suðurnes", 10, 8, 24999);
        trips[4] = new functionality.daytours.Trip(4, "Sightseeing", "22/04/2016", "9:00", "7:30", "Suðurland", 10, 8, 24999);
     
        return trips;
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
