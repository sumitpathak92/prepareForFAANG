package leetcode;

import commonDataStructures.ListNode;
import util.CommonUtilities;

public class DeleteNodeInLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(8);
        head.next.next = new ListNode(12);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(1);
        deleteNodeInLL(head.next);
        CommonUtilities.linkedListPrintHelper(head);
    }

    static void deleteNodeInLL(ListNode listNode) {
        ListNode temp = listNode.next;
        listNode.data = temp.data;
        listNode.next = temp.next;
    }
}
