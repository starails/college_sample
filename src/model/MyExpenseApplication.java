package model;

public class MyExpenseApplication 
{

	public static void main(String[] args) 
	{
		//this is a polymorphic array list which can hold any object which is an Expense. (any subclass of Expense)
		ExpenseList myList = new ExpenseList();
		
		MonthlyExpense phone = new MonthlyExpense ("Phone", 30, 22);
		WeeklyExpense bus = new WeeklyExpense ("Bus", 2.50, Day.TUESDAY );
		AnnualExpense carInsurance = new AnnualExpense (350.25, "Car Insurance",  "AXA Insurance - policy number XXX");
		
		myList.add(phone);
		myList.add(bus);
		myList.add(carInsurance);

		//Print out individual expenses and then total for the month.
		
		System.out.println ("Monthly expenses: " + myList.getCostPerMonthOfAllExpenses());
		// System.out.println ("Your monthly total is: €" + myList.costPerMonthOfAllExpenses());
		
		
	}

}
