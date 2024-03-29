package leetcode;

import java.util.*;

/**
 * LC Medium : https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1392/
 * */
public class CloneGraph {

    public static void main(String[] args) {

    }

    public GraphNode cloneGraph(GraphNode node) {
        if(node==null) return node;

        HashMap<GraphNode, GraphNode> map = new HashMap<>();
        LinkedList<GraphNode> q = new LinkedList<>();
        q.add(node);
        map.put(node, new GraphNode(node.val, new ArrayList<>()));
        while(!q.isEmpty()) {
            GraphNode tmp = q.remove();
            for(GraphNode neighbour : tmp.neighbors) {
                if(!map.containsKey(neighbour)) {
                    map.put(neighbour, new GraphNode(neighbour.val, new ArrayList<>()));
                    q.add(neighbour);
                }
                map.get(tmp).neighbors.add(map.get(neighbour));
            }
        }
        return map.get(node);
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

