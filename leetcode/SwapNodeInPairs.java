package leetcode;

import commonDataStructures.ListNode;

/**
 * LC Medium : https://leetcode.com/explore/featured/card/recursion-i/250/principle-of-recursion/1681/
 * */
public class SwapNodeInPairs {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        n1.next.next.next = new ListNode(4);
        System.out.println(swapPairs(n1).data);
    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode tmp2 = head.next;
        ListNode tmp3 = head.next.next;
        tmp2.next = head;
        head.next = swapPairs(tmp3);
        return tmp2;
    }
}
