package leetcode.January2021Challenge;

import commonDataStructures.ListNode;

/***
 * Problem :
 */
public class DeleteDuplicatesLinkedListII {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        deleteDuplicates(head);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while(head!=null) {
            if(head.next!=null && head.data == head.next.data) {
                while (head.next!=null && head.next.data == head.data) {
                    head = head.next;
                }
                prev.next = head;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
