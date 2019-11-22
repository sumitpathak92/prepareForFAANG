package leetcode;

import commonDataStructures.TreeNode;

public class RangeSumBST {

    public static void main(String[] args) {
        System.out.println(rangeSumBST(new TreeNode(3), 1, 4));
    }

    private static int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        if(root==null) return 0;
        if(L<=root.val && R>=root.val) sum += root.val;
        if(L<root.val) sum+=rangeSumBST(root.left, L, R);
        if(R>root.val) sum+=rangeSumBST(root.right, L, R);
        return sum;
    }
}
