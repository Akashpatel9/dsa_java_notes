package DSA_notes.sorting;

import java.util.*;

public class Union_of_Two_Sorted_Arrays {
    public static void main(String[] args) {
       int[] nums1 = {1, 1, 2, 3, 4, 4, 5, 5} ,nums2 = {1, 2, 2, 3, 3, 4, 9, 10};

       int i=0,j=0;

       ArrayList<Integer> al = new ArrayList<>();

       while (i< nums1.length && j< nums2.length) {
           if (nums1[i] == nums2[j]) {
               if (al.size()>0&&al.get(al.size()-1) != nums1[i]) {
                   al.add(nums1[i]);
               }else if (al.size()==0){
                   al.add(nums1[i]);
               }
               i++;
               j++;
           } else if (nums1[i] > nums2[j]) {
               if (al.size()>0&&al.get(al.size()-1) != nums2[j]) {
                   al.add(nums2[j]);
               }else if (al.size()==0){
                   al.get(nums2[j]);
               }
               j++;
           } else {
               if (al.size()>0&&al.get(al.size()-1)!= nums1[i]) {
                   al.add(nums1[i]);
               }else if (al.size()==0){
                   al.add(nums1[i]);
               }
               i++;
           }
       }
        System.out.println(al);
    }
}
