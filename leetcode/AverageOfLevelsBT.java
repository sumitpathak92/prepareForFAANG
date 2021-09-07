package leetcode;

import commonDataStructures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 *LC Easy :  https://leetcode.com/problems/average-of-levels-in-binary-tree/
 * */
public class AverageOfLevelsBT {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2147483647);
        root.left = new TreeNode(2147483647);
        root.right = new TreeNode(2147483647);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);
        System.out.println(averageOfLevels(root));
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            long s = 0;
            for(int i = 0; i<size; i++) {
                TreeNode tmp = q.poll();
                s+=tmp.val;
                if(tmp.left!=null) q.add(tmp.left);
                if(tmp.right!=null) q.add(tmp.right);
            }
            res.add(s*1.0/size);
        }
        return res;
    }
}
