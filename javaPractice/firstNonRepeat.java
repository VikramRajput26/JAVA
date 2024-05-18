package javaPractice;

public class firstNonRepeat {


	public static int firstNonRepeating(int arr[],int n) {
		  int fre[] = new int[10];
		  
           for (int i = 0; i < n; i++) {
              fre[arr[i]]++ ;
            }
           for (int i = 0; i < n; i++) {
        	if(fre[arr[i]]==1){
        		return arr[i];
        	}
        }
       return -1; 
    }
	
	public static void main(String[] args) {
		 int arr[] = { 9, 4, 9, 6, 7, 4 };
	        int n = arr.length;
	 
	        System.out.print(firstNonRepeating(arr, n));

	}

}
