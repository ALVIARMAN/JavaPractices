import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    static void bfsSearch(List<List<Integer>>adj,int s){
        Queue <Integer> q = new LinkedList<>();
//      LinkedList<Integer> q = new LinkedList<>(); 

        boolean[] visited = new boolean[adj.size()];

        visited[s] = true;
        q.add(s);

        while(!q.isEmpty()){
            int cur = q.poll();
            System.out.println(cur+ " ");

            for(int x:adj.get(cur)){
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
        int V =5;
        List<List<Integer>>adj = new ArrayList<>(V);
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }


        addEdge(adj,0,1);
        addEdge(adj,1,2);
        addEdge(adj,2,3);
        addEdge(adj,3,4);

        System.out.println("BFS starting from 0");
        bfsSearch(adj,0);

    }
}

/*   List<List<Integer>>adj = new ArrayList<>();
        Outer List = List , Each index of outer list represents a node in the graph
        Inner List = <List<Integer>> , Each inner list store adjacent (connected) nodes for that particular nodes
        new ArrayList<>() create an empty ArrayList of list ,ArrayList can dynamically shrink and grow

     Queue <Integer> q = new LinkedList<>();
        Queue is an Interface in java and LinkedList is used for better fast insertion and deletion
        q.poll() = Removes and return the front element(null if empty)
        q.remove() = Remove and return the front element(throws exception if empty)

     adj.get(u).add(v) = add v to u node

     for(int x : adj.get(src)){
        //traverse the neighbour nodes of the current src node......
     }

 */