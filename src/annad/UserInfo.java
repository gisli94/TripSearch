/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package annad;

/**
 *
 * @author Gisli
 */
public class UserInfo {
    
    private String name;
    private String address;
    private String phoneNumber;

    public UserInfo(String n, String a, String p) {
	name = n;
	address = a;
	phoneNumber = p;
    }

    public String getName() {
	return name;
    }

    public String getAddress() {
	return address;
    }

    public String getPhoneNumber() {
	return phoneNumber;
    }

    public String toString() {
	return ("" + name + ", " + address + ", " + phoneNumber);  
    }
}
