package ss.week1;

/** 
 * Testprogram Password.
 * Lab exercise Softwaresystems
 * @author Arend Rensink
 * @version $Revision: 1.2 $
 */
public class PasswordTest {
	/** Testvariabele for a <tt>Password</tt> object. */
	public Password pass;

	/** Number of errors. */
	private int errors;
	/** Notice belonging to test method. */
	private boolean isPrinted;
	/** Indication that an errors was found in test method. */
	private String description;

	/** Calls all tests in this class one-by-one. */
	public int runTest() {
		System.out.println("Testclass: " + this.getClass());
		setUp();
		testAcceptable();
		setUp();
		testTestWord();
		setUp();
		testSetWordWrongOld();
		setUp();
		testSetWordWrongNew();
		setUp();
		testSetWordOkay();
		if (errors == 0) {
			System.out.println("    OK");
		}
		return errors;
	}

	/**
	 * Sets the instance variable <tt>pass</tt> to a well-defined initial value.
	 * All test methods should be preceded by a call to this method.
	 */
	public void setUp() {
		// initialisation of password-variable
		pass = new Password();
	}

	/**
	 * Test the method <tt>acceptable(suggestion)</tt>
	 * This method should be preceded by a call to <tt>{@link #setUp}</tt>.
	 */
	public void testAcceptable() {
		beginTest("Method acceptable");
		assertEquals("pass.acceptable(\"no\")", false, pass.acceptable("no"));
		assertEquals("pass.acceptable(\"no no\")", false,
				pass.acceptable("no no"));
		assertEquals("pass.acceptable(\"yesyesyes\")", true,
				pass.acceptable("yesyesyes"));
	}

	/**
	 * Test the method <tt>testWord</tt>
	 * This method should be preceded by a call to <tt>{@link #setUp}</tt>.
	 */
	public void testTestWord() {
		beginTest("Methode testWord");
		assertEquals("pass.testWord(\"wrong\")", false, pass.testWord("wrong"));
		assertEquals("pass.testWord(Password.INITIAL)", true,
				pass.testWord(new String(Password.INITIAL)));

	}

	/**
	 * Test the method <tt>setWord</tt> with a wrong old password.
	 * This method should be preceded by a call to <tt>{@link #setUp}</tt>.
	 */
	public void testSetWordWrongOld() {
		beginTest("setWord with a wrong old password");
		String wrongOld = "wrongwrong";
		String newpass = "yesyesyes";
		assertEquals("pass.setWord(\"" + wrongOld + "\", \"" + newpass + "\")",
				false, pass.setWord(wrongOld, newpass));
		assertEquals("pass.testWord(Password.INITIAL)", true,
				pass.testWord(Password.INITIAL));
		assertEquals("pass.testWord(\"" + newpass + "\")", false,
				pass.testWord(newpass));
	}

	/**
	 * Test the method <tt>setWord</tt> with an unacceptable new password.
	 * This method should be preceded by a call to <tt>{@link #setUp}</tt>.
	 */
	public void testSetWordWrongNew() {
		beginTest("setWord with an unacceptable new password");
		String wrongNew = "no no";
		assertEquals("pass.setWord(Password.INITIAL, \"" + wrongNew + "\")",
				false, pass.setWord(Password.INITIAL, wrongNew));
		assertEquals("pass.testWord(Password.INITIAL)", true,
				pass.testWord(Password.INITIAL));
		assertEquals("pass.testWord\"" + wrongNew + "\")", false,
				pass.testWord(wrongNew));
	}

	/**
	 * Test the method <tt>setWord</tt> for correct usage.
	 * This method should be preceded by a call to <tt>{@link #setUp}</tt>.
	 */
	public void testSetWordOkay() {
		beginTest("setWord for correct usage");
		String newpass = "yesyesyes";
		assertEquals("pass.setWord(Password.INITIAL, \"" + newpass + "\")",
				true, pass.setWord(Password.INITIAL, newpass));
		assertEquals("pass.testWord(Password.INITIAL)", false,
				pass.testWord(Password.INITIAL));
		assertEquals("pass.testWord(\"" + newpass + "\")", true,
				pass.testWord(newpass));
	}

	/**
	 * Fixes the status for the testmethod's description.
	 * @param text The description to be printed
	 */
	private void beginTest(String text) {
		description = text;
		// the description hasn't been printed yet
		isPrinted = false;
	}

	/**
	 * Tests if the resulting value of a tested expression equals the 
	 * expected (correct) value. This implementation prints both values, 
	 * with an indication of what was tested, to the standard output. The 
	 * implementation does not actually do the comparison.
	 */
	private void assertEquals(String text, Object expected, Object result) {
		boolean equal;
		// tests equality between expected and result
		// accounting for null
		if (expected == null) {
			equal = result == null;
		} else {
			equal = result != null && expected.equals(result);
		}
		if (!equal) {
			// prints the description if necessary
			if (!isPrinted) {
				System.out.println("    Test: " + description);
				// now the description is printed
				isPrinted = true;
			}
			System.out.println("        " + text);
			System.out.println("            Expected:  " + expected);
			System.out.println("            Result: " + result);
			errors++;
		}
	}

	public static void main(String[] args) {
		new PasswordTest().runTest();
	}
}
