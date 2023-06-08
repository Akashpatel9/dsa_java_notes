package DSA_notes.Graph;

import java.util.ArrayList;

public class Weighted_graph_ArrayList {
    public static void main(String[] args) {

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        int v = 4;  // No of vortex / Nodes

        for (int i = 0; i <= 4; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Edge(0, 1, 1));
//        graph.get(1).add(new Edge(1, 0, 1));

        graph.get(1).add(new Edge(1, 2, 4));
//        graph.get(2).add(new Edge(2, 1, 4));

        graph.get(2).add(new Edge(2, 3, 3));
//        graph.get(3).add(new Edge(3, 2, 3));

        graph.get(2).add(new Edge(2, 4, 2));
//        graph.get(4).add(new Edge(4, 2, 2));

        for (int i = 0; i < graph.size(); i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print("s="+graph.get(i).get(j).source + ", D=" + graph.get(i).get(j).destination + ", w=" + graph.get(i).get(j).weight + "    ");
            }
            System.out.println();
        }


    }
}
