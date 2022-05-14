
public class Application {

	public static void main(String[] args) {
		TestDemo testDemo = new TestDemo();
		int a = 2;
		int b = 4;
		
		System.out.println("Random Number (1-10) Squared: " + testDemo.randomNumberSquared());
		System.out.println("Random Number (1-10) Squared: " + testDemo.randomNumberSquared());
		System.out.println("Random Number (1-10) Squared: " + testDemo.randomNumberSquared());
		System.out.println("Random Number (1-10) Squared: " + testDemo.randomNumberSquared());
		System.out.println("Random Number (1-10) Squared: " + testDemo.randomNumberSquared());
		System.out.println("*********************");
		
		System.out.println("Add Positive:");		
		System.out.println(a + " + " + b + " = " + testDemo.addPositive(a,b));	
		
		//verify invalid inputs produce error
		a = 0;
		b = 4;
		System.out.println(a + " + " + b + " = " + testDemo.addPositive(a,b));
				
	}

}
