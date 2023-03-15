public class Euclidean_algo {
    public Euclidean_algo() {
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 6;
        int gcd = gcd(a, b);
        int lcm = a * b / gcd;
        System.out.println(gcd);
        System.out.println(lcm);
    }
}
