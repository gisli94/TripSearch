/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionality.flight;

import java.util.Date;

public interface SearchControllerInterface {

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
	public Flight[] searchOne(String departure, String arrival, int noOfAdults, int noOfChildren, Date departureDate, boolean flexDates);

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
	public Flight[][] searchBoth(String departure, String arrival, int noOfAdults, int noOfChildren, Date departureDate, Date returnDate, boolean flexDates);
	
}
