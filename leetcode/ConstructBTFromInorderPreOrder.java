package leetcode;

import java.util.HashMap;
import java.util.Map;

import commonDataStructures.TreeNode;


/**
 * LC Medium : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * **/
public class ConstructBTFromInorderPreOrder {

    static Map<Integer, Integer> map = new HashMap<>();
    static int preIndex;
    public static void main(String[] args) {
        int[] pre = {3,9,20, 15, 7}; int[] in = {9,3,15,20,7};
        System.out.println(buildTree(pre, in).val);
    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        for(int i = 0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeRecursive(preorder, 0, preorder.length-1);
    }

    public static TreeNode buildTreeRecursive(int[] pre, int start, int end) {
        if(start>end) return null;
        int data = pre[preIndex++];
        TreeNode root = new TreeNode(data);
        root.left = buildTreeRecursive( pre, start, map.get(data)-1);
        root.right = buildTreeRecursive( pre, map.get(data)+1, end);

        return root;
    }
}
