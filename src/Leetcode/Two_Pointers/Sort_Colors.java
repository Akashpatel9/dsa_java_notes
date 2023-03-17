package Leetcode.Two_Pointers;

public class Sort_Colors {
    public static void main(String[] args) {
        //Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
        //
        //We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
        //
        //You must solve this problem without using the library's sort function.
        //
        //
        //
        //Example 1:
        //
        //Input: nums = [2,0,2,1,1,0]
        //Output: [0,0,1,1,2,2]
        //
        //Example 2:
        //
        //Input: nums = [2,0,1]
        //Output: [0,1,2]
    }

    //solution

    public void sortColors(int[] nums) {
        int s= 0,mid=0,e=nums.length-1;

        while(mid<=e){
            if(nums[mid]==2){
                swap(nums,mid,e);
                e--;
            }
            else if(nums[mid]==0){
                swap(nums,mid,s);
                s++;
                mid++;
            }else{
                mid++;
            }
        }
    }
    void swap(int []nums,int i,int j){
        int tem =nums[i];
        nums[i]=nums[j];
        nums[j]=tem;
    }
}
