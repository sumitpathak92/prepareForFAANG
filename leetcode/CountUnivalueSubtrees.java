package leetcode;

import commonDataStructures.TreeNode;

/**
 *
 * LC Medium : https://leetcode.com/problems/count-univalue-subtrees/
 * */
public class CountUnivalueSubtrees {

    int count = 0;
    public static void main(String[] args) {

    }

    public int countUnivalSubtreesII(TreeNode root) {
        boolean res = helper(root);
        if(!res) return 0;
        return count;
    }

    public boolean helperII(TreeNode node) {
        if(node==null) return false;
        boolean flag;
        boolean isLeftUni = (node.val == node.left.val) && helper(node.left);
        boolean isRightUni = (node.val == node.right.val) && helper(node.right);
        boolean isLeftLeaf = (node.left == null);
        boolean isRightLeaf = (node.right == null);

        flag = isLeftUni && isRightUni && isLeftLeaf && isRightLeaf;
        if(flag) {
            count++;
            return true;
        }
        return false;
    }

    public int countUnivalSubtrees(TreeNode root) {
        helper(root);
        return count;
    }

    public boolean helper(TreeNode node) {
        if(node.left==null && node.right==null) { // base case, all leaf nodes are univalue subtrees
            count++;
            return true;
        }
        boolean isUni = true;

        // recurse for each of the left and right subtrees
        if(node.left!=null) {
            isUni = helper(node.left) && isUni && (node.val == node.left.val);
        }
        if(node.right!=null) {
            isUni = helper(node.right) && isUni && (node.val == node.right.val);
        }
        if(!isUni) return false;
        count++;
        return true;
    }
}
