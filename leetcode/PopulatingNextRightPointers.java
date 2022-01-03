package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
LC Medium : https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
* **/
public class PopulatingNextRightPointers {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(connect(root).next);
    }

    public static Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        Node tmp = root;
        q.offer(tmp);
        while(!q.isEmpty()) {
            int s = q.size();
            // iterate over all nodes on current level
            for(int j = 0; j<s; j++) {
                Node n = q.poll();
                if(j<s-1) {
                    n.next = q.peek();
                }
                if(n.left!=null) q.add(n.left);
                if(n.right!=null) q.add(n.right);
            }
        }
        return root;
    }

}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

