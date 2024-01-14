package DSA_notes.recursion;

import DSA_notes.comparator.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Permutations {
    public static void p(String s ,String ans){
        if (s.length()==0){
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            String n  = s.substring(0,i)+s.substring(i+1);
            p(n,ans+curr);
        }
    }
    public static void main(String[] args) {
        p("abc","");


        Integer []arr = {1,2,3};

        Arrays.sort(arr, Collections.reverseOrder());
    }
}
