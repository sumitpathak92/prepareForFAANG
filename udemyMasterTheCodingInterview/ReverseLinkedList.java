package udemyMasterTheCodingInterview;

import commonDataStructures.ListNode;

public class ReverseLinkedList {



    public static void main(String[] args) {
        ListNode head = new ListNode(6);
        head.next = new ListNode(4);
        head.next.next = new ListNode(8);
        head.next.next.next = new ListNode(15);
        head.next.next.next.next = new ListNode(9);
        System.out.println("before ");
        printLinkedList(head);
        head = reverseLinkedList(head);
        System.out.println("after  ");
        printLinkedList(head);
    }

    static ListNode reverseLinkedList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode current = head;
        ListNode next;
        ListNode prev = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    static void printLinkedList(ListNode node) {
        while(node!=null){
            System.out.print(node.data + " --> ");
            node = node.next;
        }
    }
}
