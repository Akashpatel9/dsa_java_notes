package sorting;

import java.util.Arrays;

public class Insertion_Short {
    public Insertion_Short() {
    }

    public static void main(String[] args) {
        int[] arr = new int[]{24, 18, 38, 43, 14, 40, 1, 54};

        for(int i = 1; i < arr.length; ++i) {
            int curr = arr[i];

            int rev;
            for(rev = i - 1; rev >= 0 && arr[rev] > curr; --rev) {
                arr[rev + 1] = arr[rev];
            }

            arr[rev + 1] = curr;
        }

        System.out.println(Arrays.toString(arr));
    }
}
