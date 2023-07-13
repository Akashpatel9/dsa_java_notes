package DSA_notes.Graph;

import java.util.Arrays;

public class Disjoint_Set {

    static int[] p;
    static int[] rank;
    int n;
    public Disjoint_Set(int n){
        this.n=n;
        p=new int[n];
        rank=new int[n];

        for (int i = 0; i < n; i++) {
            p[i]=i;
        }
    }


    public static int find(int n){
        if(p[n]==n)return n;
        return p[n]=find(p[n]);
    }

    public static void union(int x , int y){
        int a = find(x);
        int b = find(y);

        if (a==b)return;

        if(rank[a]==rank[b]){
            p[b]=a;
            rank[a]++;
        }
        else if(rank[a] < rank[b]){
            p[a] = b;
        }
        else if(rank[a] > rank[b]){
            p[b]=a;
        }
    }
    public static void main(String[] args) {

        Disjoint_Set d = new Disjoint_Set(5);

        union(0,1);
        union(2,3);
        union(4,2);

        System.out.println(Arrays.toString(rank));
        System.out.println(Arrays.toString(p));

    }
}
