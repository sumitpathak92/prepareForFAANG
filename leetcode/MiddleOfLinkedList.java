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
        head.next.next.next.next.next = new ListNode(6);

        System.out.println(middleNode(head).data);
    }

    public static ListNode middleNode(ListNode head) {
        int len = 0; ListNode tmp = head;
        while(tmp!=null) {
            tmp = tmp.next;
            len++;
        }
        if(len==1) return head;
        int mid = len/2+1;
        for(int i = 2; i<=mid; i++) {
            head=head.next;
        }
        return head;
    }
}
