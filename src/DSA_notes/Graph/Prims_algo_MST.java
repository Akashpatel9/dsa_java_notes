package DSA_notes.Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Prims_algo_MST {
    public static void main(String[] args) {
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        int v = 5;  // No of vortex / Nodes

        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Edge(0, 1, 1));
        graph.get(1).add(new Edge(1, 0, 1));

        graph.get(1).add(new Edge(1, 2, 4));
        graph.get(2).add(new Edge(2, 1, 4));

        graph.get(2).add(new Edge(2, 3, 3));
        graph.get(3).add(new Edge(3, 2, 3));

        graph.get(2).add(new Edge(2, 4, 2));
        graph.get(4).add(new Edge(4, 2, 2));

        graph.get(3).add(new Edge(3, 1, 3));
        graph.get(1).add(new Edge(1, 3, 3));

        graph.get(4).add(new Edge(4, 3, 1));
        graph.get(3).add(new Edge(3, 4, 1));


        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.d - o2.d;
            }
        });

        boolean vis[] = new boolean[v];

        pq.offer(new Pair(0, 0));

        int totalDis = 0;

        ArrayList<Integer> path = new ArrayList<>();


        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            if (!vis[curr.v]) {
                vis[curr.v] = true;
                totalDis += curr.d;
                path.add(curr.v);

                for (Edge neb : graph.get(curr.v)) {
                    pq.offer(new Pair(neb.destination, neb.weight));
                }
            }

        }


        System.out.println(totalDis);
        System.out.println(path);

    }
}
