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
	 * @throws IllegalArgumentException if number is less than zero then error is thrown
	 */
	public static int hcf(int num1, int num2) throws IllegalArgumentException{
		 if(num1 < 0 || num2 < 0) {
			 throw new IllegalArgumentException("Element ashould be greater than 0");
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
	 * @throws IllegalArgumentException if number is less than zero then error is thrown
	 */
	public static int lcm(int num1, int num2) throws IllegalArgumentException{
		if(num1 < 0 || num2 < 0) {
			 throw new IllegalArgumentException("Element ashould be greater than 0");
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
		} catch (IllegalArgumentException e) {
			System.out.println("Exception occured: " + e);  
		}catch(InputMismatchException e) {
			System.out.println("Exception occured: " + e); 
		}finally {
			sc.close();
		}

	}

}
