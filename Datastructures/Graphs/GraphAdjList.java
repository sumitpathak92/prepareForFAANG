package Datastructures.Graphs;

import java.util.ArrayList;


public class GraphAdjList {

    // adds edge to an undirected graph
    static void addEdge(ArrayList<ArrayList<Integer>> adjList, int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    static void printGraph(ArrayList<ArrayList<Integer>> adjList) {
        for(int i = 0; i<adjList.size(); i++) {
            System.out.println("Adjacency list of vertex :::  "+i);
            System.out.println(i + " ");
            for(int j=0; j<adjList.get(i).size(); j++) {
                System.out.println("-> "+adjList.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(V);
        for(int i = 0; i<V; i++) {
            graph.add(new ArrayList<>());
        }
        addEdge(graph, 4, 1);
        addEdge(graph, 0, 4);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);

        printGraph(graph);
    }
}
