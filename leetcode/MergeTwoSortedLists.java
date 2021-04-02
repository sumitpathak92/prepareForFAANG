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
        System.out.println("after merge :::  "+mergeTwoLists(l1, l2).data);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy;
        while(l1!=null && l2!=null) {
            if(l1.data < l2.data) {
                dummy.next = l1;
                l1 = l1.next;
            }
            else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        if(l1==null) {
            dummy.next = l2;
        } else {
            dummy.next = l1;
        }
        return tmp.next;
    }
}
