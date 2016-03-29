package model;

import java.io.Serializable;

public class MonthlyExpense extends Expense implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int dateInMonth;
	
	public MonthlyExpense (String name, double amount, int dateInMonth) 
	{
		// This calls the constructor of the superclass (Expense) and creates it
		//before adding on the rest of the object defined in this subclass (MonthlyExpense).
		super (amount, name);		
		this.dateInMonth = dateInMonth;
	}
	
	public  double calculateCostPerMonth() 
	{
		return getAmount ();
	}
	
	public String toString()
	{
		return super.toString() + " " + this.dateInMonth;
	}
}
