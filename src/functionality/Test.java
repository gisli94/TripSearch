/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionality;

import java.util.Date;

/**
 *
 * @author Gisli
 */
public class Test {
    
    public static void main (String[] args) {
        Date date = new Date("09.02.1994");
        System.out.println(date);
        int year = date.getYear();
        int month = date.getMonth();
        int day = date.getDate();
        String str = ("" + day + "." + month+1 + "." + year);
        System.out.println(str);
    }
    
    
}
