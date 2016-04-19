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
public class EncryptionFailedException extends Exception{
    //Thrown when password incryption doesn't execute properly.
    
    public EncryptionFailedException(){
        super();
    }
    public EncryptionFailedException(String message){
        super(message);
    }
}
