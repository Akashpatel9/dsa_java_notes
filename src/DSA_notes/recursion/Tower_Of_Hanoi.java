package DSA_notes.recursion;

public class Tower_Of_Hanoi {
    static int c = 0;
    public static int toh(int n, int source , int tem , int destination){
        if (n==1){
            System.out.println("transfer Disk = "+n+"    from rod "+source+"    to rod "+destination);
            return c++;
        }
        toh(n-1,source,destination,tem);
        c++;
        System.out.println("transfer Disk = "+n+"    from rod "+source+"    to rod "+destination);
        toh(n-1,tem,source,destination);
        return c;
    }

    public static void main(String[] args) {
        int n =3;
        System.out.println(toh(n,1,2,3));
    }

}
