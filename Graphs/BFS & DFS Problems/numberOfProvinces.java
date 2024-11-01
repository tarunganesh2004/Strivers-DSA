import java.util.*;
class numberOfProvinces {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<Integer>());
        adj.get(0).add(0, 1);
        adj.get(0).add(1, 0);
        adj.get(0).add(2, 1);
        adj.add(new ArrayList<Integer>());
        adj.get(1).add(0, 0);
        adj.get(1).add(1, 1);
        adj.get(1).add(2, 0);
        adj.add(new ArrayList<Integer>());
        adj.get(2).add(0, 1);
        adj.get(2).add(1, 0);
        adj.get(2).add(2, 1);
        int r = noOfProvinces(adj, 3);
        System.out.println(r);
    }

    public static int noOfProvinces(ArrayList<ArrayList<Integer>> m, int v) {
        // convert adjacency matrix to adjacency list

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (m.get(i).get(j) == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int[] vis = new int[v];
        int c = 0;
        for (int i = 0; i < v; i++) {
            if (vis[i] == 0) {
                c++;
                dfs(i, adj, vis);
            }
        }
        return c;
    }

    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int vis[]) {
        vis[node] = 1;
        for (int i : adj.get(node)) {
            if (vis[i] == 0) {
                dfs(i, adj, vis);
            }
        }
    }
}