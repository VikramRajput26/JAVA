package javaPractice;

public class PairSumCount {

	public static void main(String[] args) {
		int arr[]= {1,5,6,2,7,-1,8,-2};
		int k=6;
		getPairsCount(arr,k);
		
	}
	public static void getPairsCount(int[] arr, int K){
		int count =0;
		for(int i=0;i<arr.length ; i++){
			for(int j=i+1;j<arr.length ; j++){
				if((arr[i]+arr[j])==K){
					count++;
				}
			}
		}
		System.out.printf("Count of pairs is %d", count);
	}
}
