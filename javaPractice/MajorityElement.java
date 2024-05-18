package javaPractice;
import java.io.*;
public class MajorityElement {
		static boolean isMajority(int arr[], int n, int x){
			int i,last_index =0;
			last_index=(n%2==0)?n/2:n/2+1;
				for(i=0;i<last_index;i++){
					 if(arr[i]==x && arr[i+n/2]==x){
						return true;
					}
				}
				return false;
		
		}
		
	public static void main(String[] args) {
		int arr[]= {50,40,40,40,40,30,40};
		int n=arr.length;
		int x=40;
		if(isMajority(arr,n,x)==true)
			System.out.println(x+" appers more than "+n/2+" times in arr[] ");
		else
		System.out.println(x+" does not appers more than "+n/2+" times in arr[] ");
		
	
	}

}
