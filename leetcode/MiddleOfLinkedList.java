package leetcode;

import commonDataStructures.ListNode;

/*
LC Easy : https://leetcode.com/problems/middle-of-the-linked-list/
* **/
public class MiddleOfLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(middleNode(head).data);
    }

    public static ListNode middleNode(ListNode head) {
        if(head == null) return null;
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2!=null && p2.next!=null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }
}
