package DSA_notes.Graph;

import java.lang.reflect.Array;
import java.util.*;

public class Bfs_Kahns_Algo {
    public static void main(String[] args) {


        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        int v = 4;  // No of vortex / Nodes

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
//        graph.get(1).add(0);

        graph.get(1).add(2);
//        graph.get(2).add(1);

        graph.get(2).add(3);
        graph.get(3).add(1);

        graph.get(2).add(4);
//        graph.get(4).add(2);

        //disconnected node
//        graph.get(5).add(6);
//        graph.get(6).add(5);


        int indeg[] = new int[graph.size()];

        for(ArrayList<Integer> adj : graph){
            for (int nev : adj){
                indeg[nev]++;
            }
        }


        Queue<Integer> q = new LinkedList<>();

        ArrayList<Integer> al = new ArrayList<>();


        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i]==0){
                q.offer(i);
            }
        }

        while (!q.isEmpty()){
            int s = q.poll();
            al.add(s);
            for (int neb : graph.get(s)){
                if (--indeg[neb]==0){
                    q.offer(neb);
                }
            }
        }

        System.out.println(al);

    }
}
