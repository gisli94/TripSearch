/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionality.flight;

import java.util.*;

public class Customer
{
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private int phoneNumber;
	private String emailAddress;
	
	public Customer()
	{
		this.firstName = "";
		this.lastName = "";
		this.dateOfBirth = new Date();
		this.phoneNumber = 0;
		this.emailAddress = "";
	}
	
	public Customer(String firstName, String lastName, Date dateOfBirth, int phoneNumber, String emailAddress)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}

	public void setFirstName(String fName)
	{
		this.firstName = fName;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setLastName(String lName)
	{
		this.lastName = lName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setDateOfBirth(Date dob)
	{
		this.dateOfBirth = dob; 
	}

	public Date getDateOfBirth()
	{
		return dateOfBirth;
	}

	public void setPhonenumber(int nmbr)
	{
		this.phoneNumber = nmbr;
	}

	public int getPhonenumber()
	{
		return phoneNumber;
	}

	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}

	public String getEmailAddress()
	{
		return emailAddress;
	}
}
