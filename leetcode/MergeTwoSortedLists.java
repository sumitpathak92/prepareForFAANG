package leetcode;

import commonDataStructures.ListNode;

/**
 *
 *  problem : https://leetcode.com/problems/merge-two-sorted-lists/
 * */

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println("after merge :::  "+mergeTwoLists(l1, l2).next.next.data);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2; if(l2==null) return l1;
        ListNode head;
        if(l1.data<=l2.data) {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;

    }
}
