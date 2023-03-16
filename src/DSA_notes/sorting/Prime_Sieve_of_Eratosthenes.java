package DSA_notes.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Prime_Sieve_of_Eratosthenes {
    public Prime_Sieve_of_Eratosthenes() {
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter range to print no");
        int n = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[n + 1];
        Arrays.fill(arr, true);
        arr[0] = false;
        arr[1] = false;

        int i;
        for(i = 2; (double)i < Math.sqrt((double)arr.length); ++i) {
            for(int j = i * 2; j < arr.length; j += i) {
                arr[j] = false;
            }
        }

        for(i = 0; i < arr.length; ++i) {
            if (arr[i]) {
                System.out.print("" + i + " ");
            }
        }

    }
}
