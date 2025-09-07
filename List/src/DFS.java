import java.util.ArrayList;
import java.util.List;

class Gr{
    List<List<Integer>> graph;
    Gr(int n){
        graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
    }
}
public class DFS {
    Gr g=new Gr(4);
    void addEdge(int s,int d){
        g.graph.get(s).add(d);
        g.graph.get(d).add(s);
    }
    void dfsSearch(int src,boolean[] visit){
        visit[src]=true;
        System.out.print(src+" ");
        for(int i:g.graph.get(src)){
            if(!visit[i]){
                dfsSearch(i,visit);
            }
        }
    }
    public static void main(String[] args) {
        DFS d=new DFS();
        d.addEdge(0,2);
        d.addEdge(0,1);
        d.addEdge(2,3);
        boolean[] visit=new boolean[4];
        d.dfsSearch(0,visit);
    }
}
