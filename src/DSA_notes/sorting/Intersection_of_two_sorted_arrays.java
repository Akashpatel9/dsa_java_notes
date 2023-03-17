package DSA_notes.sorting;

import java.util.ArrayList;

public class Intersection_of_two_sorted_arrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2, 3, 4, 4, 5, 5} ,nums2 = {3, 4, 5, 9, 9, 10,11,12,13,14};

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
                j++;
            } else {
                i++;
            }
        }
        System.out.println(al);
    }
}
