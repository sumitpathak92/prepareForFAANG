package leetcode;

import commonDataStructures.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * LC Medium : https://leetcode.com/explore/learn/card/recursion-i/253/conclusion/2382/
 * */

public class MergeSortedLinkedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
//        l1.next.next.next = new ListNode(6);
//        l1.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
//        l2.next.next.next = new ListNode(8);

        System.out.println(mergeTwoLists(l1, l2).next.next.data);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return mergeHelper(l1, l2);
    }

    public static ListNode mergeHelper(ListNode h1, ListNode h2) {
        if(h1 == null) { // base case
            return h2;
        }
        else if(h2 == null) { // base case
            return h1;
        }
        else if(h1.data <= h2.data) {
            h1.next = mergeHelper(h1.next, h2);
            return h1;
        }
        else {
            h2.next = mergeHelper(h1, h2.next);
            return h2;
        }
    }
}
