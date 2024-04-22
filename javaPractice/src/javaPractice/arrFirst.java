package javaPractice;
import java.util.Arrays;

public class arrFirst {
    
    // Method to find the maximum element in an array
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    // Method to calculate the sum of all elements in an array
    public static int calculateSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
    
    // Method to calculate the average of all elements in an array
    public static double calculateAverage(int[] arr) {
        return (double) calculateSum(arr) / arr.length;
    }
    
    // Method to sort the elements of an array in ascending order using bubble sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // Create an array of integers and initialize it with some values
        int[] array = {5, 2, 9, 1, 3, 6, 8, 4, 7};
        
        // Call the methods implemented to perform respective operations
        int maxElement = findMax(array);
        int sum = calculateSum(array);
        double average = calculateAverage(array);
        
        // Display the results of each operation
        System.out.println("Original array: " + Arrays.toString(array));
        System.out.println("Maximum element: " + maxElement);
        System.out.println("Sum of all elements: " + sum);
        System.out.println("Average of all elements: " + average);
        
        // Sort the array in ascending order using bubble sort
        bubbleSort(array);
        System.out.println("Array after sorting: " + Arrays.toString(array));
    }
}

