package commonAlgorithms.Graph;

import commonDataStructures.ListNode;

import java.util.*;

/**
 * Simple demonstration of Topological sorting algorithm using DFS and BFS(Kahn's) algorithm
 * */
public class TopologicalSort {

    private static Stack<Integer> st = new Stack<>();
    private static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) {
        int[][] edges = {{5, 0}, {5, 2}, {2, 3}, {3, 1}, {4, 0}, {4, 1}};
        topologicalSort(6, edges);
        topologicalSortBFS(6, edges);
    }

    private static void topologicalSort(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>(n);
        for(int i =0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
        }
        System.out.println(adjList);
        boolean[] visited = new boolean[n];
        for(int i =0; i<n; i++) {
            if(!visited[i]) {
                dfs(i, adjList, visited);
            }
        }
        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }
    }

    private static void dfs(int i, List<List<Integer>> adjList, boolean[] visited) {
        visited[i] = true;
        for(Integer el : adjList.get(i)) {
            if(!visited[el])
                dfs(el, adjList, visited);
        }
        st.push(i);
    }

    private static void topologicalSortBFS(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>(n);
        int[] inDegree = new int[n];
        for(int i =0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<n; i++) {
            if(inDegree[i] == 0) q.add(i);
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()) {
            int p = q.poll();
            res.add(p);
            for(Integer i : adjList.get(p)) {
                if(inDegree[i]>0) inDegree[i]--;
                if(inDegree[i] == 0) q.add(i);
            }
        }
        System.out.println(res);
    }
}
