package javaPractice;
import java.util.*;
public class BoundryElements {
	
	public void Boundry_Elements(int mat[][]){
		System.out.println("input matrix is : ");
	for(int i=0;i<mat.length;i++){
		for(int j=0;j<mat[i].length;j++){
			System.out.println(mat[i][j]);
		}
		System.out.println();
	}
	System.out.println("resultant matrix is ");
	for(int i=0;i<mat.length;i++){
		for(int j=0;j<mat[i].length;j++) {
			if(i==0 || j==0 || i==mat.length-1 || j==mat[i].length-1){
				System.out.println(mat[i][j]);
			}
			else {
				System.out.println(" ");
			}
		}
	  System.out.println();
	}

	
	}

	public static void main(String[] args) {
	int mat[][]= new int[][] {
		{10,20,30},
		{40,50,60},
		{70,80,90}
	};
	BoundryElements bvalues=new BoundryElements();
	

	}

}
