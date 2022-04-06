package leetcode;

import commonDataStructures.TreeNode;
import java.util.*;

/**
 * LC Medium : https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/787/
 * **/
public class BinaryTreeLevelOrderZigZag {

    public static void main(String[] args) {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        boolean flag = false;
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int s = q.size();
            LinkedList<Integer> level = new LinkedList<>();
            for(int i = 0; i<s; i++) {
                TreeNode node = q.remove();
                if(node.left!=null) {
                    q.offer(node.left);
                }
                if(node.right!=null) {
                    q.offer(node.right);
                }
                if(flag) {
                    level.addFirst(node.val);
                } else {
                    level.addLast(node.val);
                }
            }
            res.add(level);
            flag = !flag;
        }
        return res;
    }
}
