package leetcode;

import commonDataStructures.ListNode;

/**
 *
 * LC Hard : https://leetcode.com/problems/reverse-nodes-in-k-group/
 * **/
public class ReverseNodesInKGroup {

    public static void main(String[] args) {
        commonDataStructures.ListNode head = new commonDataStructures.ListNode(1);
        head.next = new commonDataStructures.ListNode(2);
        head.next.next = new commonDataStructures.ListNode(3);
        head.next.next.next = new commonDataStructures.ListNode(4);
        head.next.next.next.next = new commonDataStructures.ListNode(5);
        head.next.next.next.next.next = new commonDataStructures.ListNode(6);
        System.out.println(reverseKGroup(head, 3));
    }

    public static commonDataStructures.ListNode reverseKGroup(commonDataStructures.ListNode head, int k) {
        if(head==null) return null;
        commonDataStructures.ListNode tmp=head; commonDataStructures.ListNode n = new ListNode(-1);
        for(int i = 1; i<=k; i++) {
            n.next = tmp;
            tmp = tmp.next;
            n = n.next;
        }
        System.out.println(n.next.data);
        return new commonDataStructures.ListNode(-1);
    }

    public static commonDataStructures.ListNode reverseListRecursive(commonDataStructures.ListNode head) {
        if(head == null) return head;
        commonDataStructures.ListNode curr = head.next;
        head.next = null;
        return helper(head, curr);
    }

    public static commonDataStructures.ListNode helper(commonDataStructures.ListNode head, commonDataStructures.ListNode curr) {
        if(curr == null) return head;
        commonDataStructures.ListNode tmp = curr.next;
        curr.next = head;
        return helper(curr, tmp);
    }
}
