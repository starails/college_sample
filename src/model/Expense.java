package model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public abstract class Expense implements Serializable, Cloneable
{
	private static final long serialVersionUID = 1L;
	private double amount;
	private String name;
	private long creationTimeAndDate;
	
	public Expense(double amount, String name) 
	{
		this.amount = amount;
		this.name = name;
		this.creationTimeAndDate = System.currentTimeMillis();
	}
	
	//used for loading from the database
	public Expense(double amount, String name, long creationTimeAndDate) //overloaded constructor
	{
		this.amount = amount;
		this.name = name;
		this.creationTimeAndDate = creationTimeAndDate;
	}
	
	public double getAmount() 
	{
		return amount;
	}
	
	public void setAmount(double amount) 
	{
		this.amount = amount;
	}
	
	public String getName() 
	{
		return name;
	}
	

	public void setName(String name) 
	{
		this.name = name;
	}
	
	public long getCreationDateAndTime()
	{
		return this.creationTimeAndDate;
	}
		
	
	public abstract double calculateCostPerMonth();
		
	//Override the toString() method
	public String toString()
	{
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(this.creationTimeAndDate);
		DateFormat myDateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
		String formattedDateString = myDateFormat.format(cal.getTime());
		return this.name + " " + this.amount + " " + formattedDateString;
	}
	
	public Expense clone() throws CloneNotSupportedException
	{
		try
		{
			return (Expense)super.clone();
		}
		catch(CloneNotSupportedException e)
		{
			throw new CloneNotSupportedException(e.getMessage());
		}
	}
}
