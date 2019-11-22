package geeksforgeeks;

import commonDataStructures.GraphNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphTraversals {

    public static void main(String[] args) {

        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        GraphNode node5 = new GraphNode(5);

        node1.adjacencyList.add(node2);
        node1.adjacencyList.add(node3);
        node2.adjacencyList.add(node4);
        node4.adjacencyList.add(node5);
        node5.adjacencyList.add(node1);

        System.out.println(bfs(9, node1));
        System.out.println(dfs(9, node1));
    }

    public static boolean bfs(int data, GraphNode node) {
        if(node.data == data) return true;
        Queue<GraphNode> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()) {
            GraphNode g = q.poll();
            System.out.println("data each time  >  "+g.data);
            if(g.data == data) return true;
            for(int i = 0; i<g.adjacencyList.size(); i++) {
                q.offer(g.adjacencyList.get(i));
            }
        }
        return false;
    }

    public static boolean dfs(int data, GraphNode node) {
        if(node.data == data) return true;
        Stack<GraphNode> s = new Stack<>();
        s.push(node);
        while (!s.empty()) {
            GraphNode g = s.pop();
            System.out.println("data here ->  "+g.data);
            if(g.data == data) return true;
            for(int i = 0; i<g.adjacencyList.size(); i++) {
                s.push(g.adjacencyList.get(i));
            }
        }
        return false;
    }
}
