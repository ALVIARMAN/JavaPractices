import java.util.*;

class Edge implements Comparable<Edge> {
    int source;
    int target;
    int weight;

    Edge(int source, int target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    // Sort edges by weight (for priority queue)
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

public class Prims {

    public static int prims(List<List<Edge>> graph, int start) {
        int n = graph.size();
        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int totalCost = 0;

        // Start with all edges from the start node
        visited[start] = true;
        pq.addAll(graph.get(start));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (visited[edge.target]) continue;

            visited[edge.target] = true;
            totalCost += edge.weight;

            // Add all edges from the newly visited node
            for (Edge next : graph.get(edge.target)) {
                if (!visited[next.target]) {
                    pq.add(next);
                }
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Undirected graph: add edges in both directions
        graph.get(0).add(new Edge(0, 1, 2));
        graph.get(1).add(new Edge(1, 0, 2));

        graph.get(0).add(new Edge(0, 3, 6));
        graph.get(3).add(new Edge(3, 0, 6));

        graph.get(1).add(new Edge(1, 2, 3));
        graph.get(2).add(new Edge(2, 1, 3));

        graph.get(1).add(new Edge(1, 3, 8));
        graph.get(3).add(new Edge(3, 1, 8));

        graph.get(1).add(new Edge(1, 4, 5));
        graph.get(4).add(new Edge(4, 1, 5));

        graph.get(2).add(new Edge(2, 4, 7));
        graph.get(4).add(new Edge(4, 2, 7));

        graph.get(3).add(new Edge(3, 4, 9));
        graph.get(4).add(new Edge(4, 3, 9));

        int mstCost = prims(graph, 0);
        System.out.println("Total cost of Minimum Spanning Tree: " + mstCost);
    }
}
