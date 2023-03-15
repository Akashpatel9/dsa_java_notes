import java.util.Scanner;

public class Newton_Formula_SQRT {
    public Newton_Formula_SQRT() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long i;
        for(i = (long)n; i * i > (long)n; i = (i + (long)n / i) / 2L) {
        }

        System.out.println(i);
    }
}
