package leetcode;

import commonDataStructures.TreeNode;

/**
 * LC Easy : https://leetcode.com/explore/learn/card/recursion-i/256/complexity-analysis/2375/
 *
 * */

public class MaximumDepthOfBinaryTreeII {

    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return Math.max(left_height, right_height) + 1;
        }
    }
}
