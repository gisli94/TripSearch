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
    
    private Flight flight;
    private UserInfo userInfo;

    public Ticket( Flight f, UserInfo u) {
	flight = f;
	userInfo = u;
    }

    public String getFlight() {
	return flight;
    }

    public String getUserInfo() {
	return userInfo;
    }

    public String toString() {
	return ("" + flight + ", " + userInfo);  
    }
    
}
