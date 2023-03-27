package DSA_notes.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Dutch_national_flag_algo {
    public static void main(String[] args) {

    //short 0s,  1s,  2s;

    int arr[] = {2, 1, 0, 2, 1, 1, 2, 0, 2};

    int s = 0, mid = 0, e = arr.length - 1;

    while (mid<=e) {
        if (arr[mid] == 2) {
            int tem = arr[mid];
            arr[mid] = arr[e];
            arr[e] = tem;
            e--;
        } else if (arr[mid] == 0) {
            int tem = arr[mid];
            arr[mid] = arr[s];
            arr[s] = tem;
            s++;
            mid++;
        } else {
            mid++;
        }
    }
//        System.out.println(Arrays.toString(arr));

        Map<Character,Integer> map = new HashMap<>();

    String w = "GvtRG";

        char x[] = {'t','v'};
        int b[] = {26,-640};

        int j = 0;
        for(char i='A';i<='z';i++){
                map.put(i,(int)i);
                if(j<x.length && map.containsKey(x[j])){
                    map.put(x[j],b[j]);
                    j++;
                }
        }

        System.out.println(map);

        int sum = 0;
        String ans= "";
        String a = "";

        for(int i=0;i<w.length();i++){
            if(map.containsKey(w.charAt(i))){
                sum+=map.get(w.charAt(i));
                    ans+=w.charAt(i);
                    a=ans;
            }
            if(sum<0){
                sum=0;
                ans="";

            }
        }
        System.out.println(a);
   }
}
