//merge sort

import java.util.Scanner;

public class MergeSort {

    static void mergeSort(int A[], int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;

            mergeSort(A, low, mid);
            mergeSort(A, mid + 1, high);

            merge(A, low, mid, high);
        }
    }

    static void merge(int A[], int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = low;

        int B[] = new int[high + 1];

        while (i <= mid && j <= high) {
            if (A[i] <= A[j]) {
                B[k] = A[i];
                i++;
            } else {
                B[k] = A[j];
                j++;
            }

            k++;
        }

        while (i <= mid) {
            B[k] = A[i];
            i++;
            k++;
        }

        while (j <= high) {
            B[k] = A[j];
            j++;
            k++;
        }

        for (k = low; k <= high; k++) {
            A[k] = B[k];
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();

        int A[] = new int[n];

        System.out.println("Enter " + n + " elements:");

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        System.out.print("\nBefore Sorting: ");

        for (int i = 0; i < n; i++) {
            System.out.print(A[i] + " ");
        }

        mergeSort(A, 0, n - 1);

        System.out.print("\nAfter Sorting: ");

        for (int i = 0; i < n; i++) {
            System.out.print(A[i] + " ");
        }

        sc.close();
    }
}