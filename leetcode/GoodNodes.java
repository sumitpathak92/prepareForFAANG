//package leetcode;
//
//import commonDataStructures.TreeNode;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
///**
// * LC Medium : https://leetcode.com/problems/count-good-nodes-in-binary-tree/
// * **/
//public class GoodNodes {
//
//    public static void main(String[] args) {
//        commonDataStructures.TreeNode root = new commonDataStructures.TreeNode(3);
//        root.left = new commonDataStructures.TreeNode(1);
//        root.right = new commonDataStructures.TreeNode(4);
//        root.left.left = new commonDataStructures.TreeNode(3);
//        root.right.left = new commonDataStructures.TreeNode(1);
//        root.right.right = new commonDataStructures.TreeNode(5);
//        System.out.println(goodNodes(root));
//    }
//
//
//    public static int goodNodes(TreeNode root) {
//        if(root==null) return 1;
//        int good = 1;
//        Queue<TreeNode> q = new LinkedList<>();
//        int max = Integer.MIN_VALUE;
//        q.offer(root);
//        while(!q.isEmpty()) {
//            TreeNode tmp = q.poll();
//            max = Math.max(max, tmp.val);
//            if(tmp.left!=null) {
//                if(tmp.left.val>max) good++;
//            }
//            if(tmp.right!=null) {
//
//            }
//        }
//    }
//}
