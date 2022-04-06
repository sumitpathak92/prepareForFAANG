package leetcode;

import java.util.*;

/**
 *
 * LC Mediium : https://leetcode.com/problems/is-graph-bipartite/
 * **/
public class IsGraphBipartite {

    public static void main(String[] args) {
        int[][] G = {{1,2,3}, {0,2}, {0,1,3}, {0,2}};
        System.out.println(isBipartite(G));
    }

    public static boolean isBipartite(int[][] A) {
        int[] color = new int[A.length];
        Arrays.fill(color, -1);
        for(int j = 0; j<A.length; j++) {
            if(color[j]==-1 && !bfs(A, j, color))
                return false;
        }
        return true;
    }

    static boolean bfs(int[][] A, int node, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = 0;
        while(!q.isEmpty()) {
            int n = q.poll();
            for(int it : A[n]) {
                if(color[it]==color[n]) return false;
                if(color[it]==-1) {
                    color[it] = 1-color[n];
                    q.add(it);
                }
            }
        }
        return true;
    }
}
