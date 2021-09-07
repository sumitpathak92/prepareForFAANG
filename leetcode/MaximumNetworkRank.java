package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
LC Medium : https://leetcode.com/problems/maximal-network-rank/
* **/
public class MaximumNetworkRank {

    public static void main(String[] args) {
        int[][] roads = {{0,1}, {1, 2}, {2,3}, {2,4}, {5,6}, {5,7}};
        System.out.println(maximalNetworkRank(8, roads));
    }

    public static int maximalNetworkRank(int n, int[][] roads) {
        int[] inDegree = new int[n];
        boolean[][] connected = new boolean[n][n];
        for(int[] road : roads) {
            inDegree[road[0]]++;
            inDegree[road[1]]++;
            connected[road[0]][road[1]] = true;
            connected[road[1]][road[0]] = true;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++) {
            for(int j = i+1; j<n ; j++) {
                int total = inDegree[i]+inDegree[j];

                if(connected[i][j] && connected[j][i]) {
                    total--;
                }
                if(total > max) max = total;
            }
        }
        return max;

    }
}
