package leetcode;
import commonDataStructures.TreeNode;

/**
 * LC Hard : https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * **/
public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxPathSum(root));
    }
    static int ans = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        maxPath(root);
        return ans;
    }

    static int maxPath(TreeNode root) {
        if(root==null) return 0;
        int leftSum = maxPath(root.left);
        if(leftSum<0) leftSum = 0;
        int rightSum = maxPath(root.right);
        if(rightSum<0) rightSum = 0;
        ans = Math.max(ans, root.val+leftSum+rightSum);
        return root.val+Math.max(leftSum, rightSum);
    }
}
