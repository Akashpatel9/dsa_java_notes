package DSA_notes.Bit_Manuplation;

class bit_Manuplation {
    bit_Manuplation() {
    }

    public static int getI_bit(int n, int i) {
        int bitmask = 1 << i;
        return (bitmask & n) == 0 ? 0 : 1;
    }

    public static int setI_bit(int n, int i) {
        int bitmask = 1 << i;
        return n | bitmask;
    }

    public static int clearI_bit(int n, int i) {
        int bitmask = ~(1 << i);
        return n & bitmask;
    }

    public static int updateI_bit_0_1(int n, int i, int b) {
        n = clearI_bit(n, i);
        int bitmask = b << i;
        return bitmask | n;
    }

    public static int clearLastI_bits(int n, int i) {
        int bitmask = -1 << i;
        return bitmask & n;
    }

    public static boolean check_2_pow(int n) {
        //(4)=  100 & (3)=011 == 000
        return (n & n - 1) == 0;
    }

    public static int count_set_bits(int n) {
        int c = 0;
        while (n != 0) {
            if ((1 & n) != 0) {
                c++;
            }
            n = n >> 1;
        }
        return c;
    }

    public static int fast_Expo(int n, int p) {
        int ans = 1;
        while (n != 0) {
            if ((n & 1) != 0) ans *= p;

            p *= p;
            n = n >> 1;
        }
        return ans;
    }


    public static int modular_Expo(int n, int p) {
        int ans = 1;
        while (n != 0) {
            if ((n & 1) != 0) ans *= p;

            p *= p;
            n = n >> 1;
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
