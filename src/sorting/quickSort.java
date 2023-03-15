package sorting;

import java.util.Arrays;

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
        for(j = s; j < e; ++j) {
            if (arr[j] < piv) {
                ++i;
                int tem = arr[i];
                arr[i] = arr[j];
                arr[j] = tem;
            }
        }

        ++i;
        j = arr[i];
        arr[i] = piv;
        arr[e] = j;
        return i;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{24, 18, 38, 43, 14, 40, 55, 54};
        quickS(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
