package leetcode;

import commonDataStructures.TreeNode;

/**
 * LC Easy : https://leetcode.com/problems/balanced-binary-tree/
 * **/
public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(isBalanced(root));
    }

    public static boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int left = height(root.left);
        int right = height(root.right);
        return Math.abs(left - right)>1 && isBalanced(root.left) && isBalanced(root.right);
    }

    static int height(TreeNode root) {
        if(root==null) return -1;
        int lHeight = height(root.left);
        int rHeight = height(root.right);
        return 1+Math.max( lHeight, rHeight);
    }
}
