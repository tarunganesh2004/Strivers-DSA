// Bipartate graph means, we should it should be colored by two colors such that no two adjacent nodes should have same color.
// Any graph with odd length cycle can never be a bi-partate graph.
import java.util.*;
public class biPartateGraph {
    public static void main(String[] args) {
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        boolean r = isBP(4, adj);
        System.out.println(r);
    }

    public static boolean isBP(int v,ArrayList<ArrayList<Integer>> adj){
        int[] color=new int[v];
        Arrays.fill(color,-1);
        for(int i=0;i<v;i++){
            if(color[i]==-1){
                if(!checkUsingBFS(i,v,adj,color)){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean checkUsingBFS(int start,int v,ArrayList<ArrayList<Integer>> adj, int color[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        while (!q.isEmpty()) {
            int node = q.poll();

            for (int it : adj.get(node)) {
                // if the adjacent node is yet not colored
                // give the oppsite color of the node
                if (color[it] == -1) {
                    color[it] = 1 - color[node];
                }

                // if the adjacent node having the same color
                // someone did color it on some path
                else if (color[it] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}
