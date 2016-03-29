package GUI;


import controller.ExpensesController;
import controller.PersistenceType;
import model.AnnualExpense;


public class MockGUITesterCreatingExpensesAndSavingToDatabase {



		public static void main(String[] args)
		{
			//Here we are going to mimic calls which the GUI will make on the controller
			
			//Create a few instances and send them to the controller
			AnnualExpense carInsurance = new AnnualExpense(311.99, "car insurance",  "Insurance for my Ford");
			AnnualExpense phoneInsurance = new AnnualExpense(32.52, "phone insurance",  "Phone insurance");
			//MonthlyExpense phone = new MonthlyExpense("vodafone", 40.00, 22);
			//WeeklyExpense lunch = new WeeklyExpense("lunch", 5, Day.MONDAY);
			
			ExpensesController.getInstance().addExpense(carInsurance);
			ExpensesController.getInstance().addExpense(phoneInsurance);
			//ExpensesController.getInstance().addExpense(phone);
			//ExpensesController.getInstance().addExpense(lunch);
		
			ExpensesController.getInstance().setPersistenceMode(PersistenceType.DATABASE);
			
			
			//Save the model to disk
			ExpensesController.getInstance().save();
			
		}
		
	}
