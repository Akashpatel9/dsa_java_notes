package DSA_notes.sorting;

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

    public static int clearRangeOf_bits(int n, int i, int j) {
        int s = (2 << i) - 1;
        int e = -1 << j + 1;
        int c = s | e;
        return n & c;
    }

    public static boolean chack2_pow(int n) {
        return (n & n - 1) == 0;
    }

    public static int count_set_bits(int n) {
        int c;
        for(c = 0; n > 0; n >>= 1) {
            if ((1 & n) != 0) {
                ++c;
            }
        }

        return c;
    }

    public static int fast_Expo(int n, int p) {
        int ans;
        for(ans = 1; n > 0; n >>= 1) {
            if ((n & 1) != 0) {
                ans *= p;
            }

            p *= p;
        }

        return ans;
    }

    public static void main(String[] args) {
    }
}
