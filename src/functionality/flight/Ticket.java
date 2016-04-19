/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionality.flight;

import java.util.*;


public class Ticket 
{
	private Customer customer;
	private Flight flight;

	public Ticket(Customer customer, Flight flight)
	{
		this.flight = flight;
		this.customer = customer;
	}

	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}

	public Customer getCustomer()
	{
		return customer;
	}

	public void setFlight(Flight flight)
	{
		this.flight = flight;
	}

	public Flight getFlight()
	{
		return flight;
	}

}
