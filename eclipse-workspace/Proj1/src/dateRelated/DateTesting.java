package dateRelated;
//import java.time.DayOfWeek;
//import java.time;

public class DateTesting {
	public static void main(String [] args) {
		Date date = new Date(16,05,2021);
		Date dat = new Date(01,01,2021);
		System.out.println(date);
		System.out.println(date.isLeap(2021));
		System.out.println(date.nextDate());
		System.out.println(dat.PreviousDate());
		System.out.println(date.nextDateAfter(2));
		System.out.println(dat.PrevDateBefore(4));
		System.out.println(dat.DaysOfTheWeek());
		
		
		//System.out.println(getDayOfWeek);
		
	}
}
