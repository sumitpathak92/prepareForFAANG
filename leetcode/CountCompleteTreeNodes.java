package leetcode;
import commonDataStructures.TreeNode;
/**
 * LC Medium : https://leetcode.com/problems/count-complete-tree-nodes/
 * **/
public class CountCompleteTreeNodes {

    public static void main(String[] args) {

    }

    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int lHeight = leftHeight(root);
        int rHeight = rightHeight(root);

        if(lHeight==rHeight) return 1 + (int)(Math.pow(2, lHeight)-1) + (int)(Math.pow(2, rHeight)-1);
        else return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public int leftHeight(TreeNode root) {
        int count =0;
        while(root.left!=null) {
            count++;
            root = root.left;
        }
        return count;
    }

    public int rightHeight(TreeNode root) {
        int count =0;
        while(root.right!=null) {
            count++;
            root = root.right;
        }
        return count;
    }
}
