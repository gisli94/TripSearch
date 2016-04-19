/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionality.flight;

public interface BookingControllerInterface {

	DBController dbc = new DBController();

	/*
	Makes bookings in the Ticket table in the database for all the "tickets".
	Decrements the available seats column for the appropriate flight by the number of tickets.
	 */
    public void makeBookings(Ticket[] tickets);

    /*
    Makes a Ticket object for the appropriate flight and customer.
    Adds the ticket to the Ticket array "tickets".
     */
    public Ticket makeTicket(Flight flight, Customer customer);

    /*
    Adds the "customer" to the database.
    Note that a customer must be in the database before ticket is made. 
    Adds the customer to the Customer array "customers".
     */
    public void addCustomer(Customer customer);
    
}
