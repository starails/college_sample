package GUI;

import model.Expense;
import java.util.ArrayList;
import java.util.Collections;

import controller.ExpensesController;
import comparators.ExpenseNameComparator;


public class MockGUITestFromDisk {
	public static void main (String[] args)
	{
		//Load expenses from file.
		ExpensesController.getInstance().load();
		
		//Display all expenses
		ArrayList<Expense> expenseList = ExpensesController.getInstance().getListOfExpenses();
		Collections.sort(expenseList, new ExpenseNameComparator());
		for (Expense e: expenseList)
		{
			System.out.println(e.getName() + "\t Cost: €" + e.getAmount());
		}
		
		
		
	}
}
