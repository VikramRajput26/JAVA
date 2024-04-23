package arrayall;

import java.util.Scanner;

public class arrSecondlast {
	public static int getsecondLargest(int []a,int total){
		int temp;
		for(int i=0;i<total;i++){
			{
				for(int j=i+1;j<total;j++)
				{
					if(a[i]>a[j]){
						temp=a[i];
						a[i]=a[j];
						a[j]=temp;
					}
				}

			}
		}
		return a[total-2];
	}
	
	public static int getsecondSmallest(int []a,int total){
		int temp;
		for(int i=0;i<total;i++){
			{
				for(int j=i+1;j<total;j++)
				{
					if(a[i]>a[j]){
						temp=a[i];
						a[i]=a[j];
						a[j]=temp;
					}
				}

			}
		}
		return a[1];
	}

	public static void main(String[] args) {
		int []arr ;
		int total;
		
		arr=new int[5];
		Scanner in =new Scanner(System.in);
		for(int i=0;i<arr.length;i++) {
			System.out.println("enter elements : ");
			arr[i]=in.nextInt();
		}
		total=arr.length;
		System.out.println("second largest element : "+getsecondLargest(arr,total));
		System.out.println("second largest element : "+getsecondSmallest(arr,total));
	}
}