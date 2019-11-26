/**
 * problem link --> https://leetcode.com/problems/minimum-time-visiting-all-points/
 * 1266. Minimum Time Visiting All Points
 *
 */

package leetcode;

public class MinimumTimeVisitingAllPoints {

    static int[][] points = {{3, 2}, {-2, 2}};

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minTimeToVisitAllPoints(points));
    }

    static class Solution {
        public int minTimeToVisitAllPoints(int[][] points) {
            int output = 0, n = points.length;
            for (int i = 0; i < n-1; i++) {
                int X = Math.abs(points[i+1][0] - points[i][0]);
                int Y = Math.abs(points[i+1][1] - points[i][1]);
                output += Math.min(X, Y) + Math.abs(X - Y);
            }
            return output;
        }
    }
}
