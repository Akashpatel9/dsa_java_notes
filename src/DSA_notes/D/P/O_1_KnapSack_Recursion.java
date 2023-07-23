package DSA_notes.D.P;

import java.util.*;

public class O_1_KnapSack_Recursion {

    public static int solveUsingRec(int[] wt, int[] val, int w, int i) {

        if (w == 0) return 0;

        if (i == 0) {
            if (w >= wt[i]) {
                return val[i];
            }
            return 0;
        }

        int inc = 0;
        if (w - wt[i] >= 0) {
            inc = val[i] + solveUsingRec(wt, val, w - wt[i], i - 1);
        }
        int exc = solveUsingRec(wt, val, w, i - 1);

        return Math.max(inc, exc);

    }


    public static int solveUsingMem(int[] wt, int[] val, int w, int i, int[][] dp) {

        if (w == 0) return 0;

        if (i == 0) {
            if (w >= wt[i]) {
                return val[i];
            }
            return 0;
        }

        if (dp[i][w] != -1) return dp[i][w];

        int inc = 0;
        if (w - wt[i] >= 0) {
            inc = val[i] + solveUsingMem(wt, val, w - wt[i], i - 1, dp);
        }
        int exc = solveUsingMem(wt, val, w, i - 1, dp);

        return dp[i][w] = Math.max(inc, exc);

    }


    public static int solveUsingTab(int[] wt, int[] val, int w) {

        int n = wt.length;

        int[][] dp = new int[n][w + 1];

        for (int j = 0; j < n; j++) {
            dp[j][0] = 0;
        }

        for (int i = 0; i < w + 1; i++) {
            if (i >= wt[0]) dp[0][i] = val[0];
            else dp[0][i] = 0;
        }


        for (int i = 1; i < n; i++) {
            for (int j = 1; j < w + 1; j++) {
                int inc = 0;
                if (j - wt[i] >= 0) {
                    inc = val[i] + dp[i - 1][j - wt[i]];
                }
                int exc = dp[i - 1][j];

                dp[i][j] = Math.max(inc, exc);
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[n - 1][w];
    }


    public static int solveUsingVer(int[] wt, int[] val, int w) {
        int n = wt.length;
        int[] pre = new int[w + 1];
        int[] curr = new int[w + 1];

        for (int i = wt[0]; i < w + 1; i++) {
            if (i >= wt[0]) pre[i] = val[0];
            else pre[i] = 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < w + 1; j++) {
                int inc = 0;
                if (j - wt[i] >= 0) {
                    inc = val[i] + pre[j - wt[i]];
                }
                int exc = pre[j];

                curr[j] = Math.max(inc, exc);
            }
            for(int e=0;e< curr.length;e++) pre[e] = curr[e];
        }

        return pre[w];
    }


    public static void main(String[] args) {
        int[] wt = {4, 5, 1};
        int[] val = {1, 2, 3};
        int w = 3;

//        int n = wt.length;
//
//        int[][] dp = new int[n][w + 1];
//
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(dp[i], -1);
//        }

//        System.out.println(solveUsingRec(wt, val, w, n - 1));

//        System.out.println(solveUsingMem(wt, val, w, n - 1, dp));

//        System.out.println(solveUsingTab(wt, val, w));

        System.out.println(solveUsingVer(wt, val, w));

    }
}
