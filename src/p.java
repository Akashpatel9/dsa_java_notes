class p{
    public static int fn(int n , int k){
        if (n==1) return k;
        if (n==2) return k*(k-1)+k;
        return (fn(n-2,k) + fn(n-1,k)) * (k-1);
    }
    public static void main(String[] args) {

        int n = 2;
        int c = 4;

        System.out.println(fn(n,c));

    }
}