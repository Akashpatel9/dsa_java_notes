package DSA_notes.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Dutch_national_flag_algo {
    public static void main(String[] args) {

        //short 0s,  1s,  2s;

        int arr[] = {2, 1, 0, 2, 1, 1, 2, 0, 2};

        int s = 0, mid = 0, e = arr.length - 1;

        while (mid <= e) {
            if (arr[mid] == 2) {
                int tem = arr[mid];
                arr[mid] = arr[e];
                arr[e] = tem;
                e--;
            } else if (arr[mid] == 0) {
                int tem = arr[mid];
                arr[mid] = arr[s];
                arr[s] = tem;
                s++;
                mid++;
            } else {
                mid++;
            }
        }
        System.out.println(Arrays.toString(arr));


    }
}
