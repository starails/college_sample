package model;

import java.io.Serializable;

public class WeeklyExpense extends Expense implements Serializable
{
	private static final long serialVersionUID = 1L;

	private static final double WEEKS_IN_MONTH = 4.2;
	
	private Day dayOfWeek;
	
	public WeeklyExpense (String name, double amount, Day dayOfWeek) 
	{
		// This calls the constructor of the superclass (Expense) and creates it
		//before adding on the rest of the object defined in this subclass (WeeklyExpense).
		super (amount, name);		
		this.dayOfWeek = dayOfWeek;
	}
	
	public  double calculateCostPerMonth() 
	{
		return getAmount () * WEEKS_IN_MONTH;
	}
	
	public String toString()
	{
		return super.toString() + " " + this.dayOfWeek;
	}
}
