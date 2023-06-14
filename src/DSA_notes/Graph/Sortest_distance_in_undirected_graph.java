package DSA_notes.Graph;

import java.util.*;

public class Sortest_distance_in_undirected_graph {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        int V = 5;  // No of vortex / Nodes

        for (int i = 0; i < V; i++) {
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


        int []dis= new int[V];

        Arrays.fill(dis,Integer.MAX_VALUE);

        Set<Integer> vis = new HashSet<>();

        Queue<Integer> q = new LinkedList<>();

        dis[0]=0;
        q.offer(0);
        vis.add(0);

        while (!q.isEmpty()){
            int s = q.poll();
            for (int neb:graph.get(s)){
                if (!vis.contains(neb) && dis[s]+1<dis[neb]){
                    dis[neb] = dis[s]+1;
                    q.offer(neb);
                    vis.add(neb);
                }
            }
        }

        for (int i = 0; i < dis.length; i++) {
            if (dis[i]==Integer.MAX_VALUE){
                dis[i]=-1;
            }
        }

        System.out.println(Arrays.toString(dis));

    }
}
