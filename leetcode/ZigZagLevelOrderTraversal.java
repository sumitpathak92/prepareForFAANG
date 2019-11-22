package leetcode;

import commonDataStructures.TreeNode;

import java.util.*;

public class ZigZagLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(5);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(8);
        System.out.println(zigzagLevelOrder(root));
    }

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int height = maxDepth(root);
        System.out.println("height  "+height);
        while(true) {
            int count = q.size();
            if(count == 0) break;
            List<Integer> intermediate = new ArrayList<>();
            while(count>0) {
                System.out.println("inside count loop --? "+count);
                TreeNode tmp = q.poll();
                if(height%2==0) intermediate.add(tmp.val);
                else intermediate.add(0, tmp.val);
                if(tmp.left!=null) {
                    q.add(tmp.left);
                }
                if(tmp.right!=null) {
                    q.add(tmp.right);
                }
                count --;
            }
            res.add(intermediate);
            height--;
        }
        return res;
    }

    private static int maxDepth(TreeNode node)
    {
        if (node == null) return 0;
        else {
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);
            if (lDepth > rDepth) return (lDepth + 1);
            else return (rDepth + 1);
        }
    }
}
