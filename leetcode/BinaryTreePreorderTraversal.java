package leetcode;

import commonDataStructures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * LC Easy : https://leetcode.com/problems/binary-tree-preorder-traversal/
 * */
public class BinaryTreePreorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        preorderTraversalIterative(root);
        preorderTraversalRecursive(root);
    }

    public static List<Integer> preorderTraversalRecursive(TreeNode root) {
        // process root -> left-subtree -> right-subtree
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public static List<Integer> helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            helper(root.left, res);
            helper(root.right, res);
        }
        return res;
    }

    public static List<Integer> preorderTraversalIterative(TreeNode root) {
        if(root==null) return null;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        List<Integer> res = new ArrayList<>();
        while(!st.isEmpty()) {
            TreeNode tmp = st.pop();
            if(tmp.right!=null) st.push(tmp.right);
            if(tmp.left!=null) st.push(tmp.left);
            res.add(tmp.val);
        }
        return res;
    }
}
