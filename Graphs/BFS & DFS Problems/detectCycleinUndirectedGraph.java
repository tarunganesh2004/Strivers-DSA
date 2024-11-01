import java.util.*;

class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class DetectCycleInUndirectedGraph {
    public static void main(String[] args) {
        int v = 5; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);

        // Initialize adjacency list
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges (undirected)
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 0);

        System.out.println(isCycle(v, adj)); // Output: true
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static boolean checkForCycle(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[src] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, -1));

        while (!q.isEmpty()) {
            int node = q.peek().first;
            int parent = q.peek().second;
            q.poll();

            for (Integer it : adj.get(node)) {
                if (!vis[it]) {
                    vis[it] = true;
                    q.add(new Pair(it, node));
                } else if (parent != it) {
                    return true; // Cycle detected
                }
            }
        }
        return false;
    }

    public static boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                if (checkForCycle(i, adj, vis)) {
                    return true;
                }
            }
        }
        return false;
    }


    // Time complexity: O(V + 2E)
    // Space complexity: O(V)

    // now using dfs

    public static boolean checkForCycleDFS(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                if (checkForCycleDFS(it, node, adj, vis)) {
                    return true;
                }
            } else if (it != parent) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCycleDFS(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                if (checkForCycleDFS(i, -1, adj, vis)) {
                    return true;
                }
            }
        }
        return false;
    }
}
