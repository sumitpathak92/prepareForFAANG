package leetcode;

import java.util.Hashtable;

import commonDataStructures.ListNode;

/**
 *
 * LC Medium : https://leetcode.com/problems/linked-list-cycle-ii/
 * **/
public class LinkedListCycleII {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        System.out.println(detectCycle(head).next.data);
    }

    public static ListNode detectCycle(ListNode head) {
        Hashtable<ListNode, Integer> hs = new Hashtable<>();
        ListNode slow = head; ListNode fast = head; int i = 0;
        hs.put(slow, i);
        while(fast!=null || fast.next!=null) {
            slow=slow.next; fast = fast.next.next;
            hs.put(slow, i+1);
            if(slow==fast) {
                return slow;
            }
        }
        return null;
    }
}
