package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
LC Medium : https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
* **/
public class NumberOfConnectedComponents {

    public static void main(String[] args) {
        int[][] edges = {{0,1}, {1, 2}, {3, 4}};
        System.out.println(countComponents(5, edges));
    }

    public static int countComponents(int n, int[][] edges) {
        LinkedList[] graph = new LinkedList[n];
        for(int i=0; i<n ; i++){
            graph[i] = new LinkedList();
        }
        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i = 0; i<n; i++) {
            if(!visited[i]) {
                DFS(graph, i, visited);
                count ++;
            }
        }
        return count;
    }

    private static void DFS(LinkedList[] graph, int v, boolean[] visited) {
        visited[v] = true;
        LinkedList<Integer> ll = graph[v];
        while(!ll.isEmpty()) {
            int p = ll.pop();
            if(!visited[p]) {
                DFS(graph, p, visited);
            }
        }
    }
}
