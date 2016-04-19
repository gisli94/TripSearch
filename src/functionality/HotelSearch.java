/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionality;

import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Gisli
 */
public class HotelSearch {
    
    private Hotel[] currentHotels;
    
    public HotelSearch(String loc, Date sT, Date fT, int nOG) throws SQLException {
        currentHotels = searchHotels(loc, sT, fT, nOG);
    }
    
    public Hotel[] searchHotels(String location, Date startTime, Date finishTime, int numberOfGuests) throws SQLException {
        
        int start = formatDate(startTime);
        int finish = formatDate(finishTime);
        int nrOfDates = getNumberOfDates(startTime, finishTime);
        
        functionality.hotel.Room[] rooms = functionality.hotel.Controller.getAvailability(start, finish, nrOfDates);
        int[] hotelIds = new int[rooms.length];
        functionality.hotel.Hotel[] hotels = new functionality.hotel.Hotel[rooms.length];
        
        for (int i = 0; i < rooms.length; i++) {
            rooms[i].getHotelID();
        }
        
        location = null;
        startTime = null;
        finishTime = null;
        numberOfGuests = 0;
        return null;
    }
    
    public Hotel[] getCurrentHotels() {
        return currentHotels;
    }
    
    private int formatDate(Date date) {
        String s = date.toString();
        String m = s.substring(4, 7);
        if (m.equals("Jan")) {
            m = "01";
        }
        if (m.equals("Feb")) {
            m = "02";
        }
        if (m.equals("Mar")) {
            m = "03";
        }
        if (m.equals("Apr")) {
            m = "04";
        }
        if (m.equals("May")) {
            m = "05";
        }
        if (m.equals("Jun")) {
            m = "06";
        }
        if (m.equals("Jul")) {
            m = "07";
        }
        if (m.equals("Aug")) {
            m = "08";
        }
        if (m.equals("Sep")) {
            m = "09";
        }
        if (m.equals("Oct")) {
            m = "10";
        }
        if (m.equals("Nov")) {
            m = "11";
        }
        if (m.equals("Dec")) {
            m = "12";
        }
        String y = s.substring(s.length()-4, s.length());
        String d = s.substring(8, 10);
        String str = ("" + y + m + d);
        return Integer.parseInt(str);
    }
    
    private int getNumberOfDates(Date s, Date f) {
        return Math.abs(s.getDate() - f.getDate());
    }
}
