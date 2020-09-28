package laiOffer.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void sort(int[] A){
        if(A == null || A.length == 0) return;
        int n = A.length;
        for(int i = 0; i < n -1; i++){
            int global = i;
            for(int j = i + 1; j < n ; j ++){
                if(A[j] < A[global]){
                    global = j;
                }
            }
            int temp = A[i];
            A[i] = A[global];
            A[global] = temp;
        }
    }

    public static void main(String[] args) {
        int[] A = {-2, -8, -6, 100, 20};
        sort(A);
        System.out.println(Arrays.toString(A));
    }
}
