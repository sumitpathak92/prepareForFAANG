package Datastructures.Graphs;


import java.util.*;

// Kahn's Algorithm for doing topological sort
// Using the same algorithm we will try to find the topological sort for a graph, and if by any chance we cannot generate
// the same, we can conclude that there is a cycle in the graph(Because topo sort is only possible for a DAG)
public class CycleDetectionDirectedGraphBFS {

    public static void main(String[] args) {
        int N = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<N; i++) {
            adj.add(i, new ArrayList<>());
        }
        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        System.out.println(isCyclicBFS(N, adj));
    }

    static boolean isCyclicBFS(int N, ArrayList<ArrayList<Integer>> adj) {
        int[] topo = new int[N];
        int[] indegree = new int[N];
        for(int i = 0; i<N; i++) {
            for (int neigh : adj.get(i)) {
                indegree[neigh]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<N; i++) {
            if(indegree[i]==0) q.add(i);
        }
        int i = 0;
        int count = 0;
        while(!q.isEmpty()) {
            Integer node = q.poll();
            topo[i++] = node;
            count++;
            for(int neigh : adj.get(node)) {
                indegree[neigh]--;
                if(indegree[neigh]==0)
                    q.add(neigh);
            }
        }
        System.out.println("Topo sort order :::   "+ Arrays.toString(topo));
        return count != N;
    }
}
