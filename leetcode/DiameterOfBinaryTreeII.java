package leetcode;

import commonDataStructures.TreeNode;

/**
 * LC Easy:  https://leetcode.com/problems/diameter-of-binary-tree/
 * **/
public class DiameterOfBinaryTreeII {

    static int ans=0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree(root));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return ans;
    }

    public static int height(TreeNode root) {
        if(root==null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        ans = Math.max(ans, lh+rh);
        return 1 + Math.max(lh, rh);
    }
}
