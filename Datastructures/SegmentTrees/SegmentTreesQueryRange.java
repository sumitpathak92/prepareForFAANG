package Datastructures.SegmentTrees;

/*
Implementation of Query Range Problem using a Segment Tree DATA STRUCTURE
* **/
public class SegmentTreesQueryRange {

    private static int[] A = {8, 2, 5, 1, 4, 5, 3, 9, 6, 10};
    private static int[] seg = new int[4*A.length]; // segment tree needs 4*N space if N is the size of original array
    public static void main(String[] args) {
        buildSegmentTrees(0, 0, 9);
        System.out.println(query(0, 0, 9, 3, 8));
    }

    private static void buildSegmentTrees(int ind, int low, int high) {
        if(low == high) {
            seg[ind] = A[low];
            return;
        }
        int mid = low+(high-low)/2;
        buildSegmentTrees(2*ind+1, low, mid);
        buildSegmentTrees(2*ind + 2, mid+1, high);

        seg[ind] = Math.max(seg[2*ind+1], seg[2*ind+2]);
    }

    private static int query(int ind, int low, int high, int l , int r) {
        if(low>=l && r>=high) // node range lies completely within asked query range
            return seg[ind];
        if(r<low || l>high) return Integer.MIN_VALUE; // node range doesn't lie at all in the query range
        // else if it overlaps return max(left, right) subtree range values
        int mid = low+(high-low)/2;
        return Math.max(query(2*ind+1, low, mid, l, r), query(2*ind+2, mid+1, high, l, r));
    }
}
