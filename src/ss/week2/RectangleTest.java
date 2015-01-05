package ss.week2;

public class RectangleTest {

	private Rectangle rectangle;
	
	public RectangleTest() {
		rectangle = new Rectangle(50, 200);
	}
	
	public void run() {
		testQuery();
	}

	public void testQuery() {
		assertEquals("rectangle.area()", 10000, rectangle.area());
		assertEquals("rectangle.perimeter()", 500, rectangle.perimeter());
	}

	private void assertEquals(String text, Object expected, Object result) {
		System.out.println("        " + text);
		System.out.println("            Expected:  " + expected);
		System.out.println("            Result: " + result);
	}

	public static void main(String[] args) {
		RectangleTest test = new RectangleTest();
		test.run();
	}
}
