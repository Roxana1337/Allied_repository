import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatter {
    static String dateToString1;
    static String stringToDate1;

    public static void main(String[] args) throws ParseException {
        dateToString1 = dateToString();
        stringToDate1 = stringToDate();
        dateToString();
        stringToDate();
    }

    public static String dateToString() throws ParseException{
        String myStringDate = "18/11/1997";
        Date myStringDateFormatted = new SimpleDateFormat("dd/MM/yyyy")
                .parse(myStringDate);
        System.out.println("My string date as a date is: " + myStringDateFormatted);
        return myStringDate;
    }

    public static String stringToDate() {
        String pattern = "dd-MM-yyyy";
        DateFormat formatter = new SimpleDateFormat(pattern);
        Date myDateDate = Calendar.getInstance().getTime();
        String myDateToStringFormatted = formatter.format(myDateDate);
        System.out.println("My date as a string is: " + myDateToStringFormatted);
        return pattern;
    }
}

