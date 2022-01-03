package Datastructures.SegmentTrees;

/*
In this problem we are trying to get range sum in an array using a segment Tree, the implementation is pretty similar to
getting range query problem.

* **/
public class SegmentTreeRangeSum {

    static int[] A = {2, 3, 1, 21, 9, 4, 12, 9, 8, 33};
    static int[] seg = new int[4* A.length];

    public static void main(String[] args) {

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

    private static void pointUpdate(int ind, int left, int right, int node, int val) {
        if(left == right) {
            seg[left] += val;
        } else {
            int mid = left+(right-left)/2;
            if(node<=mid && node>=left) pointUpdate(2*ind+1, left, mid, node, val);
            else pointUpdate(2*ind+2, mid+1, right, node, val);

            seg[ind] = seg[2*ind+1] + seg[2*ind+2];
        }
    }
    private static int query(int ind, int left, int right, int l, int r) {
        // TODO
        return -1;
    }
}
