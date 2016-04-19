/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionality.flight;

public class BookingController implements BookingControllerInterface{

    DBController dbc;

    public BookingController(DBController dbc) {
        this.dbc = dbc;
    }

    @Override
    public void makeBookings(Ticket[] tickets) {
        int numberOfTickets = tickets.length;
        for (int i=0; i<tickets.length;i++) {
            dbc.changeSeatAvailability(tickets[i].getFlight().getFlightId(), 1);
            Customer cus = tickets[i].getCustomer();
            addCustomer(cus);
            dbc.addTicket(tickets[i]);
        }
    }

    @Override
    public Ticket makeTicket(Flight flight, Customer customer) {
        return new Ticket(customer, flight);
    }

    @Override
    public void addCustomer(Customer cus) {
        if(dbc.getCustomer(cus.getEmailAddress())==null) {
            dbc.addCustomer(cus);
        }
    }
}
