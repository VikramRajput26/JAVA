package javaPractice;

import java.util.Scanner;

public class arr2d {

	public static void main(String[] args) {
		int [][]arr;
		arr=new int [3][3];
		Scanner in =new Scanner(System.in);
		for(int r=0;r<arr.length;r++) {
			for(int c=0;c<arr.length;c++) {
				System.out.println("enter elements : ");
			    arr[r][c]=in.nextInt();
			  	
			}
		}
	
		for(int r=0;r<arr.length;r++) {
			System.out.println("");
			for(int c=0;c<arr.length;c++) {
				System.out.print(arr[r][c]);
			    
					
			}
		}

	}

}
