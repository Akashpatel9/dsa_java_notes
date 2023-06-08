package DSA_notes.Graph;

import java.util.*;

public class Bfs_Implementation {

    public static void Bfs(ArrayList<ArrayList<Integer>> graph , int start){

        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        set.add(start);

        while (!q.isEmpty()){

            int s = q.poll();
            System.out.print(s+" ");

            for (int i : graph.get(s)) {
                if (!set.contains(i)){
                    set.add(i);
                    q.offer(i);
                }
            }
        }
    }
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


         Bfs(graph,0);

    }
}
