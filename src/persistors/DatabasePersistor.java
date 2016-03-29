package persistors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.AnnualExpense;
import model.Expense;
import model.ExpenseList;

public class DatabasePersistor implements ExpensesPersistor{

	private Connection dbConnection;
	
	public DatabasePersistor() 
	{
		try{
			//Create an instance of the database driver.
			Class.forName("com.mysql.jdbc.Driver");
			//Connect to database
			this.dbConnection = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/aileensdb?user=starails&password=OOPLabtest");
			
				if (this.dbConnection != null)
				{
					System.out.println("Connnected to database! : " + this.dbConnection);
				}
				else
				{
					System.out.println("Connection failed");
				}
		
		}
		catch (ClassNotFoundException c)
		{
			System.out.println(c.getMessage());
		} catch (SQLException s) {
			System.out.println(s.getMessage());
		}
	}
	
	public void save (ExpenseList expenses) 
	{
	try 
		
	{
		dbConnection.setAutoCommit(false);
		// For the moment we are going to deal purely with AnnualExpense objects.
		//We will extend this in the future.
		
		for (Expense currExpense : expenses.getExpenses())
		{
			AnnualExpense annualExpense = (AnnualExpense)currExpense;
			PreparedStatement prepStmt = dbConnection.prepareStatement("INSERT into EXPENSE values (?, ?, ?, ?)");
			prepStmt.setDouble(1, annualExpense.getAmount());
			prepStmt.setString(2, annualExpense.getName());
			prepStmt.setString(3, annualExpense.getDescription());
			prepStmt.setString(4, Long.toString(annualExpense.getCreationDateAndTime()));
			prepStmt.executeUpdate();
			prepStmt.close();
		}
		
		dbConnection.commit();
		dbConnection.setAutoCommit(true);
	}
	catch(SQLException sqlEx)
	{
		System.out.println(sqlEx.getMessage());
	}
	}
	
	public ExpenseList load()
	{
		//Create empty ExpenseList which will be populated by recreated objects below.
		ExpenseList list = new ExpenseList();
		try
		{
		Statement stmt = dbConnection.createStatement();
		ResultSet resultsTable = stmt.executeQuery("SELECT * from EXPENSE");
		
		while(resultsTable.next())
		{
			
			double amount = resultsTable.getDouble("amount");
			String name = resultsTable.getString("name");
			String description = resultsTable.getString("description");
			long creationTimeAndDate = Long.parseLong(resultsTable.getString("creationtime"));
			
			//Recreate an AnnualExpense object with the data just read from the database.
			 AnnualExpense recreatedExpense =  new AnnualExpense(amount, name, description, creationTimeAndDate);
			 list.add(recreatedExpense);
		}	
		
		resultsTable.close();
		stmt.close();
		
		}
		catch(SQLException sqlEx)
		{
			System.out.println(sqlEx.getMessage());
		}
		return list;
	}
	
}
