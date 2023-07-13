package DSA_notes.Graph;

import java.util.ArrayList;
import java.util.Stack;

public class S_C_C_Kosaraju_Algo {

    public static void topo(int s , ArrayList<ArrayList<Integer>> adj, Stack<Integer> st, boolean[]vis){
        vis[s]=true;
        for (int neb:adj.get(s)){
            if (!vis[neb]){
                topo(neb,adj,st,vis);
            }
        }
        st.push(s);
    }

    public static void dfs(int s , ArrayList<ArrayList<Integer>> adjT, boolean[]vis, ArrayList<Integer> al){
        vis[s]=true;
        al.add(s);
        for (int neb:adjT.get(s)){
            if (!vis[neb]){
                dfs(neb,adjT,vis,al);
            }
        }
    }
    public static void main(String[] args) {
        //build graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = 5;
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(2);
        adj.get(1).add(0);
        adj.get(2).add(1);
        adj.get(0).add(3);
        adj.get(3).add(4);


        boolean vis[] = new boolean[v];

        //TopoSort
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < v; i++) {
            if (!vis[i]){
                topo(i,adj,st,vis);
            }
        }

        //reverse graph
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adjT.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            vis[i]=false;
            for (int neb:adj.get(i)){
                //v->neb  -->>  neb->v
                adjT.get(neb).add(i);
            }
        }


        //finding SSC

        ArrayList<ArrayList<Integer>> ssc = new ArrayList<>();

        int count_number_of_SCC=0;  //SCC (Strongly Connected Components)

        while (!st.isEmpty()){
            int node = st.pop();
            if (!vis[node]){

                ArrayList<Integer> al = new ArrayList<>();

                dfs(node,adjT,vis,al);
                count_number_of_SCC++;

                ssc.add(al);
            }
        }

        System.out.println(count_number_of_SCC);
        System.out.println(ssc);

    }
}
