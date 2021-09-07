package leetcode;

import commonDataStructures.ListNode;

/**
 * LC Medium :  https://leetcode.com/explore/featured/card/recursion-i/251/scenario-i-recurrence-relation/2378/
 *
 * */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(reverseListRecursive(head).next.next.data);
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

    public static ListNode reverseListRecursive(ListNode head) {
        if(head == null) return head;
        ListNode curr = head.next;
        head.next = null;
        return helper(head, curr);
    }

    public static ListNode helper(ListNode head, ListNode curr) {
        if(curr == null) return head;
        ListNode tmp = curr.next;
        curr.next = head;
        return helper(curr, tmp);
    }
}
