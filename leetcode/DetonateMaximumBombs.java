package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC Medium : https://leetcode.com/problems/detonate-the-maximum-bombs/
 * **/
public class DetonateMaximumBombs {

    public static void main(String[] args) {
        int[][] B = {{1,1,5}, {10, 10, 5}};
        System.out.println(maximumDetonation(B));
    }

    static int count=0;
    static int maxDet = Integer.MIN_VALUE;
    public static int maximumDetonation(int[][] A) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = A.length;
        boolean[] vis = new boolean[n];
        for(int i=0; i<n; i++) {
            adj.add(i, new ArrayList<>());
        }
        for(int i = 0; i<n; i++) {
            long x = A[i][0]; long y = A[i][1]; long r = A[i][2];
            for(int j = 0; j<n; j++) {
                int x1 = A[j][0]; int y1 = A[j][1]; int r1 = A[j][2];
                if(i!=j) {
                    if ((x - x1) * (x - x1) + (y - y1) * (y - y1) <= r * r) {
                        adj.get(i).add(j);
                    }
                }
            }
        }
        for(int i = 0; i<n; i++) {
            Arrays.fill(vis, false);
            maxDet = Math.max(maxDet, dfs(i, adj, vis));
        }
        return maxDet;
    }

    static int dfs(int i, List<List<Integer>> adj, boolean[] vis) {
        int count = 1;
        vis[i]=true;
        for(int n : adj.get(i)) {
            if(!vis[n]){
                count+=dfs(n, adj, vis);
            }
        }
        return count;
    }
}
