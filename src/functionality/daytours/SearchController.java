/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionality.daytours;

import functionality.daytours.SearchCriteriaIsInvalidException;
import functionality.daytours.Trip;
import functionality.daytours.SearchCriteria;
import java.util.ArrayList;


/**
 *
 * @author Torfi Karl Ólafsson, Háskóli Íslands, tko2@hi.is
 */
public class SearchController {
    private DatabaseConnection dbc;
    private SearchUtilities srcUtil;
    
    public SearchController(){
        dbc = new DatabaseConnection();
        srcUtil = new SearchUtilities();
    }
    
    //A list of trips that match the input search criteria.
    public ArrayList<Trip> searchForTrips (SearchCriteria searchCriteria) throws SearchCriteriaIsInvalidException{
        //make sure the search criteria is valid, to avoid malicious sql injections
        if(srcUtil.isSearchCriteriaValid(searchCriteria)){
            String SQLStatement = srcUtil.buildSQLStatement(searchCriteria);
            return dbc.getTripsFromDatabase(SQLStatement);
        }
        else throw new SearchCriteriaIsInvalidException();
    }

}
