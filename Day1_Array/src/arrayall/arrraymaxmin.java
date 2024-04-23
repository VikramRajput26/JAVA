package arrayall;

import java.util.Scanner;

public class arrraymaxmin {

	public static void main(String[] args) {
		int []arr ;
		int max;
		int min;

		arr=new int[5];
		Scanner in =new Scanner(System.in);
		for(int i=0;i<arr.length;i++) {
			System.out.println("enter elements : ");
			arr[i]=in.nextInt();

		}
		max=arr[0];
		for(int i=0;i<arr.length;i++) {
		
			
			if(arr[i]>max){
				max=arr[i];
			}
		}
		min=arr[0];
		for(int i=0;i<arr.length;i++) {
			
			if(arr[i]<min){
				min=arr[i];
			}
		}
		
		System.out.println("max element : "+max);
		System.out.println("min element : "+min);


	}
}	
