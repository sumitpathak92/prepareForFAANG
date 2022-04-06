package leetcode;
import commonDataStructures.TreeNode;
/**
 * LC Easy : https://leetcode.com/problems/balanced-binary-tree/
 * **/
public class BalancedBinaryTreeII {

    public static void main(String[] args) {

    }

    public static boolean isBalanced(TreeNode root) {
        return height(root)!=-1;
    }

    static int height(TreeNode root) {
        if(root==null) return 0;
        int lh = height(root.left);
        if(lh==-1) return -1;
        int rh = height(root.right);
        if(rh==-1) return -1;
        if(Math.abs(lh-rh)>1) return -1;
        return Math.max(lh, rh)+1;
    }
}
