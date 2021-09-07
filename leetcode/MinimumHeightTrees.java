package leetcode;

import java.util.*;

/*
LC Medium : https://leetcode.com/problems/minimum-height-trees/
* **/
public class MinimumHeightTrees {

    static int h = 0;
    public static void main(String[] args) {
        int[][] edges = {{1,0},{1,2},{1,3}};

//        int[][] edges = {{3,0}, {3,1}, {3,2}, {3,4}, {5,4}};
        System.out.println(findMinHeightTrees(4, edges));
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        LinkedList[] adjList = new LinkedList[n];
        int[] in = new int[n];
        for(int i =0; i<n; i++) {
            adjList[i] = new LinkedList();
        }
        for(int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
            in[edge[0]]++;
            in[edge[1]]++;
        }
        System.out.println("inbound ::::   "+Arrays.toString(in));
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i<n; i++) {
            boolean[] visited = new boolean[n];
            visited[i] = true;
            DFS(adjList, i, visited, in, 0);
            hm.put(i, h);
        }
        List<Integer> res = new ArrayList<>();
        for(int i= 0; i<n; i++) {
            System.out.println("printing hashmap values :::   "+hm.get(i));
            if(hm.get(i)<=min) {
                min = hm.get(i);
                res.add(i);
            }
        }
        return res;
    }

    private static void DFS(LinkedList[] graph, int s, boolean[] visited, int[] in, int height) {
        LinkedList<Integer> ll = graph[s];
        System.out.println("adj list ::::  "+ll);
        while(!ll.isEmpty()) {
            int p = ll.pop();
            if(!visited[p]) {
                if(in[p]==1){
                    h=height+1;
                    break;
                } else {
                    height++;
                    visited[p] = true;
                    DFS(graph, p, visited, in,height);
                }
            }
        }
    }
}
