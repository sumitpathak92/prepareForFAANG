package leetcode;

import commonDataStructures.TreeNode;

/**
 *
 * LC Medium : https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/535/
 */

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {

    }

    // using top-down-recursive approach
    public int maxDepth(TreeNode root) {
        // depth of root node is 1
        return helper(root, 1, 0);
    }

    public int helper(TreeNode root, int depth, int answer) {
        if(root == null) return 0;
        // check if leaf node

        if(root.left==null && root.right == null) {
            answer = Math.max(answer, depth);
            return answer;
        }

        return Math.max(helper(root.left, depth+1, answer),
                helper(root.right, depth+1, answer));
    }
}
