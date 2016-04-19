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
public class ReservationAlreadyExistsException extends Exception{
    //Thrown when an attempt is made to make a reservation that already exists.
    
    public ReservationAlreadyExistsException(){
        super();
    }
    public ReservationAlreadyExistsException(String message){
        super(message);
    }
}
