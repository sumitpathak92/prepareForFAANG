package leetcode;

import commonDataStructures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * LC Easy : https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/931/
 * */
public class BinaryTreeLevelOrderTraversalII {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root!=null)
            q.offer(root);
        while(!q.isEmpty()) {
            List<Integer> subRes = new ArrayList<>();
            int size = q.size();
            for(int i = 0; i<size; i++) {
                TreeNode tmp = q.poll();
                subRes.add(tmp.val);
                if(tmp.left!=null)
                    q.offer(tmp.left);
                if(tmp.right!=null)
                    q.offer(tmp.right);
            }
            res.add(subRes);
        }
        return res;
    }
}
