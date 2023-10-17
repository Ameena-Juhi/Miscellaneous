package dateRelated;

public class DaysOfTheWeek {

    private int yyyy;
    private int mm;
    private int dd;

    public DaysOfTheWeek(int year, int month, int day) {
        this.yyyy = year;
        this.mm = month;
        this.dd = day;
    }

    private int getDay() {
        int d = (14 - mm) / 12;
		System.out.println(d);
        int y = yyyy - d;
		System.out.println(y);
        int m = mm + 12 * d - 2;
		System.out.println(m);
        return (dd + y + y / 4 - y / 100 + y / 400 + (31 * m) / 12) % 7;
    }

    public String getDayOfWeek() {
        int dayOfWeek = getDay();
        String[] days = {
            "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
        };
        return days[dayOfWeek];
    }

    public String dateFormatByDayOfWeek() {
        return String.format("%02d/%02d/%04d (%s)", mm, dd, yyyy, getDayOfWeek());
    }

    public static void main(String[] args) {
        // Test the DaysOfTheWeek class
        DaysOfTheWeek date = new DaysOfTheWeek(2023, 10, 4);
        System.out.println(date.dateFormatByDayOfWeek()); // Output: 07/25/2023 (Tuesday)
    }
}
