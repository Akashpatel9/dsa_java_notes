package DSA_notes.Graph;

import java.util.Arrays;

public class dijkstra_algo_sortest_dis_Matrix {
    public static void main(String[] args) {
        int v = 8, e = 14;
        int[][] graph = new int[v + 1][v + 1];

        graph[0][1] = 4;
        graph[1][0] = 4;

        graph[0][7] = 8;
        graph[7][0] = 8;

        graph[1][7] = 11;
        graph[7][1] = 11;

        graph[1][2] = 8;
        graph[2][1] = 8;

        graph[7][6] = 1;
        graph[6][7] = 1;

        graph[7][8] = 7;
        graph[8][7] = 7;

        graph[2][8] = 2;
        graph[8][2] = 2;

        graph[8][6] = 6;
        graph[6][8] = 6;

        graph[2][5] = 4;
        graph[5][2] = 4;

        graph[2][3] = 7;
        graph[3][2] = 7;

        graph[6][5] = 2;
        graph[5][6] = 2;

        graph[3][5] = 14;
        graph[5][3] = 14;

        graph[3][4] = 9;
        graph[4][3] = 9;

        graph[5][4] = 10;
        graph[4][5] = 10;



        boolean []vis = new boolean[v+1];

        int []dis = new int[v+1];

        Arrays.fill(dis,Integer.MAX_VALUE);

        dis[0]=0;

        for (int i = 0; i < v+1; i++) {

            int min_w = Integer.MAX_VALUE, min_i = -1;
            for (int j = 0; j < dis.length; j++) {
                if (!vis[j] && dis[j] <= min_w){
                    min_i = j;
                    min_w = dis[j];
                }
            }

            vis[min_i] = true;

            for (int j = 0; j < v+1; j++) {
                if(!vis[j] && graph[min_i][j] != 0 && dis[j] > dis[min_i] + graph[min_i][j]){
                    dis[j] = dis[min_i] + graph[min_i][j];
                }
            }

        }

        System.out.print(Arrays.toString(dis));



    }
}
