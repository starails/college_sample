package persistors;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.ExpenseList;

public class FilePersistor implements ExpensesPersistor{
	
	//This is a constant point to the location of the file on disk where we are going to serialize the model
	//object ExpenseList.
	public static final String FILE_LOCATION = "H:\\Expenses\\myfile.dat";

	public void save (ExpenseList expenses)
	{
		try
		{
		FileOutputStream fos = new FileOutputStream (FILE_LOCATION);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(expenses);
		oos.close();
		}
		catch (FileNotFoundException f)
		{
			System.out.println(f.getMessage());
		}
		catch (IOException i)
		{
			System.out.println(i.getMessage());
		}
	}
	
	@SuppressWarnings("finally")
	public ExpenseList load()
	{
		//This will story the ExpenseList which is loaded from the serialized file
		ExpenseList loadedList = null;
		try
		{
		FileInputStream fis = new FileInputStream (FILE_LOCATION);
		ObjectInputStream ois = new ObjectInputStream(fis);
		loadedList = (ExpenseList) ois.readObject();
		ois.close();
		}
		catch (FileNotFoundException f)
		{
			System.out.println(f.getMessage());
		}
		catch (IOException i)
		{
			System.out.println(i.getMessage());
		}
		catch (ClassNotFoundException c)
		{
			System.out.println(c.getMessage());
		}
		finally 
		{
			return loadedList;
		}
	}
}
