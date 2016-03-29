package model;

import java.io.Serializable;

public class AnnualExpense extends Expense implements Serializable
{
	private static final long serialVersionUID = 1L;

		private String description;
		
		private static final double numberOfMonths = 12;
		
		public AnnualExpense (double amount,  String name, String description) 
		{
			// This calls the constructor of the superclass (Expense) and creates it
			//before adding on the rest of the object defined in this subclass (AnnualExpense).
			super (amount, name);		
			this.description = description;
		}
		
		public AnnualExpense (double amount, String name, String description, long creationTimeAndDate) 
		{
			super (amount, name, creationTimeAndDate);		
			this.description = description;
		}
		
		public  double calculateCostPerMonth() 
		{
			return getAmount () / numberOfMonths;
		}
		
		public String toString()
		{
			return super.toString() + " " + this.description;
		}
		
		public String getDescription()
		{
			return this.description;
		}
		
}
