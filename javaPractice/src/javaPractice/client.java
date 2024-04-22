package javaPractice;

import java.util.Scanner;

public class client {

	public static void main(String[] args) {
		int []arr ;
		int sum=0;
		
		arr=new int[5];
		Scanner in =new Scanner(System.in);
		for(int i=0;i<arr.length;i++) {
			System.out.println("enter elements : ");
		    arr[i]=in.nextInt();
				
		}
		for(int i=0;i<arr.length;i++) {
			sum=sum+arr[i];
		
		   
				
		}
		System.out.println("sum of array elements  are : "+ sum);
		

	}

}
