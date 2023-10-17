package dateRelated;
import java.time.*;
import java.time.DayOfWeek;
import java.util.Locale;
import java.util.*;
public class Date {
	
	public int day;
	public int month;
	public int year;
	private String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
	
	private static final int MONTHS = 12;
	private static final int [] Days_Leap = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int [] Days_NonLeap = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	
	public Date(int dd, int mm, int yyyy) {
		day = dd;
		month = mm;
		year = yyyy;
	}
	
	public static boolean isLeap(int year) {
		 if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
			 return true;
		 }
		 else
			 return false;
	}
	
	public Date nextDate() {
		if (day < (isLeap(year) ? Days_Leap[month] : Days_NonLeap[month]))
			day++;
		else {
			if (month < MONTHS) {
				month++;
				day = 1;
				}
			else {
				year++;
				month = 1;
				day = 1;
				}
				
			}
		
		return new Date(day,month,year);
	}
	
	
	public Date PreviousDate() {
		if (month == 1 && day ==1) {
			year--;
			month = 12;
			day = 31;
		}
		if (day < (isLeap(year) ? Days_Leap[month] : Days_NonLeap[month])) {
			if (day == 1) {
					month--;
					day = (isLeap(year) ? Days_Leap[month] : Days_NonLeap[month]);
				}
			day--;
		}		
		return new Date(day, month,year);
	}
	
	public Date nextDateAfter(int k) {
		for (int i = 0; i < k; i++)
			nextDate();
		return new Date(day,month,year);
	}
	
	public Date PrevDateBefore(int s) {
		for (int i = 0; i < s; i++)
			PreviousDate();
		return new Date(day,month,year);
	}
	
	//https://www.geeksforgeeks.org/zellers-congruence-find-day-date/
	
	public String DaysOfTheWeek(){
		int adjuster = (14 - month) / 12;
    	int adjustedYear = year - adjuster;
    	int adjustedMonth = month + 12 * adjuster - 2;
    	int newDay = (day + adjustedYear + adjustedYear / 4 - adjustedYear / 100 + adjustedYear / 400 + (31 * adjustedMonth) / 12) % 7;
    	return days[newDay];
	}
	
	@Override
	public String toString() {
		return String.format("%02d-%02d-%04d",day,month,year);
	}
	
}
