import java.util.Scanner;

public class Calculator {
	public static final int ERROR_CODE = 9999;

	public static void main(String[] args) {
		// Scanner scanner = new Scanner(System.in);
		// System.out.println("Please enter operand 1: ");
		//int a = scanner.nextInt();
		//System.out.println("Please enter operand 2: ");
		//int b = scanner.nextInt();
		//scanner.nextLine();
		//System.out.println("Please enter operator: ");
		//String operator = scanner.nextLine();

		int a = Integer.parseInt(args[1]);
		int b = Integer.parseInt(args[2]);
		String operator = args[0];

		float result = getResult(a, b, operator);
	 	args[3] = result+"";
	}

	private static float getResult(int a, int b, String operator) {
		float result = 0;

		switch (operator) {
			case "+":
				result = a + b;
				break;
			case "-":
				result = a - b;
				break;
			case "*":
				result = a * b;
				break;
			case "/":
				result = (float) a / b;
				break;
			default:
				result = ERROR_CODE;
		}

		System.out.println("[Calculator.main] result is: "+result);
		return result;
	}
}

