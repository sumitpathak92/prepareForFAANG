package leetcode;

import java.util.*;

public class NAryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        System.out.println(levelOrder(new Node())); // just a dummy call
    }

    public static List<List<Integer>> levelOrder(Node root) {
        if(root == null) return Collections.emptyList();;
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int s = q.size();
            List<Integer> ll = new ArrayList<>();
            for(int i = 0 ; i<s; i++) {
                root = q.poll();
                ll.add(root.val);
                for(Node c : root.children)
                    q.offer(c);
            }
            res.add(ll);
        }
        return res;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
