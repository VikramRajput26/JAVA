package javaPractice;
import java.util.Scanner;

public class Arraydemo{
    
    // Method to add two matrices
    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }
    
    // Method to subtract two matrices
    public static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }
    
    // Method to multiply two matrices
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;
        int[][] result = new int[rows1][cols2];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }
    
    // Method to transpose a matrix
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
    
    // Method to perform scalar multiplication of a matrix
    public static int[][] scalarMultiply(int scalar, int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = scalar * matrix[i][j];
            }
        }
        return result;
    }
    
    // Method to check if a matrix is symmetric
    public static boolean isSymmetric(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows != cols) {
            return false;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < i; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    // Method to print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Taking input for matrix 1
        System.out.println("Enter the number of rows for matrix 1:");
        int rows1 = scanner.nextInt();
        System.out.println("Enter the number of columns for matrix 1:");
        int cols1 = scanner.nextInt();
        int[][] matrix1 = new int[rows1][cols1];
        System.out.println("Enter the elements of matrix 1:");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }
        
        // Taking input for matrix 2
        System.out.println("Enter the number of rows for matrix 2:");
        int rows2 = scanner.nextInt();
        System.out.println("Enter the number of columns for matrix 2:");
        int cols2 = scanner.nextInt();
        int[][] matrix2 = new int[rows2][cols2];
        System.out.println("Enter the elements of matrix 2:");
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }
        
        // Performing operations
        
        // Addition
        System.out.println("\nAddition of matrices:");
        int[][] additionResult = addMatrices(matrix1, matrix2);
        printMatrix(additionResult);
        
        // Subtraction
        System.out.println("\nSubtraction of matrices:");
        int[][] subtractionResult = subtractMatrices(matrix1, matrix2);
        printMatrix(subtractionResult);
        
        // Multiplication
        if (cols1 == rows2) {
            System.out.println("\nMultiplication of matrices:");
            int[][] multiplicationResult = multiplyMatrices(matrix1, matrix2);
            printMatrix(multiplicationResult);
        } else {
            System.out.println("\nCannot multiply matrices. Number of columns of first matrix must be equal to the number of rows of the second matrix.");
        }
        
        // Transpose
        System.out.println("\nTranspose of matrix 1:");
        int[][] transposeResult = transposeMatrix(matrix1);
        printMatrix(transposeResult);
        
        // Scalar multiplication
        System.out.println("\nEnter a scalar value for scalar multiplication:");
        int scalar = scanner.nextInt();
        System.out.println("Scalar multiplication of matrix 1:");
        int[][] scalarMultiplicationResult = scalarMultiply(scalar, matrix1);
        printMatrix(scalarMultiplicationResult);
        
        // Symmetry check
        System.out.println("\nMatrix 1 is symmetric: " + isSymmetric(matrix1));
        System.out.println("Matrix 2 is symmetric: " + isSymmetric(matrix2));
        
        scanner.close();
    }
}

