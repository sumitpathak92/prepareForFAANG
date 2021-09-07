package leetcode;

import java.util.LinkedList;

/*
LC Easy : https://leetcode.com/problems/find-if-path-exists-in-graph/
* **/
public class FindPathExistsInGraph {

    static boolean isFound;
    public static void main(String[] args) {
        int[][] edges = {{0,1}, {0,2}, {3,5}, {5,4}, {4,3}};
        int start = 0; int end = 5;
        System.out.println(validPath(6, edges, start, end));
    }

    public static boolean validPath(int n, int[][] edges, int start, int end) {
        isFound = false;
        if(start==end) return true;
        LinkedList[] graph = new LinkedList[n];
        for(int i = 0; i<n; i++) {
            graph[i] = new LinkedList<Integer>();
        }
        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
            if(graph[start].contains(end)) return true;
        }
        boolean[] visited = new boolean[n];
        DFS(graph, start, end, visited);
        return isFound;
    }

    private static void DFS(LinkedList[] graph, int s, int d, boolean[] visited) {
        visited[s] = true;
        LinkedList<Integer> ll = graph[s];
        while(!ll.isEmpty()) {
            int n = ll.pop();
            if(n == d) {
                isFound = true;
                break;
            }
            if(!visited[n]) {
                DFS(graph, n, d, visited);
            }
        }
    }
}
