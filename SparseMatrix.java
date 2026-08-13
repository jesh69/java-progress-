//sparse matrix 

import java.util.Scanner;

public class SparseMatrix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] A = new int[rows][cols];

        int nonZero = 0;
        int zero = 0;

        System.out.println("Enter matrix elements:");

        // Input matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                A[i][j] = sc.nextInt();

                if (A[i][j] == 0) {
                    zero++;
                } else {
                    nonZero++;
                }
            }
        }

        // Display original matrix
        System.out.println("\nOriginal Matrix:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }

        // Display counts
        System.out.println("\nNumber of elements = " + (rows * cols));
        System.out.println("Number of non-zero elements = " + nonZero);
        System.out.println("Number of zero elements = " + zero);

        // Check sparse matrix
        if (zero > nonZero) {

            System.out.println("\nThe matrix is a Sparse Matrix.");

            // Triplet representation
            int[][] B = new int[nonZero + 1][3];

            // First row contains rows, columns and non-zero count
            B[0][0] = rows;
            B[0][1] = cols;
            B[0][2] = nonZero;

            int k = 1;

            // Store non-zero elements
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {

                    if (A[i][j] != 0) {

                        B[k][0] = i;
                        B[k][1] = j;
                        B[k][2] = A[i][j];

                        k++;
                    }
                }
            }

            // Display triplet representation
            System.out.println("\nTriplet Representation:");

            System.out.println("Row\tColumn\tValue");

            for (int i = 0; i <= nonZero; i++) {
                System.out.println(
                    B[i][0] + "\t" +
                    B[i][1] + "\t" +
                    B[i][2]
                );
            }

        } else {

            System.out.println("\nThe matrix is NOT a Sparse Matrix.");
        }

        sc.close();
    }
}