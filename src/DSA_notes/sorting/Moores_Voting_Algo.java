package DSA_notes.sorting;

public class Moores_Voting_Algo {
    public static void main(String[] args) {

        //find element count >n/2 times;

        int arr[] = {1,2,1,1,5,1,2,1};
        int c = 0;
        int curr = 0;

        for (int i = 0; i < arr.length; i++) {
            if(c==0){
                c=1;
                curr=i;
            }
            else if(arr[i]==arr[curr]){
                c++;
            }else {
                c--;
            }
        }

        c=0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[curr]==arr[i]){
                c++;
            }
        }
        if(c> arr.length/2) {
            System.out.println(arr[curr]);
        }else {
            System.out.println(-1);
        }

    }
}
