package leetcode;

// DIFFICULTY : Medium

/*
*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

*/

/*

Example:

Input: [1,2,3]
    1
   / \
  2   3
       \
        4
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.

*/


import commonDataStructures.TreeNode;

public class SumRootToLeafNumbers {

    public static void main(String[] args) {
        System.out.println(sumNumbers(new TreeNode(23)));
    }

    static int sumNumbers(TreeNode root) {
        return sumHelper(root, 0);
    }

    static int sumHelper(TreeNode node, int sum) {
        if(node == null) return 0;
        sum=sum*10+node.val; //sum till that node
        if(node.left == null && node.right == null) return sum;
        return sumHelper(node.left, sum) + sumHelper(node.right, sum);
    }

}
