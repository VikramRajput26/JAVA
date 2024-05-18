package javaPractice;
import java.util.*;
public class MaxMinElement {

	public static void main(String[] args) {
		int a[] = {1,422,34,366,20,90};
		Arrays.sort(a);
		System.out.println("min-"+a[0]+" max-"+a[a.length-1]);
	}

}
