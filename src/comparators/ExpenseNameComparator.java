package comparators;

import java.util.Comparator;

import model.Expense;

public class ExpenseNameComparator implements Comparator<Expense> {

	public int compare(Expense e1, Expense e2) {
		//This is using the fact that String is already Comparable and has implemented the 
		//compareTo method to allow it to compare itself to other Strings.
		return e1.getName().compareTo(e2.getName());
	}
	
	/*Although .equals is a method of the Comparator interface we are not forced
	to implement it because it is already implemented by  jave.lang.Object (which every class extends), 
	 therefore this class inherits that. The version of equals in java.lang.Object compares two objects for equality
	 by their memory address. You only need to override or implement equals here if you want to use 
	something different to compare their equality.  */

}
