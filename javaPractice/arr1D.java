
package javaPractice;
import java.util.Scanner;
public class arr1D {
	public static void main(String[] args) {
		int []arr ;
		arr=new int[5];
		Scanner in =new Scanner(System.in);
		for(int i=0;i<arr.length;i++) {
			System.out.println("enter elements : ");
		    arr[i]=in.nextInt();
				
		}
		for(int i=0;i<arr.length;i++) {
			System.out.println("enter elements  are : "+ arr[i]);
		   
				
		}
		
	}


}
