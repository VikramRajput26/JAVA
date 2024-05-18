package javaPractice;

public class KthElementInFinalSortedArray {

	static int kth(int arr1[],int arr2[], int n, int m,int k){
		int[] sorted1 = new int[m+n];
		int i=0,j=0,d=0;
		while(i<n && j<m){
			if(arr1[i]<arr2[j])
				sorted1[d++]=arr1[i++];
			else
				sorted1[d++]=arr2[j++];
			
		}
		while(i<n)
			sorted1[d++]=arr1[i++];
		while(j<m)
			sorted1[d++]=arr2[j++];
		
		return sorted1[k-1];
	}
	
	public static void main(String[] args) {
		int arr1[]= {2, 3, 6, 7, 9};
		int arr2[]= {1, 4, 8, 10};
		int k=5;
		System.out.print(kth(arr1,arr2,5,4,k));
	}

}
