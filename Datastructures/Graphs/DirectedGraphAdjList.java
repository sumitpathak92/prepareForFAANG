package Datastructures.Graphs;

import java.util.Arrays;
import java.util.LinkedList;

public class DirectedGraphAdjList {

    public static LinkedList[] adj;
    public static void main(String[] args) {
        int V = 5;
        adj = new LinkedList[V];
        for(int i = 0; i<V; i++) {
            adj[i] = new LinkedList(); // initializes adj list
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 2, 4);
        addEdge(adj, 4, 3);

        printGraph(adj);
    }

    static void addEdge(LinkedList<Integer> adj[], int u, int v) {
        adj[u].add(v);
    }

    static void printGraph(LinkedList<Integer> adj[]) {
        for(int i = 0; i<adj.length; i++) {
            System.out.println("adjacency list fo vertex ::::   "+i);
            System.out.println(Arrays.toString(adj[i].toArray()));
        }
    }
}
