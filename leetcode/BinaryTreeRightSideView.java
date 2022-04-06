package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import commonDataStructures.TreeNode;
/**
 * LC Medium : https://leetcode.com/problems/binary-tree-right-side-view/
 * **/
public class BinaryTreeRightSideView {

    public static void main(String[] args) {

    }

    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int s = q.size();
            for(int i = 0; i<s; i++) {
                TreeNode node = q.poll();
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
                if(i==s-1){
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}
