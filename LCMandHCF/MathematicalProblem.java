package recursion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MathematicalProblem {

	/**
	 * Function to calculate the highest common factor of two numbers
	 * 
	 * @param num1 First input number
	 * @param num2 Second input number
	 * @return hcf of both numbers
	 */
	public static int hcf(int num1, int num2) {
		if (num1 < 0 || num2 < 0) {
			throw new AssertionError("Enter Valid Input");
		}
		if (num1 == 0) {
			return num2;
		}
		if (num2 == 0) {
			return num1;
		}

		if (num1 == num2) {
			return num1;
		}

		if (num1 > num2) {
			return hcf(num1 - num2, num2);
		}
		return hcf(num1, num2 - num1);
	}

	/**
	 * function to calculate the lowest common factor of both numbers
	 * 
	 * @param num1 First input number
	 * @param num2 Second input number
	 * @return return the lcm of both number
	 * @throws ArithmeticException if hcf is zero, to handle division by zero error
	 */
	public static int lcm(int num1, int num2) {
		if (num1 < 0 || num2 < 0) {
			throw new AssertionError("Enter Valid Input");
		}
		if (num1 == 0 || num2 == 0) {
			return 0;
		}
		return (num1 * num2) / hcf(num1, num2);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Enter the First Number: ");
			int x = sc.nextInt();

			System.out.print("Enter Second Number: ");
			int y = sc.nextInt();

			System.out.println("HCF of " + x + " and " + y + " is: " + hcf(x, y));
			System.out.println("LCM of " + x + " and " + y + " is: " + lcm(x, y));
		} catch (AssertionError e) {
			System.err.print("Enter Valid Input");
		} catch (InputMismatchException e) {
			System.err.print("Enter Valid Input");
		}

		sc.close();
	}

}
