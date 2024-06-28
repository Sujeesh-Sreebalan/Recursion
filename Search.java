package recursion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Search {
	
	/**
	 * Function to find the key present in the input array.
	 * 
	 * @param arr: Input array
	 * @param key: Input number to be searched in array
	 * @param size: Size of the input array
	 * @return: Index value of the key is returned if not found -1 is returned
	 * @throws IllegalArgumentException if size is less than zero
	 */
	public static int linearSearch(int arr[], int key, int size) {
		if(size < 0) {
			throw new IllegalArgumentException("Enter size the greater than zero");
		}
		
		if(size == 0) {
			return -1;
		}else if(arr[size-1] == key) {
			return size-1;
		}
		return linearSearch(arr, key, size-1);
	}
	
	/**
	 * Function to initialize the array and call the linear search function
	 * 
	 * @return Index of the element
	 */
	public static int linearSearchMethod() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter the size: ");
		int size = sc.nextInt();
		
		int linearArray[] = new int[size];
		for(int i=0; i<size; i++) {
			System.out.print("Enter the element: ");
			linearArray[i] = sc.nextInt();
		}
		
		System.out.print("\nEnter the key to be searched: ");
		int key = sc.nextInt();
		int result = linearSearch(linearArray, key, linearArray.length);
		sc.close();
		return result;
	}
	
	/**
	 * Function to find the key present in the input array.
	 * 
	 * @param arr: Input array
	 * @param key: Input number to be searched in array
	 * @param start: start index of the array
	 * @param end: end index of the array
	 * @return: Index value of the key is returned if not found -1 is returned
	 * @throws IllegalArgumentException if size is less than zero
	 */
	public static int binarySearch(int arr[], int key, int start, int end, int size) {
		if(size < 0) {
			throw new IllegalArgumentException("Enter size the greater than zero");
		}
		
		if(end >= start) {
			int mid = (start+end)/2;
			
			if(arr[mid] == key) {
				return mid;
			}
			
			if(arr[mid] > key) {
				return binarySearch(arr, key, start, mid-1, size);
			}
			return binarySearch(arr, key, mid+1, end, size);
		}
		return -1;
	}
	
	/**
	 * Function to initialize the array and call the binary search function
	 * 
	 * @return Index of the element
	 */
	public static int binarySearchMethod() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter the size: ");
		int size = sc.nextInt();
		
		int binaryArray[] = new int[size];
		for(int i=0; i<size; i++) {
			System.out.print("Enter the element: ");
			binaryArray[i] = sc.nextInt();
		}
		System.out.print("\nEnter the key to be searched: ");
		int key = sc.nextInt();
		int result = binarySearch(binaryArray, key, 0, binaryArray.length-1, size);
		sc.close();
		return result;
	}

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("1.Linear Search\n2.Binary Search");
			System.out.print("Enter Your Choice: ");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Element Found at index: "+linearSearchMethod());
				break;
				
			case 2:
				System.out.println("Element Found at index: "+binarySearchMethod());
				break;
				
			default:
				System.out.print("Enter the Correct Choice");
				
			}
			
		}catch(IllegalArgumentException e) {
			System.err.print("Enter Valid Input");
		}catch(InputMismatchException e) {
			System.out.println("Exception occured: " + e); 
		}finally {
			sc.close();
		}
		
		
	}


}
