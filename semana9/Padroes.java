import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Defines legible regular expressions
 * @author Alexandre Rodrigues 54472
 *
 */
public class Padroes {

	/**
	 * PIN number for phones
	 * @param s
	 * @return
	 */
	public static boolean matchPIN(String s) {
		Pattern pNumber = Pattern.compile("\\d{4}$");	//the number contains four digits from 0 to 9

		Matcher mNumber = pNumber.matcher(s);
		if (mNumber.find()){
			return true;
		}
		return false;
	}

	/**
	 * Zimbabwean phone number beginning with the international code
	 * 00263378236457
	 * +263378236457
	 * @param s
	 * @return
	 */
	public static boolean matchTelefone(String s) {
		Pattern pNumber = Pattern.compile("([+]|00)263[1-9]\\d{8}$");	//starts with a + or a 0, followed by 263, a number from 1 to 9 and a digits from 0 to 9

		Matcher mNumber = pNumber.matcher(s);
		if (mNumber.find()){
			return true;
		}
		return false;
	}

	/**
	 * GPS coordinate in degrees-minutes-seconds format
	 * @param s
	 * @return
	 */
	public static boolean matchGPS(String s) {
		Pattern pNumber = Pattern.compile("(90|[0-8]?[0-9])° [0-5]?\\d' [0-5]?\\d[.]\\d”(N|S)\\s+(180|1[0-7][0-9]|[0-9]?\\d)° [0-5]?\\d' [0-5]?\\d[.]\\d”(W|E)"); //Degrees(3 digits) minutes(2) and seconds(2) can be North(N)/South(S) and West(W)/East(E)

		Matcher mNumber = pNumber.matcher(s);
		if (mNumber.matches()){
			return true;
		}
		return false;
	}

	/**
	 * Unix file permission
	 * drwxrwxrwx
	 * -rwxrwxrwx
	 * 
	 * -rwsrwsrwx
	 * -rwSrwSrwx
	 * @param s
	 * @return
	 */
	public static boolean matchUnix(String s) {
		Pattern pNumber = Pattern.compile("(-|d)((r|-)(w|-)(x|s|S|-)){2}((r|-)(w|-)(x|-))");

		Matcher mNumber = pNumber.matcher(s);
		if (mNumber.matches()){
			return true;
		}
		return false;
	}

	/**
	 * Haskell language
	 * @param s
	 * @return
	 */
	public static boolean matchHaskell(String s) {
		Pattern pNumber = Pattern.compile("^--.*$");

		Matcher mNumber = pNumber.matcher(s);
		if (mNumber.matches()){
			return true;
		}
		return false;
	}

	/**
	 * Designation for future COVID type viruses
	 * @param s
	 * @return
	 */
	public static boolean matchCovid(String s) {
		Pattern pNumber = Pattern.compile("(covid|Covid|COVID)-([2-9][0-9]|19)");	//three ways of writing "covid" followed by a dash and the year(either ninetten or between 20 and 99

		Matcher mNumber = pNumber.matcher(s);
		if (mNumber.matches()){
			return true;
		}
		return false;
	}
}
