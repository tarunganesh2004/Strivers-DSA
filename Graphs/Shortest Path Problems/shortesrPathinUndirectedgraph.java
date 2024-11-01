import java.util.*;

class ShortestPath {
    public static void main(String[] args) {
        int n = 9; // Number of nodes
        int m = 10; // Number of edges
        int[][] edges = new int[][] {
                { 0, 1 }, { 0, 3 }, { 3, 4 }, { 4, 5 },
                { 5, 6 }, { 1, 2 }, { 2, 6 }, { 6, 7 }, { 7, 8 },
                { 6, 8 }
        };
        int src = 0; // Source node
        int[] dist = shortest(edges, n, m, src);
        for (int i = 0; i < n; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    public static int[] shortest(int[][] edges, int n, int m, int src) {
        // Create an adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]); // Undirected graph
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE); // Initialize distances to infinity
        dist[src] = 0; // Distance to source is 0

        Queue<Integer> q = new LinkedList<>();
        q.add(src); // Start BFS from the source

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int neighbor : adj.get(cur)) {
                if (dist[neighbor] > dist[cur] + 1) {
                    dist[neighbor] = dist[cur] + 1; // Update distance
                    q.add(neighbor); // Add neighbor to the queue
                }
            }
        }

        // Replace unreachable nodes' distances with -1
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        return dist;
    }
}
