package DSA_notes.Maths;

import java.util.Scanner;

public class Newton_Formula_SQRT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long i=n;
        while (i*i>n){
            i=(i+(n/i))/2;
        }

        System.out.println(i);



    }
}
