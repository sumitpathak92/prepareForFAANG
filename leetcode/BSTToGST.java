/**
 *  https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 *
 *  1038. Binary Search Tree to Greater Sum Tree
 */

package leetcode;

import commonDataStructures.TreeNode;

public class BSTToGST {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(22);
        System.out.println(solution.bstToGst(root));
    }

    static class Solution {

        public TreeNode bstToGst(TreeNode root) {
            int sum = inOrderSum(root);
            inOrderTraversal(root, sum);
            return root;
        }

        public void inOrderTraversal(TreeNode node, int sum) {
            if(node!=null) {
                inOrderTraversal(node.left, sum);
                sum = sum-node.val;
                node.val = sum;
                inOrderTraversal(node.right, sum);
            }
        }

        public int inOrderSum(TreeNode node) {
            if(node == null) return 0;
            return node.val + inOrderSum(node.left) + inOrderSum(node.right);
        }
    }
}
