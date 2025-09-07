//Create Graph using <List<List<Integer>> adjList=new ArrayList<>();

import java.util.*;
class G{
    List<List<Integer>> adjList;
    int numV;
    G(int numV){
        this.numV=numV;
        adjList=new ArrayList<>();
        for(int i=0;i<numV;i++){
            adjList.add(new ArrayList<>());
        }
    }
}
class Main{
    G g=new G(5);
    void addEdge(int src,int dest){
        g.adjList.get(src).add(dest);
        g.adjList.get(dest).add(src);
    }
    void display(int numV){
        for(int i=0;i<numV;i++){
            System.out.print(i+": ");
            for(int nei:g.adjList.get(i)){
                System.out.println(nei+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Main m=new Main();
        m.addEdge(0,1);
        m.display(4);
    }
}