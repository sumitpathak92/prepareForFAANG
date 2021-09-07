package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * LC Medium : https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1392/
 * */
public class CloneGraph {

    public static void main(String[] args) {

    }

    public GraphNode cloneGraph(GraphNode node) {
        return null;
    }
}

// Definition for a Node.
class GraphNode {
    public int val;
    public List<GraphNode> neighbors;
    public GraphNode() {
        val = 0;
        neighbors = new ArrayList<GraphNode>();
    }
    public GraphNode(int _val) {
        val = _val;
        neighbors = new ArrayList<GraphNode>();
    }
    public GraphNode(int _val, ArrayList<GraphNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

