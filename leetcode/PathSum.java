package leetcode;

import commonDataStructures.TreeNode;

/**
 * LC Easy : https://leetcode.com/problems/path-sum/
 * */
public class PathSum {

    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        int sum = 0;
        return hasPathSumRecursive(root, sum, targetSum);
    }

    public boolean hasPathSumRecursive(TreeNode root, int s, int t) {
        if(root==null) return false;
        s+=root.val;
        if((root.left==null && root.right==null) && s==t)
            return true;
        if((root.left==null && root.right==null) && s!=t)
            return false;
        return hasPathSumRecursive(root.left, s, t) || hasPathSumRecursive(root.right, s, t);
    }

}
