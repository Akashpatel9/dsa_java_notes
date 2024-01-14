package DSA_notes.shorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class quickSort {
    public quickSort() {
    }

    public static void quickS(int[] arr, int s, int e) {
        if (s < e) {
            int piIdx = par(arr, s, e);
            quickS(arr, s, piIdx - 1);
            quickS(arr, piIdx + 1, e);
        }
    }

    public static int par(int[] arr, int s, int e) {


        int piv = arr[e];
        int i = s - 1;

        int j;
        for(j = s; j < e; j++) {
            if (arr[j] < piv) {
                i++;
                int tem = arr[i];
                arr[i] = arr[j];
                arr[j] = tem;
            }
        }

        i++;
        j = arr[i];
        arr[i] = piv;
        arr[e] = j;
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,6,3,9,2,7,5,4};
        quickS(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
