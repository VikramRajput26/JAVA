package arrayall;

import java.util.Scanner;

public class arrClient {

	public static void main(String[] args) {
		int arr1[][];
		int arr2[][];
		arr1=new int [3][3];
		Scanner in =new Scanner(System.in);
		for(int r=0;r<arr1.length;r++) {
			for(int c=0;c<arr1.length;c++) {
				System.out.println("enter elements : ");
			    arr1[r][c]=in.nextInt();
			  	
			}
		}
		
		arr2=new int [3][3];
		Scanner ab =new Scanner(System.in);
		for(int r=0;r<arr2.length;r++) {
			for(int c=0;c<arr2.length;c++) {
				System.out.println("enter elements : ");
			    arr2[r][c]=ab.nextInt();
			  	
			}
		}
		
		for(int r=0;r<arr1.length;r++) {
			System.out.println("");
			for(int c=0;c<arr1.length;c++) {
				System.out.print(arr1[r][c]+" ");
			    
					
			}
		}
		System.out.println("");
		
		for(int r=0;r<arr2.length;r++) {
			System.out.println("");
			for(int c=0;c<arr2.length;c++) {
				System.out.print(arr2[r][c]+" ");
			    
					
			}
		}

		System.out.println("");
		int max=arr2dSumSubMulti.findmax(arr1, arr2, 3, 3);
		System.out.println(" max element in array is : "+max); 

	}

}
