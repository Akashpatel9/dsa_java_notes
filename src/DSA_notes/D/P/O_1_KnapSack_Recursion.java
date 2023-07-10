package DSA_notes.D.P;

public class O_1_KnapSack_Recursion {
    public static int solve(int[] val, int[] wt, int i, int t_w) {
        if (i == val.length || t_w == 0) return 0;
        if (t_w - wt[i] >= 0) {
            int take = val[i]+solve(val, wt, i + 1, t_w - wt[i]);
            int not_take = solve(val, wt, i + 1, t_w);
            return Math.max(take, not_take);
        } else {
            return solve(val, wt, i + 1, t_w);
        }
    }

    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int t_w = 7;

        System.out.println(solve(val,wt,0,t_w));
    }
}
