package labs.solutions.metadata.lab2;

public class TestCase {
	
	private MyService classToTest = new MyService();
	
	@TestMethod
	public boolean testFooOdd() {
		int i = classToTest.foo(5);
		return i > 0;
	}
	
	@TestMethod
	public boolean testFooEven() {
		int i = classToTest.foo(4);
		return i < 0;
	}
	
	@TestMethod
	public boolean testBlah(String s) { return false;}
	
	public void notATestMethod() {
		
	}
}
