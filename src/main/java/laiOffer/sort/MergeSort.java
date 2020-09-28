package laiOffer.sort;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] A){
        if(A == null || A.length < 2) return;
        int n = A.length;
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];
        for(int i = 0; i < mid; i++){
            l[i] = A[i];
        }
        for(int j = mid; j < n; j++){
            r[j - mid] = A[j];
        }
        mergeSort(l);
        mergeSort(r);
        merge(A, l, r);
    }

    private static void merge(int[] A, int[] l, int[] r){
        int i = 0, m = 0, n = 0;
        while(m < l.length && n < r.length){
            if(l[m] < r[n]){
                A[i++] = l[m++];
            }else{
                A[i++] = r[n++];
            }
        }
        while(m < l.length){
            A[i++] = l[m++];
        }
        while (n < r.length){
            A[i++] = r[n++];
        }
    }
    public static void main(String[] args) {
        int[] A = {-2, -8, -6, -100, 20, 70, 65};
        mergeSort(A);
        System.out.println(Arrays.toString(A));
    }
}
