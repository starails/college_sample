package GUI;
import controller.ExpensesController;
import model.AnnualExpense;
import model.Day;
import model.MonthlyExpense;
import model.WeeklyExpense;

	public class MockGUITesterCreatingExpensesandSavingToDisk {

		public static void main(String[] args)
		{
			//Here we are going to mimic calls which the GUI will make on the controller
			
			//Create a few instances and send them to the controller
			AnnualExpense carInsurance = new AnnualExpense(311.99, "car insurance", "Insurance for my Ford");
			MonthlyExpense phone = new MonthlyExpense("vodafone", 40.00, 22);
			WeeklyExpense lunch = new WeeklyExpense("lunch", 5, Day.MONDAY);
			
			ExpensesController.getInstance().addExpense(carInsurance);
			ExpensesController.getInstance().addExpense(phone);
			ExpensesController.getInstance().addExpense(lunch);
		
			
			//Save the model to disk
			ExpensesController.getInstance().save();
			
		}
		
	}