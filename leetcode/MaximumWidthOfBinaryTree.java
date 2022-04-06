package leetcode;

import commonDataStructures.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/***
 *
 * LC Medium : https://leetcode.com/problems/maximum-width-of-binary-tree/
 * **/
public class MaximumWidthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        System.out.println(widthOfBinaryTree(root));
    }

    public static int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<DataPair> queue = new LinkedList<>();
        DataPair pair = new DataPair(root, 0);
        queue.offer(pair);
        int max = 0;
        while(!queue.isEmpty()) {
            int s = queue.size();
            int first=0; int last=0;
            for(int i = 0; i<s; i++) {
                DataPair tmp = queue.poll();
                if(i==0) first = tmp.index;
                if(i==s-1) last = tmp.index;
                if(tmp.node.left!=null)
                    queue.offer(new DataPair(tmp.node.left, 2* tmp.index+1));
                if(tmp.node.right!=null) {
                    queue.offer(new DataPair(tmp.node.right, 2* tmp.index+2));
                }
                System.out.println("first :::  "+first + "  last ::::  "+last);
            }
            max = Math.max(max, last-first+1);
        }
        return max;
    }
}

class DataPair {
    TreeNode node;
    int index;

    public DataPair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}
