package DSA_notes.Graph;

public class Build_wighted_Matrix_graph {
    public static void main(String[] args) {

        //directed graph

        int v = 4, e = 4;
        int[][] graph = new int[v+1][v+1];

        graph[0][1] = 1;

        graph[1][2] = 4;

        graph[2][3] = 3;

        graph[2][4] = 2;

        for (int i = 0; i <= v; i++) {
            System.out.print(i+"->");
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j]!=0) {
                    System.out.print("s=" + i + ",d=" + j + ",w=" + graph[i][j] + "  ");
                }
            }
            System.out.println();
        }










    }
}
