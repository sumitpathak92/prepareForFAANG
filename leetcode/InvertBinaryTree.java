package leetcode;


import commonDataStructures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC Easy: https://leetcode.com/problems/invert-binary-tree/
 * **/
public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        System.out.println(invertTree(root).left.right.val);

    }

    public static TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr.left!=null) q.offer(curr.left);
            if(curr.right!=null) q.offer(curr.right);
            TreeNode tmp = curr.left;
            curr.left = curr.right;
            curr.right = tmp;

        }

        return root;
    }
}
