/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionality.flight;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Flight {

    private int availableSeats;
    private int totalSeats;
    private String arrival;
    private String departure;
    private int startPrice;
    private int flightId;
    private Date dateAndTime;
    private String company;

    public void test(){
    	DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
        Date dateAndTime = null;
        try {
            dateAndTime = df.parse("Thu Apr 4 08:00:00 GMT 2016");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(dateAndTime);
        Flight United93 = new Flight("Test" , 1, 20, "Akureyri","Reykjavik", 13000, 123, dateAndTime);
        System.out.println(United93.calcPrice());
    }

    public Flight(String company, int availableSeats, int totalSeats, String arrival, String departure, int startPrice, int flightId, Date dateAndTime) {
        this.availableSeats = availableSeats;
        this.totalSeats = totalSeats;
        this.arrival = arrival;
        this.departure = departure;
        this.startPrice = startPrice;
        this.flightId = flightId;
        this.dateAndTime = dateAndTime;
        this.company = company;
    }

    public int calcPrice() {
        Date today = new Date();
        int until = (int) (dateAndTime.getTime() - today.getTime());
        double timeFactor = 1/(Math.log10((until/86400000)+4));
        double seatFactor = Math.pow((0.85-(1.0*availableSeats/totalSeats)),3);
        return (int) (startPrice*(timeFactor+seatFactor));
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public int getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(int startPrice) {
        this.startPrice = startPrice;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
}