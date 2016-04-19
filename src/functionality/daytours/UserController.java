/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionality.daytours;

import functionality.daytours.EncryptionFailedException;
import functionality.daytours.LoginAttemptFailedException;
import functionality.daytours.UserCreationFailedException;
import functionality.daytours.User;
import java.util.ArrayList;


/**
 *
 * @author Torfi Karl Ólafsson, Háskóli Íslands, tko2@hi.is
 */
public class UserController {
    private static final UserController USERCONTROLLER = new UserController();
    private User currentUser;
    private boolean activeLogin;
    private DatabaseConnection dbc;
    Encryptor enc;
      
    private UserController(){
        currentUser = null;
        activeLogin = false;
        dbc = new DatabaseConnection();
        enc = new Encryptor();
    }
    
    public static UserController getInstance(){
        return USERCONTROLLER;
    }
    
    public boolean attemptLogin(String username, String password) throws LoginAttemptFailedException{
        try {
            password = enc.encryptString(password);
        } catch (EncryptionFailedException ex) {
            throw new LoginAttemptFailedException();
        }    
        ArrayList<User> existingUsers = dbc.getUsersFromDatabase();

        for(User user : existingUsers){
            if(user.getUsername().equals(username)){
                if(user.getPassword().equals(password)){
                    currentUser = user;
                    activeLogin = true;
                    return true;
                }
                else {
                    //Correct user, incorrect password.
                }   
            }
        }
        return false;
    }
    
    //Input parameters expected to be read from GUI when a new user is registered.
    public void createNewUser(String username, String password) throws UserCreationFailedException{
        try {
            String encryptedPassword = enc.encryptString(password);
            dbc.addUserToDatabase(username, encryptedPassword);
        } catch (EncryptionFailedException ex) {
            throw new UserCreationFailedException();
        }
    }
    
    public boolean activeLogin(){
        return activeLogin;
    }
    
    public User currentUser(){
        return currentUser;
    }
}
