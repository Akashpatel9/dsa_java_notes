package DSA_notes.recursion;
import java.util.ArrayList;
import java.util.Stack;
public class reverse_arrayList_or_stack {


    // ArrayList
    public static void sort(ArrayList<Integer> al){
        if(al.size()==1){
            return;
        }
        int val = al.remove(al.size()-1);
        sort(al);
        s(al,val);
    }
    public static void s(ArrayList<Integer> al , int val){
        if( al.size()==0 || al.get(al.size()-1) <=val){
            al.add(val);
            return;
        }
        int n = Integer.MIN_VALUE;
        if (al.get(al.size()-1)>val){
            n=al.remove(al.size()-1);
        }
        s(al,val);
        if (n!=Integer.MIN_VALUE) al.add(n);
    }



    //Stack
    public static void sort(Stack<Integer> st){
        if(st.size()==1){
            return;
        }
        int val = st.pop();
        sort(st);
        s(st,val);
    }
    public static void s(Stack<Integer> st , int val){
        if(st.isEmpty() || st.peek()<=val){
            st.push(val);
            return;
        }
        int n = Integer.MIN_VALUE;
        if (st.peek()>val){
            n=st.pop();
        }
        s(st,val);
        if (n!=Integer.MIN_VALUE) st.push(n);
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();

        int arr[] = {8,2,4,9,2,5,7,3,1};
        for (int i = 0; i < arr.length; i++) {
            al.add(arr[i]);
        }
        sort(al);
        System.out.println(al);

    }
}
