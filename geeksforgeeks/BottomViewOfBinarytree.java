package geeksforgeeks;

import commonDataStructures.TreeNode;

import java.util.*;

/**
 * GFG Medium : https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
 * **/
public class BottomViewOfBinarytree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);
        System.out.println(bottomView(root));
    }

    public static ArrayList<Integer> bottomView(TreeNode root) {
        if(root==null) return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Integer> mp = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        mp.put(0, root.val);
        while(!q.isEmpty()) {
            Pair tmp = q.poll();
            TreeNode node = tmp.node;
            int currLevel;
            if(node.left!=null) {
                currLevel=tmp.level-1;
                q.offer(new Pair(node.left, currLevel));
                mp.put(currLevel, node.left.val);
            }
            if(node.right!=null) {
                currLevel= tmp.level+1;
                q.offer(new Pair(node.right, currLevel));
                mp.put(currLevel, node.right.val);
            }
        }
        System.out.println(mp);

        return new ArrayList<>(mp.values());
    }
}

class Pair {
    TreeNode node;
    int level;

    public Pair(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}
