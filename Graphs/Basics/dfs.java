import java.util.*;

public class dfs {
    public static void addEdge(ArrayList<ArrayList<Integer>> l, int u, int v) {
        l.get(u).add(v);
        l.get(v).add(u);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> l = new ArrayList<>();
        int v = 8;
        for (int i = 0; i < v+1; i++) {
            l.add(new ArrayList<>());
        }

        addEdge(l, 1, 2);
        addEdge(l, 1, 3);
        addEdge(l, 2, 5);
        addEdge(l, 2, 6);
        addEdge(l, 3, 4);
        addEdge(l, 3, 7);
        addEdge(l, 4, 8);
        addEdge(l, 7, 8);
        // // System.out.println(l);
        // for (int i = 1; i <= v; i++) { // Loop starts from 1 for 1-based indexing
        //     System.out.print(i + ": ");
        //     for (int j : l.get(i)) {
        //         System.out.print(j + " ");
        //     }
        //     System.out.println();
        // }
    dfsOfGraph(v, l);
    }
    
    public static void dfsTraversal(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls) {
        vis[node] = true;
        ls.add(node);
        for (int it : adj.get(node)) {
            if (vis[it] == false) {
                dfsTraversal(it, vis, adj, ls);
            }
        }
    }

    public static void dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[v + 1];
        vis[1] = true; // 1 based indexing
        ArrayList<Integer> ls = new ArrayList<>();
        dfsTraversal(1, vis, adj, ls);
        // return ls;

        for (int i : ls) {
            System.out.print(i+" ");
        }
    }
}
