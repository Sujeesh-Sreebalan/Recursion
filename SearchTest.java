package recursion;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SearchTest {

	@Test
	public void linearSearchTest() {
		int arr[] = {1,3,5,6,7,4,8};
		int size = arr.length;
		int key = 7;
		assertEquals(4, Search.linearSearch(arr, key, size));
	}
	
	@Test
	public void linearSearchTest1() {
		int arr[] = {1,3,5,6,7,4,8};
		int size = arr.length;
		int key = 8;
		assertEquals(size-1, Search.linearSearch(arr, key, size));
	}
	
	@Test
	public void linearSearchTest2() {
		int arr[] = {1,3,5,6,7,4,8};
		int size = arr.length;
		int key = 10;
		assertEquals(-1, Search.linearSearch(arr, key, size));
	}
	
	@Test
	public void linearSearchTest3(){
		int arr[] = new int[0];
		int size = -1;
		int key = 10;
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Search.linearSearch(arr, key, size));
		assertEquals("Enter size the greater than zero", exception.getMessage());
	}
	
	@Test
	public void binarySearchTest() {
		int arr[] = {1,2,3,4,5,6,7,8};
		int size = arr.length;
		int n = arr.length;
		int key = 7;
		assertEquals(6, Search.binarySearch(arr, key, 0, size, n));
	}
	
	@Test
	public void binarySearchTes1() {
		int arr[] = {1,2,3,4,5,6,7,8};
		int size = arr.length;
		int n = arr.length;
		int key = 8;
		assertEquals(size-1, Search.binarySearch(arr, key, 0, size, n));
	}
	
	
	@Test
	public void binarySearchTes3(){
		int arr[] = new int[0];
		int size = -1;
		int n = -1;
		int key = 10;
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Search.binarySearch(arr, key, 0, size, n));
		assertEquals("Enter size the greater than zero", exception.getMessage());
	}




}
