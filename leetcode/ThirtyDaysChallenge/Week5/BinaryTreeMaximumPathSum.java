package leetcode.ThirtyDaysChallenge.Week5;

import commonDataStructures.TreeNode;

/**
 *
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes
 * from some starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the root.
 *
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 * */

public class BinaryTreeMaximumPathSum {

    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        maxPathSum(root);
        System.out.println(max);
    }

    public static int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        int leftMax = maxPathSum(root.left);
        int rightMax = maxPathSum(root.right);
        int tSum = leftMax+rightMax+root.val;

        int leftSum = leftMax+root.val;
        int rightSum = rightMax+root.val;

        int maxAtNode = Math.max(root.val, Math.max(leftSum, rightSum));
        max = Math.max(max, Math.max(tSum, maxAtNode));
        return maxAtNode;
    }
}
