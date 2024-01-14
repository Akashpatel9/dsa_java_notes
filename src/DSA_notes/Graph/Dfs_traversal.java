package DSA_notes.Graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Dfs_traversal {
    public static void dfs(int start, ArrayList<ArrayList<Integer>> graph , Set<Integer> set){

        System.out.print(start+" ");
        set.add(start);

        for (int i = 0; i < graph.get(start).size(); i++) {
            int neb = graph.get(start).get(i);
            if (!set.contains(neb)){
                set.add(neb);
                dfs(neb,graph,set);
            }
        }
    }
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        int v = 6;  // No of vortex / Nodes

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
//        graph.get(1).add(0);

        graph.get(1).add(2);
//        graph.get(2).add(1);

        graph.get(2).add(3);
//        graph.get(3).add(2);

        graph.get(2).add(4);
//        graph.get(4).add(2);

        //disconnected node
        graph.get(5).add(6);
//        graph.get(6).add(5);

        System.out.println(graph);

        Set<Integer> set = new HashSet<>();


        for (int i = 0; i <= v; i++) {  // for disconnected graph nodes
            if (!set.contains(i)) {
                dfs(i, graph, set);
            }
        }



    }
}
