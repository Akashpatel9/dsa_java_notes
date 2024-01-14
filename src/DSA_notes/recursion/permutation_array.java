package DSA_notes.recursion;
import java.util.ArrayList;

public class permutation_array {
    public static void p(int []arr , int i , ArrayList<Integer> al, ArrayList<ArrayList<Integer>> ans){
        if (i==arr.length){
            ans.add(new ArrayList<>(al));
            return;
        }
        for (int j = i; j < arr.length; j++) {
            swap(i,j,arr);
            al.add(arr[i]);
            p(arr,i+1,al,ans);
            swap(i,j,arr);
            al.remove(i);
        }
    }
    public static void swap(int i,int j,int arr[]){
        int tem = arr[i];
        arr[i]=arr[j];
        arr[j]=tem;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3};
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> al = new ArrayList<>();
        p(arr,0,al,ans);
        System.out.println(ans.size());
    }
}
