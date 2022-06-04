//package leetcode;
//
//import commonDataStructures.ListNode;
//
///**
// *
// * LC Hard : https://leetcode.com/problems/reverse-nodes-in-k-group/
// * **/
//public class ReverseNodesInKGroupII {
//
//    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
//        System.out.println(reverseKGroup(head, 3));
//    }
//
//    public static ListNode reverseKGroup(ListNode head, int k) {
//
//    }
//
//    static ListNode reverseLinkedList(ListNode head, int k) {
//        if(head==null) return head;
//        ListNode curr = head.next;
//        head.next = prev;
//        return helper(head, curr);
//    }
//
//    static ListNode helper(ListNode head, ListNode curr) {
//        if(curr==null)
//    }
//}
