package recursion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MathematicalProblemTest {

	@ParameterizedTest
	@CsvSource({ 
		"10, 20, 10", 
		"67, 173, 1", 
		"0, 0, 0", })
	void hcfTest(int number1, int number2, int expectedHCF)  {
		assertEquals(expectedHCF, MathematicalProblem.hcf(number1, number2));
	}

	@Test
	public void hcfTest1(){
		int num1 = -1;
		int num2 = 1;
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> MathematicalProblem.hcf(num1, num2));
		assertEquals("Element ashould be greater than 0", exception.getMessage());
	}

	@ParameterizedTest
	@CsvSource({ 
		"10, 20, 20", 
		"67, 51, 3417", 
		"0, 0, 0" })
	void lcmTest(int number1, int number2, int expectedHCF){
		assertEquals(expectedHCF, MathematicalProblem.lcm(number1, number2));
	}

	@Test
	public void lcmTest1(){
		int num1 = -1;
		int num2 = 1;
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> MathematicalProblem.lcm(num1, num2));
		assertEquals("Element ashould be greater than 0", exception.getMessage());
	}

}
