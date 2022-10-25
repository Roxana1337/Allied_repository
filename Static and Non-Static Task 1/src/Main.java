import javax.swing.text.DateFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public Main() throws ParseException {


        public static void main (String[]args){

            SimpleDateFormat stringToDate = new SimpleDateFormat("dd-MM-yyyy");
            String stringDate = "18-11-1997";
            Date myStringToDate = stringToDate.parse(stringDate);
        }
    }
}


