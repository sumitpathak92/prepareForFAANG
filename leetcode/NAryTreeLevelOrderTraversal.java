package leetcode;

import java.util.*;

public class NAryTreeLevelOrderTraversal {

    public static void main(String[] args) {
//        System.out.println(levelOrder(new ListNode())); // just a dummy call
    }

//    public static List<List<Integer>> levelOrder(ListNode root) {
//        if(root == null) return Collections.emptyList();;
//        List<List<Integer>> res = new ArrayList<>();
//        Queue<ListNode> q = new LinkedList<>();
//        q.offer(root);
//        while(!q.isEmpty()) {
//            int s = q.size();
//            List<Integer> ll = new ArrayList<>();
//            for(int i = 0 ; i<s; i++) {
//                root = q.poll();
//                ll.add(root.val);
//                for(ListNode c : root.children)
//                    q.offer(c);
//            }
//            res.add(ll);
//        }
//        return res;
//    }
}

class TreeNode {
    public int val;
    public List<ListNode> children;

    public TreeNode() {}

    public TreeNode(int _val, List<ListNode> _children) {
        val = _val;
        children = _children;
    }
}
