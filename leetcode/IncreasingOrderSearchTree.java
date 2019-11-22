
// solution for increasing order search tree problem

// Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.
// input = [5,3,6,2,4,null,8,1,null,null,null,7,9]
// output= [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
//      	 5
//      	/ \
//    	   3    6
//        / \    \
//       2   4    8
//      /        / \
//	   1        7   9

package leetcode;

import commonDataStructures.TreeNode;
import java.util.*;

public class IncreasingOrderSearchTree {

	public static List<Integer> orders;
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(6);
		root.right.right = new TreeNode(8);
		root.right.right.left = new TreeNode(7);
		root.right.right.right = new TreeNode(9);
		System.out.println("new root is "+increasingBST(root).right.right.right.val);
	}

	public static TreeNode increasingBST(TreeNode root) {
		if(root == null) return null;
		orders = new ArrayList<>();
		inOrder(root);
		TreeNode rootNew = new TreeNode(orders.get(0));
		TreeNode curr = rootNew;
		for(int i = 1; i< orders.size(); i++) {
			curr.right = new TreeNode(orders.get(i));
			curr = curr.right;
		}
		return rootNew;
	}

	static void inOrder(TreeNode root) {
		if(root != null) {
			inOrder(root.left);
			orders.add(root.val);
			inOrder(root.right);
		}
	}
}
