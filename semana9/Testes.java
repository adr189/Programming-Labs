import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test the methods of Padroes.java
 * @author Alexandre Rodrigues 54472
 *
 */
public class Testes {

	/**
	 * Test if the PIN code has 4 digits
	 */
	@Test
	public void testPIN1 () {
		assertTrue(Padroes.matchPIN("o meu PIN é 1234"));
	}

	/**
	 * Test if the PIN code (with 4 characters) has non-numeric characters
	 */
	@Test
	public void testPIN2 () {
		assertFalse(Padroes.matchPIN("o meu PIN é 12aC"));
	}

	/**
	 * Test if the PIN code contains less than 4 digits
	 */
	@Test
	public void testPIN3 () {
		assertFalse(Padroes.matchPIN("o meu PIN é 12"));
	}

	/**
	 * Test if the PIN code contains more than 4 characters
	 */
	@Test
	public void testPIN4 () {
		assertFalse(Padroes.matchPIN("o meu PIN é 1234abc"));
	}

	/**
	 * Test if the number starts with + or 00
	 */
	@Test
	public void testTelefone1 () {
		assertTrue(Padroes.matchTelefone("+263378236457"));
		assertTrue(Padroes.matchTelefone("00263378236457"));
		assertFalse(Padroes.matchTelefone("-263378236457"));
	}

	/**
	 * Test if the country code is 263
	 */
	@Test
	public void testTelefone2 () {
		assertFalse(Padroes.matchTelefone("+553378236457"));
	}

	/**
	 * Test if the number has 9 digits
	 */
	@Test
	public void testTelefone3 () {
		assertFalse(Padroes.matchTelefone("+263378236457065"));
	}

	/**
	 * Test if the number starts with a 0
	 */
	@Test
	public void testTelefone4 () {
		assertFalse(Padroes.matchTelefone("+263078236457"));
	}

	/**
	 * Test if it ends with W or E
	 */
	@Test
	public void testGPS1 () {
		assertTrue(Padroes.matchGPS("41° 24' 12.2”N   2° 10' 26.5”E"));
		assertTrue(Padroes.matchGPS("41° 24' 12.2”N   2° 10' 26.5”W"));
		assertFalse(Padroes.matchGPS("41° 24' 12.2”N   2° 10' 26.5”X"));
	}

	/**
	 * Test if consists of two parts separated by letter N or S
	 */
	@Test
	public void testGPS2 () {
		assertTrue(Padroes.matchGPS("41° 24' 12.2”S   2° 10' 26.5”E"));
		assertFalse(Padroes.matchGPS("41° 24' 12.2”X   2° 10' 26.5”E"));
	}

	/**
	 * Test if both parts are made up of 3 subparts separated by “°“, “'“ and end with double quotes (”)
	 */
	@Test
	public void testGPS3 () {
		assertFalse(Padroes.matchGPS("41&24%12.2$N   2° 10' 26.5”E"));
		assertFalse(Padroes.matchGPS("41° 24' 12.2”N   2&10%26.5$E"));
	}

	/**
	 * Test if both parts start with 1 to 3 digits followed by the ° symbol
	 */
	@Test
	public void testGPS4 () {
		assertFalse(Padroes.matchGPS("2141° 24' 12.2”N   2° 10' 26.5”E"));
		assertFalse(Padroes.matchGPS("41° 24' 12.2”N   2112° 10' 26.5”E"));
	}

	/**
	 * Test if both sub-parts s2 have 1 or 2 digits
	 */
	@Test
	public void testGPS5 () {
		assertFalse(Padroes.matchGPS("41° 124' 112.2”N   2° 10' 26.5”E"));
		assertFalse(Padroes.matchGPS("41° 24' 12.2”N   2° 110' 126.5”E"));
	}
	/**
	 * Test if both sub-parts s3 are composed of 1 or 2 digits followed by a period followed by a digit
	 */
	@Test
	public void testGPS6 () {
		assertFalse(Padroes.matchGPS("41° 24' 12.12”N   2° 10' 26.5”E"));
		assertFalse(Padroes.matchGPS("41° 24' 12.2”N   2° 10' 26.15”E"));
	}

	/**
	 * Test with 10 characters
	 */
	@Test
	public void testUnix1 () {
		assertFalse(Padroes.matchUnix("-drwxrwxrwx"));
	}

	/**
	 * Test ownerPermitions
	 */
	@Test
	public void testUnix2 () {
		assertTrue(Padroes.matchUnix("d---rwxrwx"));
		assertFalse(Padroes.matchUnix("dxxxrwxrwx"));
	}

	/**
	 * Test groupElements
	 */
	@Test
	public void testUnix3 () {
		assertTrue(Padroes.matchUnix("drwx---rwx"));
		assertFalse(Padroes.matchUnix("drwxxxxrwx"));
	}

	/**
	 * Test otherPermitions 
	 */
	@Test
	public void testUnix4 () {
		assertTrue(Padroes.matchUnix("drwxrwx---"));
		assertFalse(Padroes.matchUnix("drwxrwxxxx"));
	}

	/**
	 * Test SUID e SGID
	 */
	@Test
	public void testUnix5 () {
		assertTrue(Padroes.matchUnix("drwsrwxrwx"));
		assertTrue(Padroes.matchUnix("drwxrwsrwx"));
		assertTrue(Padroes.matchUnix("drwSrwxrwx"));
		assertTrue(Padroes.matchUnix("drwxrwSrwx"));
	}

	/**
	 * Test firstElement
	 */
	@Test
	public void testUnix6 () {
		assertTrue(Padroes.matchUnix("drwxrwxrwx")); 
		assertTrue(Padroes.matchUnix("-rwxrwxrwx"));
		assertFalse(Padroes.matchUnix("#rwxrwxrwx"));
	}

	/**
	 * Starts with --
	 */
	@Test
	public void testHaskell1 () {
		assertTrue(Padroes.matchHaskell("-- | sdgkh"));
		assertTrue(Padroes.matchHaskell("-- ^ sdgkh"));
		assertFalse(Padroes.matchHaskell("«» ^ sdgkh"));
	}

	/**
	 * Can be followed by anything
	 */
	@Test
	public void testHaskell2 () {
		assertTrue(Padroes.matchHaskell("--      "));
		assertTrue(Padroes.matchHaskell("-- bvdf"));
		assertTrue(Padroes.matchHaskell("-- 5332"));
		assertTrue(Padroes.matchHaskell("-- .,;:"));
	}

	/**
	 * Can only have one line
	 */
	@Test
	public void testHaskell3 () {
		assertFalse(Padroes.matchHaskell("-- | sdgkh\nbvds"));
	}

	/**
	 * Test year range
	 */
	@Test
	public void testCovid1 () {
		assertTrue(Padroes.matchCovid("covid-19"));
		assertTrue(Padroes.matchCovid("covid-99"));
		assertFalse(Padroes.matchCovid("covid-18"));
	}

	/**
	 * Test capital letters
	 */
	@Test
	public void testCovid2 () {
		assertTrue(Padroes.matchCovid("COVID-19"));
		assertTrue(Padroes.matchCovid("Covid-19"));
		assertTrue(Padroes.matchCovid("covid-19"));
	}

	/**
	 * Test virus designation
	 */
	@Test
	public void testCovid3 () {
		assertFalse(Padroes.matchCovid("corona-19"));
	}

	/**
	 * Test year range digits
	 */
	@Test
	public void testCovid4 () {
		assertFalse(Padroes.matchCovid("covid-100"));
		assertFalse(Padroes.matchCovid("covid-9"));
	}

	/**
	 * Test separator(-)
	 */
	@Test
	public void testCovid5 () {
		assertFalse(Padroes.matchCovid("covid 19"));
	}


}
