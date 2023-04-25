package DSA_notes.recursion;

public class SubSequences_String {

    // different names (Subsets , Subsequences , Powersets)

    public static void subSeq(String s ,int i,String a){
        if (i==s.length()){
           System.out.print(a+" ");
            return;
        }
        subSeq(s,i+1,a+s.charAt(i));
        subSeq(s,i+1,a);
    }
    public static void main(String[] args) {
        String s = "414";
        subSeq(s,0,"");
    }
}
