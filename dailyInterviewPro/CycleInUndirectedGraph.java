package dailyInterviewPro;

import commonDataStructures.Graph;

public class CycleInUndirectedGraph {

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        System.out.println(g.detectCycle(0));
    }


}
