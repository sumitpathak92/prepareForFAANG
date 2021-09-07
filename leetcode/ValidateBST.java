package leetcode;


import commonDataStructures.TreeNode;

/**
 *  LC Medium : https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2874/
 * */

public class ValidateBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(9);

        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBSTUtil(TreeNode root, long min, long max) {
        if(root == null) return true;
        if(root.val <= min) return false;
        if(root.val >= max) return false;
        return isValidBSTUtil(root.left, min, root.val) && isValidBSTUtil(root.right, root.val, max);
    }
}
