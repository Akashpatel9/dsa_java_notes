
package sorting;

import java.util.Arrays;

public class BubbeLe_Short {
    public BubbeLe_Short() {
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 1, 2, 6, 3, 3, 1};

        for(int j = 0; j < arr.length - 1; ++j) {
            for(int i = 0; i < arr.length - 1 - j; ++i) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
