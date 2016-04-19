/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionality.daytours;

import functionality.daytours.EncryptionFailedException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 *
 * @author Torfi Karl Ólafsson, Háskóli Íslands, tko2@hi.is
 */

public class Encryptor {   
    //MD5 encryption of a String input.
    public String encryptString(String str) throws EncryptionFailedException {   
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(str.getBytes("UTF-8"));
            byte[] encryptedStringInBytes = md.digest();
            String encryptedString = Arrays.toString(encryptedStringInBytes);
            return encryptedString;
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            throw new EncryptionFailedException();
        }
    }
}
