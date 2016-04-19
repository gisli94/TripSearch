/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionality.daytours;

import functionality.daytours.SearchCriteria;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Torfi Karl Ólafsson, Háskóli Íslands, tko2@hi.is
 */
public class SearchUtilities {
    //Helper class with methods that contribute to the searching of trips.
    
    //true if all search criteria parameters are valid
    //false otherwise
    public boolean isSearchCriteriaValid(SearchCriteria searchCriteria){
        return ( isChosenDateValid(searchCriteria.getDate()) &&
                 isChosenTypeValid(searchCriteria.getType()) &&
                 isChosenLocationValid(searchCriteria.getLocation()) &&
                 isChosenNumSeatsValid(searchCriteria.getNumSeats()));
    }
        
    //true if input string is one of the available trip types
    //false otherwise
    public boolean isChosenTypeValid(String chosenType){
        return (chosenType.equals("Glacier") || chosenType.equals("Spa") ||
                chosenType.equals("Fishing") || chosenType.equals("Hiking") ||
                chosenType.equals("Sightseeing") || chosenType.equals("Any Type"));
    }
        
    //true if input integer is positive
    //false otherwise
    public boolean isChosenNumSeatsValid(int chosenNumSeats){
        return (chosenNumSeats > 0);
    }
        
    //true if input string is one of the available trip locations
    //false otherwise
    public boolean isChosenLocationValid(String chosenLocation){
        return (chosenLocation.equals("Reykjavik") || 
                chosenLocation.equals("Vestfjords") ||
                chosenLocation.equals("Any Location"));
    }
        
    //true if input date is not earlier than current date
    //false otherwise
    //Strings in dd.mm.yyyy format represent the actual dates
    public boolean isChosenDateValid(String chosenDate){
        String currentDate = getCurrentDate();
            
        //Compare years first
        int currentYear = Integer.parseInt(currentDate.substring(6,10));
        int chosenYear = Integer.parseInt(chosenDate.substring(6,10));
            
        if(currentYear > chosenYear) return false;  
        if(currentYear < chosenYear) return true;

        //If chosen year is same as current, compare months
        int currentMonth = Integer.parseInt(currentDate.substring(3,5));
        int chosenMonth = Integer.parseInt(chosenDate.substring(3,5));

        if(currentMonth > chosenMonth) return false;
        if(currentMonth < chosenMonth) return true;

        //If chosen year and month is same as current, compare days
        int currentDay = Integer.parseInt(currentDate.substring(0,2));
        int chosenDay = Integer.parseInt(chosenDate.substring(0,2));

        if(currentDay > chosenDay) return false;
        else return true;
    }

    //executable sql statement built from the search criteria
    public String buildSQLStatement(SearchCriteria searchCriteria){
        String sqlStatement = "Select * from Trips Where freeseats >= " + searchCriteria.getNumSeats();
        if(!searchCriteria.getDate().equals("Any Date") || !searchCriteria.getLocation().equals("Any Location") || !searchCriteria.getType().equals("Any Type")) {
            sqlStatement += " AND ";
            if (!searchCriteria.getDate().equals("Any Date")) {
                sqlStatement += "Date = '" + searchCriteria.getDate() + "'";
                if (!searchCriteria.getLocation().equals("Any Location")) {
                    sqlStatement += " AND Location = '" + searchCriteria.getLocation() + "'";
                }
                if (!searchCriteria.getType().equals("Any Type")) {
                    sqlStatement += " AND Type = '" + searchCriteria.getType() + "'";
                }
            } else if (!searchCriteria.getLocation().equals("Any Location")) {
                sqlStatement += "Location = '" + searchCriteria.getLocation() + "'";
                if (!searchCriteria.getType().equals("Any Type")) {
                    sqlStatement += " AND Type = '" + searchCriteria.getType() + "'";
                }
            } else if (!searchCriteria.getType().equals("Any Type")) {
                sqlStatement += "Type = '" + searchCriteria.getType() + "'";
            }
            sqlStatement += ";";
        }
        return sqlStatement;
    }
    
    //returns the current date in dd.mm.yyyy format
    public String getCurrentDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }
}
