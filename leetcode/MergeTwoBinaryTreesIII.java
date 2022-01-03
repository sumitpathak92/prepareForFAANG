package leetcode;

import commonDataStructures.TreeNode;

/**
 *
 * LC Easy: https://leetcode.com/problems/merge-two-binary-trees/
 * **/
public class MergeTwoBinaryTreesIII {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        System.out.println(mergeTress(root1, root2).left.val);
    }

    public static TreeNode mergeTress(TreeNode root1, TreeNode root2) {
        if(root1==null) return root2;
        if(root2==null) return root1;
        TreeNode root = new TreeNode(root1.val+ root2.val);
        root.left = mergeTress(root1.left, root2.left);
        root.right = mergeTress(root1.right, root2.right);
        return root;
    }
}
