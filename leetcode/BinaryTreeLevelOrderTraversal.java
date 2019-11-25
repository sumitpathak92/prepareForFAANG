package leetcode;

import commonDataStructures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(" \n");
        printNodesOnEachLevel(root);
    }

    static void printNodesOnEachLevel(TreeNode root) {
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(true) {
            int count = queue.size();
            if(count == 0) break;
            while(count>0) {
                TreeNode curr = queue.peek();
                System.out.print(curr.val + " ");
                queue.remove();
                if(curr.left!=null) queue.add(curr.left);
                if(curr.right!=null) queue.add(curr.right);
                count--;
            }
            System.out.println();
        }
    }
}
