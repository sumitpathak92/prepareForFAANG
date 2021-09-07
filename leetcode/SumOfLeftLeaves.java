package leetcode;

import commonDataStructures.TreeNode;

/**
 *
 * LC Easy : https://leetcode.com/problems/sum-of-left-leaves/
 *
 * */
public class SumOfLeftLeaves {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(sumOfLeftLeaves(root));
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right ==null) return 0;

        int leftSum = sumHelper(root.left, true);
        int rightSum = sumHelper(root.right, false);
        return leftSum+rightSum;
    }

    public static int sumHelper(TreeNode node, boolean flag) {
        if(node == null) return 0;
        if(node.left==null && node.right == null && flag) return node.val;
        return sumHelper(node.left, true) + sumHelper(node.right, false);
    }
}
