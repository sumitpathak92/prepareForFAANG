package leetcode;

import commonDataStructures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostOrderTraversal {

    public static void main(String[] args) {

    }

    public static List<Integer> postOrderTraversalIterative(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        List<Integer> res = new ArrayList<>();
        while(!s1.isEmpty()) {
            TreeNode tmp = s1.pop();
            s2.push(tmp);
            if(tmp.left!=null)
                s1.push(tmp.left);
            if(tmp.right!=null)
                s1.push(tmp.right);
        }

        while(!s2.isEmpty()) {
            TreeNode tmp = s2.pop();
            res.add(tmp.val);
        }

        return res;
    }
    public static List<Integer> postorderTraversal(TreeNode root) {
        // traverse left --> right --> root
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public static List<Integer> helper(TreeNode root, List<Integer> res) {
        if(root!=null) {
            helper(root.left, res);
            helper(root.right, res);
            res.add(root.val);
        }
        return res;
    }
}
