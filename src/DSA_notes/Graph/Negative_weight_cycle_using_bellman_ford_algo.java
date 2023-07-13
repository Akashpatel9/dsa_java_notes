package DSA_notes.Graph;


import java.util.Arrays;

public class Negative_weight_cycle_using_bellman_ford_algo {
    public static boolean detect(int s , int []dis , int n,  int [][] edges){

        Arrays.fill(dis,Integer.MAX_VALUE);

        dis[s] = 0;

        for(int j=0;j<n-1;j++){
            for(int i[] : edges){
                int so = i[0];
                int d = i[1];
                int w = i[2];
                if(dis[so] != Integer.MAX_VALUE && dis[so] + w < dis[d]){
                    dis[d] = dis[so] + w;
                }
            }
        }


        for(int i[] : edges){
            int so = i[0];
            int d = i[1];
            int w = i[2];
            if(dis[so] != Integer.MAX_VALUE &&  dis[so] + w < dis[d]){
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {

        int v = 3;
        int[][] graph = {{0,1,-1},{1,2,-2},{2,0,-3}};

        int [] dis = new int[v];

        boolean cycle = false;

        for(int i=0;i<v;i++){
            if(detect(i,dis,v,graph)){
               cycle = true;
                break;
            }
        }

        System.out.println(Arrays.toString(dis));

        System.out.println(cycle);
    }
}
