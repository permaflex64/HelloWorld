package manualejava9.cap14.par1;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class TestFormattazione {

	public static void main(String[] args) throws Exception {
		testFormatNumeri();
		testFormatter();

		testSimpleDateFormat("dd-MM-yyyy", new Date());
		testSimpleDateFormat("HH:mm:ss", new Date());

		testDateFormat(DateFormat.LONG, Locale.US, new Date());
		testDateFormat(DateFormat.LONG, Locale.ITALIAN, new Date());

		testCalendar();
	}

	private static void testFormatNumeri() throws Exception {
		Locale itLoc = new Locale(Locale.ITALY.getLanguage());
		System.out.println("locale tag --> " + Locale.ITALY.getLanguage());// + " " + Locale.ITALIAN + " " +
																			// Locale.ITALY);

		NumberFormat nfIt = NumberFormat.getInstance(itLoc);
		System.out.println("format --> " + nfIt.format(25.1));

		Number n = nfIt.parse("25,1");
		System.out.println("parse --> " + nfIt.parse("25,1"));
	}

	private static void testFormatter() {
		Formatter f = new Formatter(System.out);
		f.format(Locale.ITALY, "pigreco %1.12f", Math.PI);
		System.out.println();
		f.format(Locale.ENGLISH, "pigreco %1.12f", Math.PI);
		System.out.println();
		Date data = new Date();
		f.format(Locale.ENGLISH, "Date format: %TD", data);
		System.out.println();
		System.out.println("Date println:" + data);
		System.out.printf(Locale.TRADITIONAL_CHINESE, "Date printf: %TD", data);
		System.out.println();
	}

	/**
	 * vedi
	 * file:///home/navigazione/.sdkman/candidates/java/11.0.2-open/docs/api/java.base/java/text/SimpleDateFormat.html
	 */
	private static void testSimpleDateFormat(String pattern, Date data) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String risultato = sdf.format(data);
		System.out.println("Data simpledateformat: " + risultato);
	}

	private static void testDateFormat(int style, Locale locale, Date data) throws Exception {
		DateFormat sdf = DateFormat.getTimeInstance(style, locale);
		String risultato = sdf.format(data);
		System.out.println("Data dateformat: " + risultato);
	}

	private static void testCalendar() {

		Date date = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int settimana = calendar.get(Calendar.WEEK_OF_YEAR);
		System.out.println("settimana dell'anno: " + settimana);

		Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("America/Denver"));
		int hourOfDay = cal.get(Calendar.HOUR_OF_DAY);
		System.out.println("Denver, ora del giorno: " + hourOfDay);

	}
}
