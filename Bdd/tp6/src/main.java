import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class main {

	public static void main(String[] args) {
		String date1 = "19/10/2017 à 09:26:49";
		String date2 = "2017-10-18 12:05:00";
		
		date1 = date1.substring(6,10)+"-"+date1.substring(3,5)+"-"+date1.substring(0,2)+" "+date1.substring(13, 20);
		
	}
	
}
