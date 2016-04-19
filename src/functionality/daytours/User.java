/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionality.daytours;

import java.util.ArrayList;

/**
 *
 * @author Torfi Karl Ólafsson, Háskóli Íslands, tko2@hi.is
 */
//Class stores information about a user, namely a username and password (encrypted)
public class User {
    private final String username;
    private String password;
    
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    public String getUsername(){ return username; }
    public String getPassword(){ return password; }
}
