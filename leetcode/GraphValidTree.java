package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * LC Medium : https://leetcode.com/problems/graph-valid-tree/
 *
 * */
public class GraphValidTree {

    public static void main(String[] args) {
        int[][] edges = {{0,1}, {2,3}};
        int n = 4;
        System.out.println(validTree(n, edges));
    }

    public static boolean validTree(int n, int[][] edges) {
        int[][] adjList = new int[n][n];
        boolean[] visited = new boolean[n];
        for(int[] edge : edges) {
            adjList[edge[0]][edge[1]] = 1;
            adjList[edge[1]][edge[0]] = 1;
        }
        System.out.println(Arrays.deepToString(adjList));
        boolean res = bfs(0, adjList, visited, n);
        System.out.println(Arrays.toString(visited));
        return res && areAllTrue(visited);
    }

    public static boolean bfs(int source, int[][] adjList, boolean[] visited, int n) {
        Queue<Pair1> q = new LinkedList<>();
        q.offer(new Pair1(source, source));
        visited[source] = true;
        while(!q.isEmpty()) {
            Pair1 tmp = q.poll();
            for(int i = 0; i<n; i++) {
                if(adjList[tmp.vertex][i] == 1) {
                    if(!visited[i]) {
                        visited[i] = true;
                        q.add(new Pair1(i, tmp.vertex));
                    }
                    else if(visited[i] && i!=tmp.parent) return false; // we found a cycle
                }
            }
        }
        return true;
    }

    public static boolean areAllTrue(boolean[] array)
    {
        for(boolean b : array) if(!b) return false;
        return true;
    }

}

class Pair1 {
    int vertex;
    int parent;

    Pair1(int v, int p) {
        this.vertex = v;
        this.parent = p;
    }
}
