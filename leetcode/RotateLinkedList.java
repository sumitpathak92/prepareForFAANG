package leetcode;

import commonDataStructures.ListNode;
import util.CommonUtilities;

public class RotateLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        CommonUtilities.linkedListPrintHelper(rotateList(head, 2));
    }

    public static ListNode rotateList(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode temp = head; int len = 1;
        while(temp.next!=null) {
            len++;
            temp=temp.next;
        }
        k%=len; ListNode res = head;
        if(k==0) return head;
        for(int i = 0; i<len - k -1; i++) {
            res=res.next;
        }
        ListNode newHead = res.next;
        res.next = null;
        temp.next = head;
        return newHead;
    }
}
