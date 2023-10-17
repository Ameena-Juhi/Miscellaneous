package dateRelated;
import java.util.*;
public class julian {
	public static void main(String [] args) {
		//private static final String seperator = "/";
		
		//private static final int [] cumulative = {0, 31, 28, 31, 30, 31, 30, 31, 30, 31, 30, 31 };
		String dmy = new String("01-01-2003") ;
		String day = dmy.substring(0 , 2);
		String month = dmy.substring(3 , 5);
		String year = dmy.substring(6);
		int dd = Integer.parseInt(day);
		int mm = Integer.parseInt(month);
		
		
		System.out.println((Integer.parseInt(year)) * 1000 + dd+mm);
		
	}

}
