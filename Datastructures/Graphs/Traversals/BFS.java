package Datastructures.Graphs.Traversals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS {


    public static void main(String[] args) {
        Graph graph = new Graph(5);

        // add edges to the graph
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);

        // perform BFS traversal
//        graph.BFS(2);

        // perform DFS traversal
        graph.DFS(0);
    }
}

class Graph {

    private int V;
    private LinkedList<Integer> adj[];
    private boolean visited[];

    public Graph(int v) {
        this.V = v;
        adj = new LinkedList[this.V];
        visited = new boolean[this.V];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
            visited[i] = false;
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public void printGraph() {
        for(int i = 0; i<adj.length; i++) {
            System.out.println("adjacency list for vertex :::::   "+i);
            System.out.println(Arrays.toString(adj[i].toArray()));
        }
    }

    public void BFS(int s) { // start Breadth First Search from start node 's'
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        visited[s] = true;
        System.out.println("printing BFS traversal :::::  ");
        System.out.println("Starting at source ::::: "+ s + " ");
        while(!q.isEmpty()) {
            int el = q.poll();
            System.out.print(el + " ");
            //process all neighbors of el
            LinkedList<Integer> neig = adj[el];
            while(!neig.isEmpty()) {
                int c = neig.poll();
                if(!visited[c]) {
                    q.offer(c);
                    visited[c]=true;
                }
            }
        }
    }

    public void DFS(int s) {
        Stack<Integer> st = new Stack<>();
        st.push(s);
        visited[s] = true;
        System.out.println("printing DFS traversal :::::  ");
        while(!st.isEmpty()) {
            int el = st.peek();
            st.pop();
            if(!visited[el]) {
                visited[el] = true;
                System.out.println(el + " ");
            }
            LinkedList<Integer> neig = adj[el];
            while(!neig.isEmpty()) {
                int c = neig.poll();
                if(!visited[c]) {
                    st.push(c);
                }
            }
        }
    }

}

