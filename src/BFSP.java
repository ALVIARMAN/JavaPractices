import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSP{
    static void bfsSearch(List<List<Integer>>adj,int src){
        Queue <Integer> q = new LinkedList<>();
        boolean [] visited = new boolean[adj.size()];
        visited[src] = true;
        q.add(src);

        while(!q.isEmpty()){
            int curr = q.poll();
            System.out.println(curr+" ");

            for(int x:adj.get(curr)){
                if(!visited[x]){
                    visited[x]=true;
                    q.add(x);
                }
            }
        }
    }

    static void addEdge(List<List<Integer>>adj,int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>>adj = new ArrayList<>();

        for(int i =0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        int [][] edges = {
                {0,1},{0,2},{1,3},{3,4}
        };

        for(int[] e:edges){
            addEdge(adj,e[0],e[1]);
        }

        bfsSearch(adj,0);

        System.out.println(adj);

    }
}