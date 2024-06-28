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
	 */
	public static int linearSearch(int arr[], int key, int size) {
		if(size == 0) {
			return -1;
		}else if(arr[size-1] == key) {
			return size-1;
		}
		return linearSearch(arr, key, size-1);
	}
	
	/**
	 * Function to find the key present in the input array.
	 * 
	 * @param arr: Input array
	 * @param key: Input number to be searched in array
	 * @param start: start index of the array
	 * @param end: end index of the array
	 * @return: Index value of the key is returned if not found -1 is returned
	 */
	public static int binarySearch(int arr[], int key, int start, int end) {
		if(end >= start) {
			int mid = (start+end)/2;
			
			if(arr[mid] == key) {
				return mid;
			}
			
			if(arr[mid] > key) {
				return binarySearch(arr, key, start, mid-1);
			}
			return binarySearch(arr, key, mid+1, end);
		}
		return -1;
	}

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			int size = 0;
			int key = 0;
			System.out.println("1.Linear Search\n2.Binary Search");
			System.out.print("Enter Your Choice: ");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.print("\nEnter the size: ");
				size = sc.nextInt();
				if(size == 0) {
					extracted();
				}
				
				int linear[] = new int[size];
				for(int i=0; i<size; i++) {
					System.out.print("Enter the element: ");
					linear[i] = sc.nextInt();
				}
				System.out.print("\nEnter the key to be searched: ");
				key = sc.nextInt();
				System.out.println("Element found at index: "+linearSearch(linear, key, linear.length));
				break;
				
			case 2:
				System.out.print("\nEnter the size: ");
				size = sc.nextInt();
				if(size == 0) {
					extracted();
				}
				
				int binary[] = new int[size];
				for(int i=0; i<size; i++) {
					System.out.print("Enter the element: ");
					binary[i] = sc.nextInt();
				}
				System.out.print("\nEnter the key to be searched: ");
				key = sc.nextInt();
				System.out.println("Element found at index: "+binarySearch(binary, key, 0, binary.length-1));
				break;
				
			default:
				System.out.print("Enter the Correct Choice");
				sc.close();
			}
			
		}catch(InputMismatchException e) {
			System.err.print("Enter Valid Input");
		}catch(AssertionError e) {
			System.out.print("Enter the size greater than zero");
		}
		
		
	}

	private static void extracted() throws AssertionError {
		throw new AssertionError();
	}

}
