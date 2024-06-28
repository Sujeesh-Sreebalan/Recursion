package recursion;

import java.util.Arrays;
import java.util.Scanner;

public class NQueen {
	/**
	 * function to check whether the queen is present on the diagonaally of to its left position.
	 * 
	 * @param board 2D Array
	 * @param row Row from which we have to check to it's left side
	 * @param col Column from which we have check to it's left side
	 * @param size Size of the input array
	 * @return true is queen is not present in diagonals, left positions
	 */
	public static boolean isSafe(int[][] board, int row, int col, int size) {

		// check this row on left side
		for (int i = 0; i < col; i++) {
			if (board[row][i] == 1) {
				return false;
			}
		}

		// check for the upper diagonal
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}

		// check for the lower diagonal
		for (int i = row, j = col; j >= 0 && i < size; i++, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * function to find the positions of the queen to be placed in the chessboard so that no two queens attack each other
	 * 
	 * @param board 2D array
	 * @param col checking queens in columns vice
	 * @param size Size of the input array
	 * @return if all the positions of the queens are found then true else false
	 * @throws AssertionError if size is less than zero
	 */

	public static boolean nQueen(int board[][], int col, int size) {
		
		if(size < 0) {
			throw new AssertionError("Enter Valid Input");
		}
		
		// base case: if all queen are placed then return true
		if (col >= size) {
			return true;
		}

		// consider placing queen in all rows one by one
		for (int row = 0; row < size; row++) {

			// checking for queen can be placed in board[row][col]
			if (isSafe(board, row, col, size)) {

				// if above condition is true then placing the queen in board[row][col]
				board[row][col] = 1;

				// now recurive rest of the col
				if (nQueen(board, col + 1, size))
					return true;

				// backtracking if condition is false
				board[row][col] = 0;
			}
		}
		return false;
	}
	
	
	// Printing the final output
	public static void printSolution(int board[][], int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (board[i][j] == 1)
					System.out.print("1 ");
				else
					System.out.print("0 ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Size of Board: ");
		try {
			int size = sc.nextInt();
			

			int board[][] = new int[size][size];
			for (int[] i : board) {
				Arrays.fill(i, 0);
			}

			int col = 0;
			boolean result = nQueen(board, col, size);
			if (result) {
				System.out.println("NQueen problem solved for size: " + size);
				printSolution(board, size);

			} else {
				System.out.println("Not Possible for " + size + " Problem");
			}
		} catch (Exception e) {
			System.out.print("Enter Value Greater than zero");
		} 

	}
	
}
