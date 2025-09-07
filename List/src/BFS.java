import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Gra{
    List<List<Integer>> adjList;
    Gra(int n){
        adjList=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
    }
}
public class BFS {
    int v=4;
    Gra g=new Gra(v);
    void addEdge(int s,int d){
        g.adjList.get(s).add(d);
        g.adjList.get(d).add(s);
    }
    void display(int v){
        for(int i=0;i<v;i++){
            System.out.print(i+" ");
            for(int nei:g.adjList.get(i)){
                System.out.print(nei+" ");
            }
            System.out.println();
        }
    }
    void bfsSearch(int s){
        boolean[] visit=new boolean[v];
        Queue<Integer> q=new LinkedList<>();
        visit[s]=true;
        q.add(s);
        while(!q.isEmpty()){
            int curr=q.poll();
            System.out.println(curr);
            for(int i:g.adjList.get(curr)){
                if(!visit[i]){
                    q.add(i);
                    visit[i]=true;
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS b=new BFS();
        b.addEdge(0,1);
        b.addEdge(0,2);
        b.addEdge(1,3);
        b.bfsSearch(0);
    }
}
