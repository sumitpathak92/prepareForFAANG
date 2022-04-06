package leetcode;

import commonDataStructures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversalIterative(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode current = root;
        List<Integer> res = new ArrayList<>();
        while(current!=null || !st.isEmpty()) {
            // traverse till the left most leaf and add it to the stack for processing later
            // similar to recursive implementation
            while(current!=null){
                st.push(current);
                current=current.left;
            }

            current = st.pop();
            System.out.println(current.val);
            res.add(current.val);

            // start processing right subtree
            current = current.right;
        }
        return res;
    }

    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        res = helper(root, res);
        System.out.println(res);
        return res;
    }

    public List<Integer> helper(TreeNode root, List<Integer> res) {
        if(root!=null) {
            helper(root.left, res);
            res.add(root.val);
            helper(root.right, res);
        }
        return res;
    }
}
