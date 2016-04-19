/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionality;

import java.sql.SQLException;
import java.util.ArrayList;
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
        functionality.hotel.Hotel[] h = new functionality.hotel.Hotel[rooms.length];
        
        for (int i = 0; i < rooms.length; i++) {
            h[i] = functionality.hotel.Controller.getHotel(rooms[i].getHotelID());
            if (!h[i].getLocationCity().equals(location)) {
                h[i] = null;
            }
        }
        h = getRidOfNulls(h);
        Hotel[] hotels = createHotelArray(h, rooms);
        return hotels;
    }
    
    public Hotel[] getCurrentHotels() {
        return currentHotels;
    }
    
    private int formatDate(Date date) {
        String s = date.toString();
        String m = s.substring(4, 7);
        if (m.equals("Jan")) {
            m = "00";
        }
        if (m.equals("Feb")) {
            m = "01";
        }
        if (m.equals("Mar")) {
            m = "02";
        }
        if (m.equals("Apr")) {
            m = "03";
        }
        if (m.equals("May")) {
            m = "04";
        }
        if (m.equals("Jun")) {
            m = "05";
        }
        if (m.equals("Jul")) {
            m = "06";
        }
        if (m.equals("Aug")) {
            m = "07";
        }
        if (m.equals("Sep")) {
            m = "08";
        }
        if (m.equals("Oct")) {
            m = "09";
        }
        if (m.equals("Nov")) {
            m = "10";
        }
        if (m.equals("Dec")) {
            m = "11";
        }
        String y = s.substring(s.length()-4, s.length());
        String d = s.substring(8, 10);
        String str = ("" + y + m + d);
        return Integer.parseInt(str);
    }
    
    private int getNumberOfDates(Date s, Date f) {
        return Math.abs(s.getDate() - f.getDate());
    }
    
    private functionality.hotel.Hotel[] getRidOfNulls(functionality.hotel.Hotel[] h) {
        ArrayList<functionality.hotel.Hotel> hotels = new ArrayList<functionality.hotel.Hotel>();
        for (int i = 0; i < h.length; i++) {
            if (h[i] != null) {
                hotels.add(h[i]);
            }
        }
        functionality.hotel.Hotel[] hot = new functionality.hotel.Hotel[hotels.size()];
        for (int i = 0; i < hotels.size(); i++) {
            hot[i] = hotels.get(i);
        }
        return hot;
    }
    
    private Hotel[] createHotelArray(functionality.hotel.Hotel[] h, functionality.hotel.Room[] r) throws SQLException {
        int[] hotelIds = new int[r.length];
        for (int i = 0; i < r.length; i++) {
            hotelIds[i] = r[i].getHotelID();
        }
        
        ArrayList<Hotel> hotels = new ArrayList<>();
        
        for (int i = 0; i < r.length; i++) {
            hotels.add(new Hotel(functionality.hotel.Controller.getHotel(hotelIds[i]).getName(), functionality.hotel.Controller.getHotel(hotelIds[i]).getLocationCity(), r[i].getType(), (int) r[i].getPrice()));
        }
        Hotel[] hot = new Hotel[hotels.size()];
        for (int i = 0; i < hotels.size(); i++) {
            hot[i] = hotels.get(i);
        }
        return hot;
    }
}
