import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Scanner;

class graphRepresentation {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);

        // 1. using adjacency matrix
        // int n = 3, m = 3; // vertices 1 based indexing
        // int[][] adjMatrix = new int[n + 1][n + 1];

        // edge 1-->2
        // adjMatrix[1][2] = 1;
        // adjMatrix[2][1] = 1; // undirected graph

        // edge 2-->3
        // adjMatrix[2][3] = 1;
        // adjMatrix[3][2] = 1;

        // edge 1-->3
        // adjMatrix[1][3] = 1;
        // adjMatrix[3][1] = 1;
        // System.out.println(Arrays.deepToString(adjMatrix));
        // this takes more space than adjacency list
        // so we use adjacency list

        // 2. using adjacency list

        int n = 3;
        // m = 3; // vertices 1 based indexing
        // array of linked list

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        // 1 based indexing(n+1)
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        // edge 1-->2
        adjList.get(1).add(2);
        adjList.get(2).add(1);

        // edge 2-->3
        adjList.get(2).add(3);
        adjList.get(3).add(2);

        // edge 1-->3
        adjList.get(1).add(3);
        adjList.get(3).add(1);

        // System.out.println(adjList);
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }

        // 3. weighted graph
        weightedGraph();
    }
    
    public static void weightedGraph() {
        int n = 3;
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        // 1 based indexing(n+1)
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        // edge 1-->2 with weight 3
        adjList.get(1).add(new int[] { 2, 3 });
        adjList.get(2).add(new int[] { 1, 3 });

        // edge 2-->3 with weight 4
        adjList.get(2).add(new int[] { 3, 4 });
        adjList.get(3).add(new int[] { 2, 4 });

        // edge 1-->3 with weight 5
        adjList.get(1).add(new int[] { 3, 5 });
        adjList.get(3).add(new int[] { 1, 5 });

        // Display the weighted adjacency list with source, destination, and weight
        System.out.println("Source Destination Weight");
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < adjList.get(i).size(); j++) {
                int dest = adjList.get(i).get(j)[0];
                int weight = adjList.get(i).get(j)[1];
                System.out.println(i + " " + dest + " " + weight);
            }
        }
    }
    
}