package DSA_notes.Graph;

import java.util.ArrayList;

public class Build_graph_using_ListOfList_Or_AdjacentList {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        int v = 4;  // No of vortex / Nodes

        for (int i = 0; i <= 4; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(1).add(0);

        graph.get(1).add(2);
        graph.get(2).add(1);

        graph.get(2).add(3);
        graph.get(3).add(2);

        graph.get(2).add(4);
        graph.get(4).add(2);

        for (int i = 0; i < graph.size(); i++) {
            System.out.print(i+" -> ");
            for (int j = 0; j < graph.get(i).size(); j++) {

                if (j<graph.get(i).size()-1) {
                    System.out.print(graph.get(i).get(j) + ",");
                }else {
                    System.out.print(graph.get(i).get(j));
                }
            }
            System.out.println();
        }


    }
}
