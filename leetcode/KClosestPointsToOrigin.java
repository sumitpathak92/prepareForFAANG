package leetcode;

import java.util.*;

/**
 *
 * Problem Statement :
 *
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 *
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 *
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 *
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 *
 *
 * */

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        int[][] points = {{0,1}, {1,0}};
        for(int[] i : kClosest(points, 2)) {
            System.out.println("output  "+Arrays.toString(i));
        }
    }

    public static class Pair{
        int[] a = new int[2];
        int d;
        Pair(int x, int y, int d) {
            a[0] = x;
            a[1] = y;
            this.d = d;
        }
    }

    public static class PriorityComparator implements Comparator<Pair> {
        public int compare(Pair first, Pair second) {
            return second.d - first.d;
        }
    }

    public static int[][] kClosest(int[][] points, int k) {
        PriorityComparator pc = new PriorityComparator();
        PriorityQueue<Pair> pq = new PriorityQueue<>(k+1, pc);
        for(int[] p : points) {
            int x = p[0]; int y = p[1];
            int d = (int) getEuclideanDistance(p[0], p[1]);

            pq.add(new Pair(x, y, d));
            if(pq.size()>k) pq.poll();
        }
        int[][] res = new int[k][2];
        int i=0;
        while(!pq.isEmpty()) {
            Pair s = pq.poll();
            res[i][0] = s.a[0];
            res[i][1] = s.a[1];
            i++;
        }
        return res;
    }

    public static double getEuclideanDistance(int x, int y) {
        return Math.pow(x,2)+Math.pow(y,2);
    }
}
