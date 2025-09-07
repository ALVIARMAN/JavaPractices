import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Adjacency List using HashMap;        //HashMap consist with key and value ex: name(key),Alvi(value).......
class Graph{
    Map<Integer, List<Integer>>adjList;
    Graph(int numV){
        adjList=new HashMap<>();
        for(int i=0;i<numV;i++){
            adjList.put(i,new ArrayList<>());
        }
    }
}
public class ListMap{
    Graph g=new Graph(3);

    void addEdge(int src,int dest){
        g.adjList.get(src).add(dest);
        g.adjList.get(dest).add(src);
    }
    void display(int numV){
        for(int i:g.adjList.keySet()){
            System.out.print(i+": ");
            for(int nei:g.adjList.get(i)){
                System.out.print(nei+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        ListMap l=new ListMap();
        l.addEdge(0,1);
        l.addEdge(1,2);
        l.display(3);
    }
}
