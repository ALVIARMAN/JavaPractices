import java.util.LinkedList;

public class DFSP {
    public static int V;
    public LinkedList<Integer>[] adj;

    public DFSP(int V){
        this.V=V;
        adj = new LinkedList[V];

        for(int i=0;i<V;i++){
            adj[i] = new LinkedList<>();
        }
    }
    void dfsSearch(boolean[] visit,int src){
        visit[src]=true;
        System.out.println(src +" ");

        for(int i:adj[src]){
            if(!visit[i]){
                dfsSearch(visit,i);
            }
        }
    }

    void addEdge(int u,int v){
        adj[u].add(v);
        adj[v].add(u);
    }

    public static void main(String[] args) {
        DFSP g = new DFSP(5);
        g.addEdge(0,1);g.addEdge(0,2); g.addEdge(1,3);g.addEdge(3,4);

        boolean[] visit = new boolean[5];

        g.dfsSearch(visit,0);

    }
}
