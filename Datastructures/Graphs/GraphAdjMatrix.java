package Datastructures.Graphs;


// Adjacency matrix representation of Graph
public class GraphAdjMatrix {

    public static void main(String[] args) {
        int V= 5;
        int[][] adjMatrix = new int[V][V];

        // add edges to graph
        addEdge(adjMatrix, 0, 1);
        addEdge(adjMatrix, 0, 4);
        addEdge(adjMatrix, 1, 2);
        addEdge(adjMatrix, 1, 3);
        addEdge(adjMatrix, 1, 4);
        addEdge(adjMatrix, 2, 3);
        addEdge(adjMatrix, 3,4);

        printGraph(adjMatrix);
    }

    // adds edge data into 2-d matrix
    static void addEdge(int[][] adjMatrix, int u, int v) {
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
    }

    static void printGraph(int[][] adjMatrix) {
        for(int i = 0; i<adjMatrix.length; i++) {
            System.out.println("printing for vertex :::   "+i);
            for(int j = 0; j<adjMatrix[i].length; j++) {
                if(adjMatrix[i][j] == 1) {
                    System.out.println(" -> "+j);
                }
            }
            System.out.println();
        }
    }

}
