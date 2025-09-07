import java.util.ArrayList;
import java.util.List;

public class DFS {

    static void dfsSearch(List<List<Integer>>adj,boolean [] visited,int src){
        visited[src]=true;
        System.out.println(src+ "");

        for(int i:adj.get(src)){
            if(!visited[i]){
                dfsSearch(adj,visited,i);
            }
        }
    }


    static void addEdge(List<List<Integer>>adj,int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {
        int no_V =5;
        List<List<Integer>>adj =new ArrayList<>(no_V);
        for(int i =0;i<no_V;i++){
            adj.add(new ArrayList<>());
        }
        boolean [] visited = new boolean[adj.size()];

        int [][] edges = {
                {0,1},{0,2},{1,3},{3,4}
        };

        for(int [] e:edges){
            addEdge(adj,e[0],e[1]);
        }

        dfsSearch(adj,visited,0);

        System.out.println(adj);
    }
}
