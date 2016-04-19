/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionality.hotel;

/**
 *
 * @author Gisli
 */
public class Hotel {
    
    private String name;
    private String location;
    //private short stars;
    //private HotelReview[] reviews;
    private String type;
    private int price;
    
    public Hotel(String n, String loc, String t, int p) {
        name = n;
        location = loc;
        type = t;
        price = p;
    }
    
    public String getName() {
        return name;
    }
    
    public String getLocation() {
        return location;
    }
    
    public String getType() {
        return type;
    }
    
    public int getPrice() {
        return price;
    }
    
}