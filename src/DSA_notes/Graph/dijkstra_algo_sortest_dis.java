package DSA_notes.Graph;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Pair{
    int v;
    int d;
    Pair(int v,int d){
        this.v=v;
        this.d=d;
    }
}
public class dijkstra_algo_sortest_dis {
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


        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.d-o2.d;
            }
        });

        boolean vis[] = new boolean[v];

        int dis[] = new int[v];

        Arrays.fill(dis,Integer.MAX_VALUE);

        pq.offer(new Pair(0,0));

        dis[0]=0;

        while (!pq.isEmpty()){
            Pair s = pq.poll();
            int curr = s.v;
            if (!vis[curr]){
                vis[curr]=true;
                for (Edge neb : graph.get(curr)){
                    int ver = neb.destination;
                    int ver_wei = neb.weight;
                    if (dis[curr] + ver_wei < dis[ver]){
                        pq.offer(new Pair(ver ,dis[curr] + ver_wei ));
                        dis[ver] = dis[curr] + ver_wei ;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(dis));

    }
}
