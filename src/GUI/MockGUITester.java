package GUI;

import model.Expense;

import java.util.ArrayList;

import controller.ExpensesController;
import model.AnnualExpense;
import model.Day;
import model.MonthlyExpense;
import model.WeeklyExpense;

public class MockGUITester {

	public static void main (String[] args)
	{
		//Here we are going to mimic calls which the GUI will make on the controller
		
		//Create a few instances and send them to the controller
				
		MonthlyExpense phone = new MonthlyExpense ("Phone", 30, 22);
		WeeklyExpense lunch = new WeeklyExpense ("Lunch", 8, Day.TUESDAY );
		AnnualExpense carInsurance = new AnnualExpense (350.25, "Car Insurance", "AXA Insurance");
		
		ExpensesController.getInstance().addExpense(carInsurance);
		ExpensesController.getInstance().addExpense(lunch);
		ExpensesController.getInstance().addExpense(phone);
		
		//Display all expenses
		
		ArrayList<Expense> expenseList = ExpensesController.getInstance().getListOfExpenses();
		for (Expense e: expenseList)
		{
			System.out.println(e.getName() + "\t Cost: €" + e.getAmount());
		}
		
		
		
		for (Expense e: expenseList)
		{
			System.out.println(e.getName() + "\t Cost: €" + e.getAmount());
		}
		
		
		//Print out the total
		System.out.println("Total Monthly Expense = €" + ExpensesController.getInstance().getMonthlyCost());
		
		ExpensesController.getInstance().save();
	}
}
