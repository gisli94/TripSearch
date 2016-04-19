/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionality.daytours;

/**
 *
 * @author Torfi Karl Ólafsson, Háskóli Íslands, tko2@hi.is
 */
public class UserCreationFailedException extends Exception{
    //Thrown when an attempt to create a user doesn't execute properly.
    
    public UserCreationFailedException(){
        super();
    }
    public UserCreationFailedException(String message){
        super(message);
    }
}
