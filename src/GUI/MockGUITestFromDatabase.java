package GUI;

import java.util.ArrayList;

import controller.ExpensesController;
import controller.PersistenceType;
import model.Expense;

public class MockGUITestFromDatabase {
	public static void main (String[] args)
	{
		//Load expenses from file.
		ExpensesController.getInstance().setPersistenceMode(PersistenceType.DATABASE);
		ExpensesController.getInstance().load();
		
		//Display all expenses
		ArrayList<Expense> expenseList = ExpensesController.getInstance().getListOfExpenses();
		
		for (Expense e: expenseList)
		{
			System.out.println(e.getName() + "\t Cost: €" + e.getAmount());
		}
		
		
		
	}
}
