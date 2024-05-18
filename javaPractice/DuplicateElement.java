package javaPractice;

public class DuplicateElement {

	public static void main(String[] args) {
		int arr[]= {1,2,1,3,5,7,8,7};
		System.out.println("duplicate elements in array is : ");
		
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]==arr[j]){
					System.out.println(arr[j]);
				}
			}
		}
	}

}
