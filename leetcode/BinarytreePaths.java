package leetcode;

import commonDataStructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LC Easy : https://leetcode.com/problems/binary-tree-paths/
 * **/
public class BinarytreePaths {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        System.out.println(binaryTreePaths(root));
    }
    static List<String> ans = new ArrayList<>();
    public static List<String> binaryTreePaths(TreeNode root) {
        traverseAndAppend(root, "");
        return ans;
    }
    static void traverseAndAppend(TreeNode root, String path) {

        if(root.left==null && root.right == null) {
            ans.add(path+root.val);
        }
        if(root.left!=null){
            traverseAndAppend(root.left, path+root.val+"->");
        }
        if(root.right!=null) {
            traverseAndAppend(root.right, path+root.val+"->");
        }
    }
}
