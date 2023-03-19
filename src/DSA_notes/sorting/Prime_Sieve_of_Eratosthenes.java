package DSA_notes.sorting;
import java.util.*;
public class Prime_Sieve_of_Eratosthenes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        boolean[] arr = new boolean[n + 1];

        Arrays.fill(arr, true);

        arr[0] = false;
        arr[1] = false;

        for(int i = 2; (double)i < Math.sqrt((double)arr.length); i++) {
            for(int j = i * 2; j < arr.length; j += i) {
                arr[j] = false;
            }
        }

        for(int i = 2; i < arr.length; ++i) {
            if (arr[i]) System.out.print(i+" ");
        }

    }
}
