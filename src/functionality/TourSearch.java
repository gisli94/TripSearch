/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionality;

import functionality.daytours.SearchCriteriaIsInvalidException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Gisli
 */
public class TourSearch {
    
    private functionality.daytours.Trip[] currentTours;
    
    public TourSearch(Date date, String type, String location, int numSeats) throws SearchCriteriaIsInvalidException {
        currentTours = searchTours(date, type, location, numSeats);
    }
    
    private functionality.daytours.Trip[] searchTours(Date date, String type, String location, int numSeats) throws SearchCriteriaIsInvalidException {
        functionality.daytours.SearchController sc = new functionality.daytours.SearchController();
        int year = date.getYear();
        int month = date.getMonth();
        int day = date.getDate();
        String str = "";
        if (day < 10) {
            str = ("0" + day + "." + (month+1) + "." + year);
        }
        else {
            str = ("" + day + "." + (month+1) + "." + year);
        }
        functionality.daytours.SearchCriteria scrit = new functionality.daytours.SearchCriteria(str, type, location, numSeats);
        ArrayList<functionality.daytours.Trip> al = new ArrayList<functionality.daytours.Trip>();
        al = sc.searchForTrips(scrit);
        functionality.daytours.Trip[] trips = new functionality.daytours.Trip[al.size()];
        for (int i = 0; i < al.size(); i++) {
            trips[i] = al.get(i);
        }
        return trips;
    }
    
    private functionality.daytours.Trip[] getCurrentTours() {
        return currentTours;
    }
    
}
