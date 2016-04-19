/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionality.flight;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateFormatter {

	// The format of date we want to use in the project.  
   
  // This one is for flights. 
  // Example : Thu Apr 4 08:00:00 GMT 2016
	private SimpleDateFormat sdf1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy"); 

  // This one is for the customers.
  // Example : 12/24/1985
  private SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");

  /*
  Converts a string representation of the date and time of flight to a date.
   */
  public Date stringToDate(String string){
  	Date returnDate = null;
	try {
 			returnDate = sdf1.parse(string);

	   } catch (ParseException e) {
 			 e.printStackTrace();
	   }	

    return returnDate;
  }

  /*
  Converts a string representation of the date of birth of a customer to a date.
   */  
  public Date stringToDateCustomer(String string){
    Date returnDate = null;
    try {
    returnDate = sdf2.parse(string);
    }catch (ParseException e){
      e.printStackTrace();
    }
    return returnDate;
  }

  /*
  Converts a date representation of the date to a string.
  */
  public String dateToString(Date date){
    return date.toString();
  }

  /*
  Converts a date representation for the customer to a string.
   */
  public String dateToStringCustomer(Date date){
    String s = sdf2.format(date);
    return s;
  }

  /*
  Converts from MM/dd/yyyy to EEE MMM dd HH:mm:ss z yyyy
   */
  public Date converterOne(Date date){
    String d = sdf1.format(date);
    date = stringToDate(d);
    return date;
  }
  /*
  Converts from EEE MMM dd HH:mm:ss z yyyy to MM/dd/yyyy
   */
  public Date converterTwo(Date date){
    String d = sdf2.format(date);
    date = stringToDate(d);
    return date;
}
}
