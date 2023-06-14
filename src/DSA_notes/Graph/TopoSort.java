package DSA_notes.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TopoSort {
    public static void topo(ArrayList<ArrayList<Integer>> graph , Stack<Integer> st , int start , Set<Integer> vis){
        vis.add(start);
        for (int nev : graph.get(start)){
            if (!vis.contains(nev)){
                topo(graph,st,nev,vis);
            }
        }
        st.push(start);
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        int v = 7;  // No of vortex / Nodes

        for (int i = 0; i < v; i++) {
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

        Set<Integer> vis = new HashSet<>();

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i <= v; i++) {  // for disconnected graph nodes
            if (!vis.contains(i)) {
                topo(graph,st,i,vis);
            }
        }


        ArrayList<Integer> topoSort = new ArrayList<>();

        while (!st.isEmpty()){
            topoSort.add(st.pop());
        }

        System.out.println(topoSort);

    }
}
