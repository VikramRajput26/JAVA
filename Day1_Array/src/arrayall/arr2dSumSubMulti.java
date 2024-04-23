package arrayall;

public class arr2dSumSubMulti {

	public static int findmax(int [][]arr1,int [][]arr2,int row, int col){
		int max1 = arr1[0][0];
		int max2 =arr2[0][0];
		int max3=arr1[0][0];
		for(int r=0;r<arr1.length;r++) {
			for(int c=0;c<arr1.length;c++) {
				if (arr1[r][c] > max1) {
					max1 = arr1[r][c];
				}

			}
		}
		for(int r=0;r<arr2.length;r++) {
			for(int c=0;c<arr2.length;c++) {
				if (arr2[r][c] > max2) {
					max2 = arr2[r][c];
				}

			}
		}
		if(max1>max2) {
			max3=max1;
		}else {
			max3=max2;
		}
		return max3;
	}


}
