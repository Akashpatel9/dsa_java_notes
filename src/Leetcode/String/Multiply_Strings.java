package Leetcode.String;

public class Multiply_Strings {
    public static void main(String[] args) {
        //Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
        //
        //Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
        //
        //
        //
        //Example 1:
        //
        //Input: num1 = "2", num2 = "3"
        //Output: "6"
        //
        //Example 2:
        //
        //Input: num1 = "123", num2 = "456"
        //Output: "56088"
        //
        //
        //
        //Constraints:
        //
        //    1 <= num1.length, num2.length <= 200
        //    num1 and num2 consist of digits only.
        //    Both num1 and num2 do not contain any leading zero, except the number 0 itself.

    }

    //solution
    public String multiply(String num1, String num2) {

        //if any of both String are equal to 0 ;
        if(num1.equals("0") || num2.equals("0")) return "0";

        int p=0;
        String ans ="";
        for(int i=num2.length()-1;i>=0;i--){
            String m = mul(num1,num2.charAt(i));
            for(int z = 0;z<p;z++){
                m+=0;
            }
            ans = add(ans,m);
            p++;
        }
        return ans;
    }

    //adding---------------

    public String add(String a, String b){
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1,j = b.length()-1,carry =0;
        while(i>=0 || j>=0 || carry!=0){
            int sum = carry;
            if(i>=0){
                sum+=(a.charAt(i--)-48);
            }
            if(j>=0){
                sum+=(b.charAt(j--)-48);
            }
            sb.append(sum%10);
            carry=sum/10;
        }
        return sb.reverse().toString();
    }

    //multipling------------------

    public String mul(String nums ,char n){
        StringBuilder sb = new StringBuilder();
        int carry =0;
        for(int i=nums.length()-1;i>=0;i--){
            int sum = carry;
            sum+=((int)(nums.charAt(i)-48))*((int)(n-48));
            sb.append(sum%10);
            carry=sum/10;
        }
        if(carry!=0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
