/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;
import java.util.*;

/**
 *
 * @author Gisli
 */
public class UserInfo {
    
    private String name;
    private String address;
    private String phoneNumber;
    private String fax;
    private String email;
    private Date dateOfBirth;

    public UserInfo(String n, String a, String p, String f, String e, Date D) {
	this.name = n;
	this.address = a;
	this.phoneNumber = p;
        this.fax = f;
        this.email = e;
        this.dateOfBirth = D;
    }

    public String getName() {
	return this.name;
    }
    
    public String getEmail() {
	return this.email;
    }
    
    public Date getDate() {
	return this.dateOfBirth;
    }
    
    public String getFax() {
	return this.fax;
    }
    
    public String getAddress() {
	return this.address;
    }

    public String getPhoneNumber() {
	return this.phoneNumber;
    }

    public String toString() {
	return ("" + this.name + ", " + this.address + ", " + this.phoneNumber + ", " + this.fax + ", " + this.email + ", " + this.dateOfBirth);  
    }
}
