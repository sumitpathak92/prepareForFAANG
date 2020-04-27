package leetcode.ThirtyDaysChallenge.Week2;


import commonDataStructures.TreeNode;

/**
 *
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * */

public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println("output diameter "+diameterOfBinaryTree(root));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        return getDiameter(root)-1;
    }

    public static int getDiameter(TreeNode root) {
        if(root==null) return 0;
        return Math.max(getHeightOfTree(root.left)+getHeightOfTree(root.right)+1, Math.max(getDiameter(root.left), getDiameter(root.right)));
    }

    public static int getHeightOfTree(TreeNode node) {
        if(node==null) return 0;
        return 1+ Math.max(getHeightOfTree(node.left), getHeightOfTree(node.right));
    }
}
