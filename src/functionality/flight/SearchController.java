/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionality.flight;

import java.util.Date;
import java.util.Calendar;
import java.lang.Math;

public class SearchController {
	private DBController dbController;
	private DateFormatter dateFormatter;
	private int dateRange = 11;

	// Initializes class instances
	private void init(){
		dbController = new DBController();
		dateFormatter = new DateFormatter();
	}


	/*
	Gets the difference between two Date objects in days.
	 */
	public int daysBetween(Date date1, Date date2){
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(date1);
		c2.setTime(date2);
		c1.set(Calendar.YEAR, c2.get(Calendar.YEAR));
		int i1 = c1.get(Calendar.DAY_OF_YEAR);
		int i2 = c2.get(Calendar.DAY_OF_YEAR);
		int diffDay = i2 - i1;
		return diffDay;
	}

	/*
	Gets the range of dates stored in a Date array;
	 */ 
	public Date[] getDateRange(Date date, Date today){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int daysBetween = daysBetween(today, date);
		int k = 0;
		Date[] returnDate = new Date[dateRange];
		// Set how many days from date the first 
		// date in the returnDate array should be.
		if(daysBetween >= 0){k = -daysBetween;} 
		// At most 6 days. 
		if(k > 6){k = 6;}
		// If today > date the first date should be 
		// today. Then we only want today, plus 5 days. 
		if(k < 0){
			k = -1;
			dateRange = 6;
		}
		cal.add(Calendar.DAY_OF_YEAR, k);
		for(int i = 0; i < dateRange; i++){
			cal.add(Calendar.DAY_OF_YEAR, 1);
			returnDate[i] = cal.getTime();
		}
		return returnDate;
	}

	/*
	Concatenates two Flight arrays.
	Returns the resulting array.
	*/
	public Flight[] concat(Flight[] array1, Flight[] array2){
		int length1 = array1.length;
		int length2 = array2.length;
		Flight[] resultingArray = new Flight[length1 + length2];
		System.arraycopy(array1, 0, resultingArray, 0, length1);
		System.arraycopy(array2, 0, resultingArray, length1, length2);
		return resultingArray;
	}
	
	/*
	Search for one way flights!
	Returns an array of flights that fit the input. 
	Arguments and description:
	String departure : Where from?
	String arrival : Where to?
	int noOfAdults : Number of adult seats needed.
	int noOfChildren : Number of children seats needed.
	Date departureDate : Date of departure on the form MM/dd/yyyy.
	boolean flexDates : Should the dates be flexible - plus minus 5 days.
	 */
	public Flight[] searchOne(String departure, String arrival, int noOfAdults, int noOfChildren, 
		Date departureDate, boolean flexDates){
		init();
		Flight[] flights = null;
		Date[] dates = null;
		int noOfTickets = noOfAdults + noOfChildren; 
		String s1 = departureDate.toString().substring(0, 10);
		String s2 = departureDate.toString().substring(20);
		String date = s1.concat(s2);
		Date today = new Date();

		if(flexDates){
			dates = getDateRange(departureDate, today);
			flights = dbController.getFlights(departure, arrival, dates[0].toString(), noOfTickets);

			for(int i = 1; i < dateRange; i++ ){
				s1 = dates[i].toString().substring(0, 10);
				s2 = dates[i].toString().substring(20);
				date = s1.concat(s2);
				Flight[] tempFlights = dbController.getFlights(departure, arrival, date, noOfTickets);
				flights = concat(flights, tempFlights);
			}
		}else{
			flights = dbController.getFlights(departure, arrival, date, noOfTickets);
		}
		
		return flights;
 	}


 	private Flight[] searchReturn(String departure, String arrival, int noOfAdults, int noOfChildren, 
		Date departureDate, Date returnDate, boolean flexDates){
		init();
		Flight[] flights = null;
		Date[] dates = null;
		int noOfTickets = noOfAdults + noOfChildren; 
		String s1 = departureDate.toString().substring(0, 10);
		String s2 = departureDate.toString().substring(20);
		String date = s1.concat(s2);

		if(flexDates){
			dates = getDateRange(returnDate, departureDate);
			flights = dbController.getFlights(departure, arrival, dates[0].toString(), noOfTickets);

			for(int i = 1; i < dateRange; i++ ){
				s1 = dates[i].toString().substring(0, 10);
				s2 = dates[i].toString().substring(20);
				date = s1.concat(s2);
				Flight[] tempFlights = dbController.getFlights(departure, arrival, date, noOfTickets);
				flights = concat(flights, tempFlights);
			}
		}else{
			flights = dbController.getFlights(departure, arrival, date, noOfTickets);
		}
		
		return flights;
 	}

	/*
	Search for both ways flights!
	Returns an array 'flights' of array of flights that fit the input. 
	flights[0] = array of flights for the departure flight. 
	flights[1] = array of flights for the return flight.
	Arguments and description:
	String departure : Where from?
	String arrival : Where to?
	int noOfAdults : Number of adult seats needed.
	int noOfChildren : Number of children seats needed.
	Date departureDate : Date of departure in the form MM/dd/yyyy.
	Date returnDate : Date of return in the form MM/dd/yyyy
	boolean flexDates : Should the dates be flexible - plus minus 5 days.
	 */
	public Flight[][] searchBoth(String departure, String arrival, int noOfAdults, int noOfChildren, 
		Date departureDate, Date returnDate, boolean flexDates){
		Flight[] departureFlights = searchOne(departure, arrival, noOfAdults, noOfChildren, departureDate, flexDates);
		Flight[] returnFlights = searchReturn(arrival, departure, noOfAdults, noOfChildren, departureDate, returnDate, flexDates);
		Flight[][] flights = {departureFlights, returnFlights};
		return flights;
	}
    
}
