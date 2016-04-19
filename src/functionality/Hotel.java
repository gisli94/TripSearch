/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionality;

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
    private double price;
    
    public Hotel(String n, String loc, String t, double p) {
        name = n;
        location = loc;
        type = t;
        price = p;
    }
    
}
