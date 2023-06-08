package DSA_notes.Graph;

public class Build_Graph_using_Matrix {
    public static void main(String[] args) {

        int v = 4, e = 4;  // v= vertex  , e = edges

        int[][] graph = new int[v + 1][e + 1];

        graph[0][1] = 1;
        graph[1][0] = 1;

        graph[1][2] = 1;
        graph[2][1] = 1;

        graph[2][4] = 1;
        graph[4][2] = 1;

        graph[2][3] = 1;
        graph[3][2] = 1;


        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 1) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }


    }
}
