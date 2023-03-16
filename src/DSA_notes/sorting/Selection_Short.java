package DSA_notes.sorting;

import java.util.Arrays;

public class Selection_Short {
    public Selection_Short() {
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 7, 1, 9, 4};

        for(int i = 0; i < arr.length - 1; ++i) {
            int curr = i;

            int j;
            for(j = i + 1; j < arr.length; ++j) {
                if (arr[curr] > arr[j]) {
                    curr = j;
                }
            }

            j = arr[curr];
            arr[curr] = arr[i];
            arr[i] = j;
        }

        System.out.println(Arrays.toString(arr));
    }
}
