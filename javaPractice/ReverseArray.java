package javaPractice;
import java.io.*;
public class ReverseArray {
public static void reverseArray(int arr[]){
	int arr1[]= new int[arr.length];
	for(int i=0;i<arr.length;i++){
		arr1[i]=arr[arr.length-i-1];
	}
	System.out.println("Reversed array : ");
	for(int i: arr1){
		System.out.println(i+" ");
	}
}
	public static void main(String[] args) {
		 int[] originalArr = { 10,20,40,70,80,90 };
	        reverseArray(originalArr);

	}

}
