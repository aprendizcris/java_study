import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
//import java.util.TimeZone;

public class Main {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		Date x1 = new Date();
		
		Date y1 = sdf.parse("04/06/1973 01:00:00");

		System.out.println("x1: " + sdf.format(x1));
		System.out.println("y1: " + sdf.format(y1));
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(y1);
		cal.add(Calendar.HOUR_OF_DAY, 4);
		Date d = cal.getTime();
		
		System.out.println("d: " + sdf.format(d));
		
		cal.setTime(x1);
		int minutes = cal.get(Calendar.MINUTE);
		int month = 1 + cal.get(Calendar.MONTH);
		
		System.out.println("Minutes: " + minutes);
		System.out.println("Month: " + month);
	}

}
