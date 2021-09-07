package leetcode;

import commonDataStructures.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
LC Hard : https://leetcode.com/problems/sum-of-distances-in-tree/
* **/
public class SumOfDistancesInTree {

    static int distance = 0;
    public static void main(String[] args) {
        int[][] edges = {{0,1}, {0,2}, {2,3}, {2,4}, {2,5}};
        System.out.println(Arrays.toString(sumOfDistancesInTree(6, edges)));
    }

    public static int[] sumOfDistancesInTree(int n, int[][] edges) {
        int[] res = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<n; i++) {
            adjList.add(new ArrayList<>()); // initialize graph
        }
        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int d = 0;
        for(int i = 0; i<n; i++) {
            for(int j = i+1; j<n; j++) {
                boolean[] visited = new boolean[n];
                dfs(adjList, i, j, visited);
            }
            res[i] = distance;
            distance = 0;
        }
        return res;
    }

    private static void dfs(List<List<Integer>> adjList, int s, int d, boolean[] visited) {
        visited[s] = true;
        if(s==d) {
            return;
        }
        for(int i : adjList.get(s)) {
            if(!visited[i]){
                distance++;
                dfs(adjList, i, d, visited);
            }
        }
    }
}
