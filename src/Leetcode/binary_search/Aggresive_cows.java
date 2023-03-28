package Leetcode.binary_search;

import java.util.Arrays;

public class Aggresive_cows {
    public static void main(String[] args) {

        //Problem Statement

        //you-are-given-an-array-consisting-of-n-integers-which-denote-the-position-of-a-stall-
        // you-are-also-given-an-integer-k-which-denotes-the-number-of-aggressive-cows-you-are-given-the-task-of-assigning-
        // stalls-to-k-cows-such-that-the-minimum-distance-between-any-two-of-them-is-the-maximum-possible

        //ex

        //input
        // 5 2
        // 4 2 1 3 6

        //output
        //5

        //find the maximum distance between k cows;

         int arr[]={4 ,2 ,1 ,3 ,6};
        System.out.println(aggressiveCows(arr,2));

    }

    public static int aggressiveCows(int[] talls, int k) {
        Arrays.sort(talls);

        int s = 1, e = talls[talls.length-1], ans = 0;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (ch(talls, mid, k)) {
                s = mid + 1;
                ans = mid;
            } else {
                e = mid - 1;
            }
        }
        return ans;

    }

    public static boolean ch(int arr[], int mid, int k) {
        int c = 1, cur = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - cur >= mid) {
                c++;
                cur = arr[i];
            }
        }
        if (c >= k) {
            return true;
        }
        return false;

    }
}