package geeksforgeeks;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSorting {

    public static void main(String[] args) {

    }

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        for(int i = 0; i<V; i++) {
            if(!visited[i]) {
                performDFS(i, visited, adj, st);
            }
        }
        int[] res = new int[V];
        int i = 0;
        while(!st.isEmpty()) {
            res[i++] = st.pop();
        }
        return res;
    }

    private static void performDFS(int i, boolean[] visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        visited[i] = true;
        for(Integer it : adj.get(i)) {
            if(!visited[it]) {
                performDFS(it, visited, adj, st);
            }
        }
        st.push(i);
    }
}
