package commonDataStructures;

import java.util.LinkedList;
import java.util.List;

public class GraphNode {

    public int data;
    public List<GraphNode> adjacencyList;

    public GraphNode(int data) {
        this.data = data;
        adjacencyList = new LinkedList<>();
    }

}
