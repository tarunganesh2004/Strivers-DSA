import java.util.*;

public class bfs {
    public static void addEdge(ArrayList<ArrayList<Integer>> adjList, int u, int v) {
        // Add edge u-v and v-u for an undirected graph
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        int v = 10; // Number of vertices
        // Initialize adjacency list
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add edges
        addEdge(adjList, 0, 1); // A - B
        addEdge(adjList, 0, 2); // A - C
        addEdge(adjList, 0, 3); // A - D
        addEdge(adjList, 1, 4); // B - E
        addEdge(adjList, 2, 4); // C - F
        addEdge(adjList, 3, 4); // D - G
        addEdge(adjList, 3, 5); // D - F
        addEdge(adjList, 4, 5); // E - F
        addEdge(adjList, 5, 6); // F - G
        addEdge(adjList, 6, 7); // G - I
        addEdge(adjList, 6, 8); // G - J
        addEdge(adjList, 7, 9); // E - H

        // Perform BFS starting from vertex 3 (D)
        bfsGraph(v, adjList, 0);
        // System.out.println(adjList);

        int v1=6;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            res.add(new ArrayList<>());
        }

        res.get(0).add(1);
        res.get(1).add(0);
        res.get(1).add(2);
        res.get(2).add(1);
        res.get(2).add(3);
        res.get(3).add(2);
        res.get(4).add(5);
        res.get(5).add(4);
        System.out.println();
        anotherbs(v1, res);
    }

    public static void bfsGraph(int v, ArrayList<ArrayList<Integer>> adjList, int start) {
        boolean[] vis = new boolean[v];
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        vis[start] = true;

        System.out.println("BFS starting from vertex " + (char) ('A' + start) + ":");
        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print((char) ('A' + node) + " ");

            // Traverse neighbors of the current node
            for (int neighbour : adjList.get(node)) {
                if (!vis[neighbour]) {
                    q.add(neighbour);
                    vis[neighbour] = true;
                }
            }
        }
    }

    public static void anotherbs(int v, ArrayList<ArrayList<Integer>> adjList) {
        boolean[] vis = new boolean[v];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                q.add(i);
                vis[i] = true;

                while (!q.isEmpty()) {
                    int node = q.poll();
                    System.out.print(node+ " ");
                    
                    for (int nei : adjList.get(node)) {
                        if (!vis[nei]) {
                            q.add(nei);
                            vis[nei] = true;
                        }

                    }
                }
            }
        }
    }
}
