import java.util.ArrayList;
import java.util.List;

class Edge{
    int dest,wei;
    Edge(int d,int w){
        this.dest=d;
        this.wei=w;
    }
}
class CreateGraph{
    List<List<Edge>> adjList;
    CreateGraph(int numV){
        adjList=new ArrayList<>();
        for(int i=0;i<numV;i++){
            adjList.add(new ArrayList<>());
        }
    }
    void addEdge(int s,int d,int w){
        adjList.get(s).add(new Edge(d,w));
        adjList.get(d).add(new Edge(s,w));
    }
    void display(int n){
        for(int i=0;i<n;i++){
            System.out.print(i+" ");
            for(Edge nei:adjList.get(i)){
                System.out.print(nei.dest+" "+nei.wei);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        CreateGraph c=new CreateGraph(2);
        c.addEdge(0,1,5);
        c.display(2);
    }
}