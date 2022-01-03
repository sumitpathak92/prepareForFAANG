package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
LC Medium : https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
* **/
public class PopulatingRightNextPointersII {

    public static void main(String[] args) {
        TreeNodeRight root = new TreeNodeRight(1);
        root.left = new TreeNodeRight(2);
        root.right = new TreeNodeRight(3);
        root.left.left = new TreeNodeRight(4);
        root.left.right = new TreeNodeRight(5);
        root.right.right = new TreeNodeRight(7);

        System.out.println(connect(root).next.val);
    }

    public static TreeNodeRight connect(TreeNodeRight root) {
        if(root ==null) return null;
        Queue<TreeNodeRight> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int s = q.size();
            int i = 0;
            while(i<s) {
                TreeNodeRight p = q.poll();

                if(i<s-1) {
                    p.next = q.peek();
                }
                if(p.left!=null) q.offer(p.left);
                if(p.right!=null) q.offer(p.right);
                i++;
            }
        }
        return root;
    }

}

class TreeNodeRight {
    public int val;
    public TreeNodeRight left;
    public TreeNodeRight right;
    public TreeNodeRight next;

    public TreeNodeRight() {}

    public TreeNodeRight(int _val) {
        val = _val;
    }

    public TreeNodeRight(int _val, TreeNodeRight _left, TreeNodeRight _right, TreeNodeRight _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
