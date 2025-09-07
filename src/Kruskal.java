import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
    static class Edge {
        int s, d, w;
        public Edge(int s, int d, int w) {
            this.s = s;
            this.d = d;
            this.w = w;
        }
    }

    // Made static so that it can be used within static methods
    static class Disjoint {
        int[] par, rank;
        public Disjoint(int n) {
            par = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                par[i] = i;
                rank[i] = 0;
            }
        }
        public int find(int i) {
            if (par[i] != i) {
                par[i] = find(par[i]);
            }
            return par[i];
        }
        public void union(int x, int y) {
            int r1 = find(x);
            int r2 = find(y);
            if (r1 != r2) {
                if (rank[r1] > rank[r2]) {
                    par[r2] = r1;
                } else if (rank[r1] < rank[r2]) {
                    par[r1] = r2;
                } else {
                    par[r2] = r1;
                    rank[r1]++;
                }
            }
        }
    }

    public static List<Edge> kruskal(int n, List<Edge> edges) {
        // Sort all edges in non-decreasing order of weight
        edges.sort(Comparator.comparingInt(e -> e.w));

        // Instance of Disjoint set
        Disjoint ds = new Disjoint(n);

        List<Edge> mst = new ArrayList<>();

        // Process each edge in sorted order
        for (Edge e : edges) {
            int setU = ds.find(e.s);
            int setV = ds.find(e.d);
            // If including this edge doesn't form a cycle, add it to the MST
            if (setU != setV) {
                mst.add(e);
                ds.union(e.s, e.d);
            }
        }
        return mst;
    }

    public static void main(String[] args) {
        int n = 4; // Number of vertices
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        List<Edge> mst = kruskal(n, edges);
        System.out.println("Edges in the MST:");
        int count=0;
        for (Edge edge : mst) {
            System.out.println(edge.s + " -- " + edge.d + " == " + edge.w);
            count=count+edge.w;
        }
        System.out.println(count);
    }
}
