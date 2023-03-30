package DSA_notes.shorting;

import java.util.Arrays;

public class mergeSort {
    public mergeSort() {
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, mid, l, r);
        }
    }

    public static void merge(int[] arr, int mid, int l, int r) {
        int[] tem = new int[r - l + 1];
        int i = l;
        int j = mid + 1;
        int in = 0;

        while(i <= mid && j <= r) {
            if (arr[i] > arr[j]) {
                tem[in++] = arr[j++];
            } else {
                tem[in++] = arr[i++];
            }
        }

        while(i <= mid) {
            tem[in++] = arr[i++];
        }

        while(j <= r) {
            tem[in++] = arr[j++];
        }


        for(int ii = l,k=0; k < tem.length; ++ii) {
            arr[ii] = tem[k];
            ++k;
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 3, 5, 9, 4};
        mergeSort(arr, 0, arr.length - 1);
        System.out.printf(Arrays.toString(arr));
    }
}
