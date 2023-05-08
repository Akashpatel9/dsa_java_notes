package Leetcode.binary_search;

import java.util.*;

class Find_in_infinite_array {
    public static void main(String[] args) {
        int candidates[] = {3,1,5,3}; int target = 8;
    List<List<Integer>> ans = new ArrayList<>();
    ArrayList<Integer> al = new ArrayList<>();
    p(candidates , target , al, ans ,0);
        System.out.println(ans);


}
    public static void p(int[] candidates, int target,ArrayList<Integer> al,List<List<Integer>> ans,int i) {
        if (target == 0) {
            System.out.println(new ArrayList<>(al));
            ans.add(new ArrayList<>(al));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            int t = target - candidates[j];
            al.add(candidates[j]);
            p(candidates, t, al, ans, j+1);
            al.remove(al.size() - 1);
        }
    }


}