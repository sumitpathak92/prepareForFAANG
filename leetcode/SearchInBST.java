package leetcode;

import commonDataStructures.TreeNode;

/**
 * LC Medium : https://leetcode.com/explore/featured/card/recursion-i/251/scenario-i-recurrence-relation/3233/
 * */
public class SearchInBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(searchBST(root, 2).right.val);
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;

        if(root.val > val) {
            return searchBST(root.left, val);
        }
        return searchBST(root.right, val);
    }
}
