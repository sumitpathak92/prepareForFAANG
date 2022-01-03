package leetcode;

import commonDataStructures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * LC Easy : https://leetcode.com/problems/sum-of-left-leaves/
 * **/
public class SumOfLeftLeavesII {

    private static int sum = 0;
    public static void main(String[] args) {
        commonDataStructures.TreeNode root = new commonDataStructures.TreeNode(3);
        root.left = new commonDataStructures.TreeNode(9);
        root.right = new commonDataStructures.TreeNode(20);
        root.right.left = new commonDataStructures.TreeNode(15);
        root.right.right = new commonDataStructures.TreeNode(7);
        System.out.println(sumOfLeftLeaves(root));
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        int leftSum = getSumII(root.left, true);
        int rightSum = getSumII(root.right, false);
        return leftSum+rightSum;
    }

    public static int getSumII(TreeNode root, boolean left) {
        if(root==null) return 0;
        if(root.left==null && root.right==null && left) return root.val;
        return getSumII(root.left, true)+getSumII(root.right, false);
    }

    public static int getSum(TreeNode root, boolean isLeft) {
        if(root.left==null && root.right==null) return isLeft?root.val:0;
        int sum=0;
        if(root.left!=null){
            sum+=getSum(root.left, true);
        }
        if(root.right!=null) {
            sum+=getSum(root.right, false);
        }
        return sum;
    }
}
