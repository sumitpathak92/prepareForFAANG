package leetcode;

import commonDataStructures.TreeNode;

/*
LC Easy : https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
* **/
public class ConvertSortedArrayToBST {

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9, 11, 14};
        System.out.println(sortedArrayToBST(nums).right.val);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        int mid = len/2;
        int lMid = mid/2;
        int rMid = mid + (len-mid)/2;
        return helper(nums, 0, len-1);
    }

    private static TreeNode helper(int[] nums, int start, int end) {
        if(start>end) return null;
        int mid = start + (end-start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid-1);
        root.right = helper(nums, mid+1, end);
        return root;
    }
}
