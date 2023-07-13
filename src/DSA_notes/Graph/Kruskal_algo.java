package DSA_notes.Graph;

import java.util.Arrays;

public class Kruskal_algo {

    public static int find(int node, int[] p) {
        if (p[node] == node) {
            return node;
        }
        return p[node] = find(p[node], p);
    }

    public static void union(int x, int y, int[] p, int[] fre) {
        int xnode = find(x, p);
        int ynode = find(y, p);

        if (xnode == ynode) return;

        if (fre[xnode] < fre[ynode]) {
            p[xnode] = ynode;
        } else if (fre[xnode] > fre[ynode]) {
            p[ynode] = xnode;
        } else {
            p[ynode] = xnode;
            fre[xnode]++;
        }
    }

    public static void main(String[] args) {


        //       0
        //     /   \
        //  5 /     \ 1
        //   /       \
        //  1 ------- 2
        //       3


        int[][] edges = {{0, 1, 5}, {1, 2, 3}, {0, 2, 1}};
        int V = 3;
        int E = edges.length;

        int[] p = new int[V];

        for (int i = 0; i < V; i++) p[i] = i;

        int[] fre = new int[V];


        Arrays.sort(edges, (o1, o2) -> o1[2] - o2[2]);

        int ans = 0;

        int path[][] = new int[V][V];

        for (int i = 0; i < E; i++) {
            int x = find(edges[i][0], p);
            int y = find(edges[i][1], p);

            if (x != y) {
                path[x][y] = edges[i][2];
                ans += edges[i][2];
                union(x, y, p, fre);
            }
        }

        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path.length; j++) {
                if (path[i][j] != 0) {
                    System.out.println(i + " --> " + j + " = " + path[i][j]);
                }
            }
        }

        System.out.println("total path = " + ans);

    }
}
