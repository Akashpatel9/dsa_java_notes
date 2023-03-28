package Leetcode.binary_search;

import java.util.ArrayList;

public class Cooking_Ninjas {
    public static void main(String[] args) {
        //Problem Statement
        //Suggest Edit
        //In Ninja Land, there is a famous restaurant named 'Cooking Ninjas'.
        // There are 'N' cooks in 'CookingNinjas' numbered from 0 to N-1. Each cook has rank 'R' (1 <= R <=10).
        //A cook with a rank 'R' can prepare 1 dish in the first 'R' minutes, 1 more dish in the next '2R' minutes,
        // 1 more dish in next '3R' minutes, and so on (A cook can only make complete dishes) For example if a cook is ranked 2.
        // He will prepare one dish in 2 minutes, one more dish in the next 4 mins and one more in the next 6 minutes hence in a
        // total of 12 minutes he can make 3 dishes, Note, In 13 minutes also he can make only
        // 3 dishes as he does not have enough time for the 4th dish).
        //One day 'Cooking Ninas' receive an order of 'M' dishes that they need to complete as early as possible.
        // You are given an integer array 'rank' of size 'N' in which 'rank[i' gives 'rank' of ith cook and an integer 'M',
        // You need to find out the minimum times required to complete this order of 'M' dishes.

        //ex

        //N=4  M=11
        //1 2 3 4

        //Let ‘N’ = 4,  ‘ranks’ = [1, 2, 3, 4] and ‘M’ = 11.  Then the minimum time required to cook 11 dishes will be 12 minutes.  The cooks should prepare dishes in the following manner -:
        //Cook-0 prepare 4 dishes in 10 minutes i.e (1 dish in 1 minute, 1 more dish in next 2 minutes, 1 more dish in next 3 minutes, 1 more dish in next 4 minutes).
        //Cook-1 prepare 3 dishes in 12 minutes i.e (1 dish in 2 minutes, 1 more dish in 4 minutes, 1 more dish in 6 minutes).
        //Cook-2 prepare 2 dishes in 9 minutes i.e (1 dish in 3 minutes, 1 more dish in the next 6 minutes).
        //Cook-3 prepare 2 dishes in 12 minutes i.e (1 dish in 4 minutes, 1 more dish in the next 8 minutes).
        //If all four cooks work simultaneously then they can prepare(4 + 3 + 2 + 2 = 11) dishes in 12 minutes. And it is the minimum possible time.




    }
    public static int minCookTime(ArrayList<Integer> rank, int m)
    {
        int s = 1,e=rank.get(rank.size()-1)*(m*(m+1)),ans = 0;

        while(s<=e){
            int mid = s+(e-s)/2;
            if(che(rank,mid,m)){
                e=mid-1;
                ans = mid;
            }else{
                s=mid+1;
            }
        }
        return ans;
    }
    public static boolean che(ArrayList<Integer> rank,int mid, int m){
        int sum = 0;
        for(int i=0;i<rank.size();i++){
            int mul=0;
            int j = 1;
            int c = 0;
            while(mul<=mid){
                mul+=rank.get(i)*j;
                c++;
                j++;
            }
            sum+=(c-1);
        }

        if(sum>=m){
            return true;
        }
        return false;

    }
}
