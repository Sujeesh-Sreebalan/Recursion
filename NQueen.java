package recursion;

import java.util.Arrays;
import java.util.Scanner;

public class NQueen {
	private static int size;

	private static boolean isSafe(int[][] board, int row, int col) {

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

	private static boolean nQueen(int board[][], int col) {
		// base case: if all queen are placed then return true
		if (col >= size) {
			return true;
		}

		// consider placing queen in all rows one by one
		for (int row = 0; row < size; row++) {

			// checking for queen can be placed in board[row][col]
			if (isSafe(board, row, col)) {

				// if above condition is true then placing the queen in board[row][col]
				board[row][col] = 1;

				// now recurive rest of the col
				if (nQueen(board, col + 1))
					return true;
				
				// backtracking if condition is false
				board[row][col] = 0;
			}
		}
		return false;
	}

	private static void printSolution(int board[][]) {
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
		size = sc.nextInt();
		int board[][] = new int[size][size];
		for (int[] i : board) {
			Arrays.fill(i, 0);
		}

		int col = 0;
		boolean result = nQueen(board, col);
		if (result) {
			System.out.println("NQueen problem solved for size: " + size);
			printSolution(board);

		} else {
			System.out.println("Not Possible for " + size + " Problem");
		}

		sc.close();

	}

}
