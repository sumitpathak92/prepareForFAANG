package leetcode;

import commonDataStructures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * LC Medium : https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/536/
 * */
public class SymmetricTree {

    public static void main(String[] args) {
        SymmetricTree symmetricTree = new SymmetricTree();
        System.out.println(symmetricTree.isSymmetric(new TreeNode(12)));
    }

    public boolean isSymmetricIterative(TreeNode root) {
        if(root==null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        if(root.left!=null) q.offer(root.left);
        if(root.right!=null) q.offer(root.right);
        while(!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if(t1==null || t2==null) continue;
            if((t1==null && t2!=null) || (t1!=null && t2==null)) return false;
            if(t1.val!=t2.val) return false;
            q.offer(t1.left);
            q.offer(t2.right);
            q.offer(t1.right);
            q.offer(t2.left);
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return false;
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode left, TreeNode right) {
        if((left!=null && right==null) || (right!=null && left==null)) return false;
        if(left.val != right.val) return false;

        return helper(left.left, right.right) && helper(left.right, right.left);

    }
}
