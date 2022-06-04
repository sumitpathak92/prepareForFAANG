package leetcode;

import commonDataStructures.ListNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC Medium : https://leetcode.com/explore/featured/card/recursion-i/250/principle-of-recursion/1681/
 * */
public class SwapNodeInPairsII {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        n1.next.next.next = new ListNode(4);
        System.out.println(swapPairs(n1).data);
    }

    public static ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode tmp = head.next;
        ListNode tmp1 = head.next.next;
        tmp.next = head;
        head.next = swapPairs(tmp1);
        return tmp;
    }
}
