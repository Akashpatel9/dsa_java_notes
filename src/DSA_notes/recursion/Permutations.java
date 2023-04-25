package DSA_notes.recursion;

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

    }
}
