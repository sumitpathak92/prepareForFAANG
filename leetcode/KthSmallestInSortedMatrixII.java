package leetcode;


import java.util.PriorityQueue;

/**
 * LC Medium : https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * **/
public class KthSmallestInSortedMatrixII {

    public static void main(String[] args) {
        int [][] inp = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(kthSmallest(inp, 8));
    }

    public static int kthSmallest(int[][] matrix,int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        for(int i = 0; i<matrix.length; i++) {
            for(int j = 0; j<matrix.length; j++) {
                pq.add(matrix[i][j]);
                if(pq.size()>k) {
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}
