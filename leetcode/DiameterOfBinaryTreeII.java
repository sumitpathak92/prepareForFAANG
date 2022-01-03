package leetcode;

import commonDataStructures.TreeNode;

/**
 * LC Easy:  https://leetcode.com/problems/diameter-of-binary-tree/
 * **/
public class DiameterOfBinaryTreeII {

    static int ans=Integer.MIN_VALUE;
    public static void main(String[] args) {

    }

    public static int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return ans;
    }

    public static int height(TreeNode root) {
        if(root==null) return 0;
        int lheight = height(root.left);
        int rHeight = height(root.right);

        ans = Math.max(lheight+rHeight+2, ans); // for this node this is the answer

        // return height of the tree
        return 1+Math.max(lheight, rHeight);
    }
}
