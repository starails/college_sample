package comparators;

import java.util.Comparator;
import model.Expense;

public class DateComparator implements Comparator<Expense>{

	public int compare(Expense e1, Expense e2) {
		//This uses the static method of the Long wrapper class to compare the creation dates.
		return Long.compare(e1.getCreationDateAndTime(), e2.getCreationDateAndTime());
				
		
	}
}




