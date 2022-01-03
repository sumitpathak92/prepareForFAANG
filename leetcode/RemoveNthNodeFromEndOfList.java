package leetcode;

import commonDataStructures.ListNode;

/*
LC Medium : https://leetcode.com/problems/remove-nth-node-from-end-of-list/
* **/
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new commonDataStructures.ListNode(3);
//        head.next.next.next = new commonDataStructures.ListNode(4);
//        head.next.next.next.next = new commonDataStructures.ListNode(5);
        System.out.println(removeNthFromEnd(head, 2).data);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode tmp = head;
        while(tmp!=null) {
            len+=1;
            tmp = tmp.next;
        }
        if(len==1 && n==1) return null;
        int distance = len-n;
        ListNode start = head;
        if(distance == 0) {
            return start.next;
        }
        while(distance>1) {
            start = start.next;
            distance--;
        }
        start.next = start.next.next;
        return head;
    }
}
