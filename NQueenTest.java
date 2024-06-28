package recursion;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class NQueenTest {

	@Test
	public void nQueen() {
		int size = 4;
		int board[][] = new int[size][size]; 
		for(int[] i: board) {
			Arrays.fill(i, 0);
		}
		int col = 0;
		assertEquals(true, NQueen.nQueen(board, col, size));
	}
	
	@Test
	public void nQueen1() {
		int size = 3;
		int board[][] = new int[size][size]; 
		for(int[] i: board) {
			Arrays.fill(i, 0);
		}
		int col = 0;
		assertEquals(false, NQueen.nQueen(board, col, size));
	}
	
	@Test
	public void nQueen2() {
		int size = -1;
		int board[][] = new int[0][0]; 
		for(int[] i: board) {
			Arrays.fill(i, 0);
		}
		int col = 0;
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> NQueen.nQueen(board, col, size));
		assertEquals("Enter Valid Input", exception.getMessage());
	}
	
	
}
