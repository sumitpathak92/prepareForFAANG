package leetcode;

import commonDataStructures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SameTree {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(8);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(8);
        System.out.println("is it same  >  "+isSameTree(root1, root2));
    }

    private static boolean isSameTree(TreeNode root1, TreeNode root2) {
        List<Integer> res1 = dfs(root1);
        List<Integer> res2 = dfs(root2);
        if(res1.equals(res2)) return true;
        return false;
    }

    private static List<Integer> dfs(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        res.add(root.val);
        while(true) {
            int count = q.size();
            if(count==0) break;
            while(count>0) {
                TreeNode tmp = q.poll();
                if(tmp.left!=null) {
                    q.add(tmp.left);
                    res.add(tmp.left.val);
                }
                if(tmp.left==null) {
                    res.add(-1);
                }
                if(tmp.right!=null) {
                    q.add(tmp.right);
                    res.add(tmp.right.val);
                }
                if(tmp.right==null) {
                    res.add(-1);
                }
                count --;
            }
        }
        return res;
    }
}
