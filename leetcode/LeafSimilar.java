package leetcode;

import commonDataStructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilar {

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(8);
        System.out.println(leafSimilarTrees(root1, root2));
    }

    static boolean leafSimilarTrees(TreeNode root1, TreeNode root2) {
        if(root1==null || root2==null) return false;
        // process each tree and append it to a list
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        getLeafHelper(root1, l1);
        getLeafHelper(root2, l2);
        return l1.equals(l2);
    }

    static void getLeafHelper(TreeNode node, List<Integer> ll) {
        if(node == null) return;
        if(node.left==null && node.right==null)
            ll.add(node.val);
        getLeafHelper(node.left, ll);
        getLeafHelper(node.right, ll);
    }
}
