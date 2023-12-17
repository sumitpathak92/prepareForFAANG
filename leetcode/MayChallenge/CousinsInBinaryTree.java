package leetcode.MayChallenge;

import commonDataStructures.TreeNode;

public class CousinsInBinaryTree {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.left.right.right = new TreeNode(15);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        tree.right.left.right = new TreeNode(8);

        TreeNode a, b;
        a = tree.left.left;
        b = tree.right.right;

        System.out.println(isCousins(tree, a.val, b.val));
    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        Pair p1 = isCousinsHelper(root, x, null, 0);
        Pair p2 = isCousinsHelper(root, y, null, 0);
        return p1.depth == p2.depth && p1.parent != p2.parent;
    }

    public static Pair isCousinsHelper(TreeNode root, int value, TreeNode parent, int height) {
        if(root==null) return null;
        if(root.val==value) return new Pair(parent, height);
        Pair left = isCousinsHelper(root.left, value, root, height+1);
        Pair right = isCousinsHelper(root.right, value, root, height+1);
        return left==null?right:left;
    }

    static class Pair {
        TreeNode parent;
        int depth;

        public Pair(TreeNode node, int depth) {
            this.parent = node;
            this.depth = depth;
        }
    }

}
