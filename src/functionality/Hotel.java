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
    private int numberOfAvailableBeds;
    private int price;
    
    public Hotel(String n, String loc, int nOAB, int p) {
        name = n;
        location = loc;
        numberOfAvailableBeds = nOAB;
        price = p;
    }
    
}
