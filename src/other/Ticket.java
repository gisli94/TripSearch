/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

/**
 *
 * @author Gisli
 */
public class Ticket {
    
    private functionality.Flight flight;
    private UserInfo userInfo;

    public Ticket( functionality.Flight f, UserInfo u) {
	flight = f;
	userInfo = u;
    }

    public Flight getFlight() {
	return flight;
    }

    public UserInfo getUserInfo() {
	return userInfo;
    }

    public String toString() {
	return ("" + flight + ", " + userInfo);  
    }
    
}
