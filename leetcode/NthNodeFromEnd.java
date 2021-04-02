package leetcode;

import commonDataStructures.ListNode;

public class NthNodeFromEnd {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("printing :::  "+removeNthFromEnd2nd(head, 2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int l = 0;
        ListNode tmp = head;
        ListNode tmp2 = head;
        while (tmp!=null) {
            l++;
            tmp=tmp.next;
        }
        if(l==1 && n==1) return null;
        int toRemove = l-n+1; int i = 1;
        System.out.println("to remove ::  "+toRemove);
        while(i<toRemove-1) {
            head = head.next;
            i++;
        }
        System.out.println("head data  "+head.data);
        head.next = head.next.next;
        return tmp2;
    }

    public static ListNode removeNthFromEnd2nd(ListNode head, int n) {
        ListNode dummy=new ListNode(0, head);
        ListNode first = dummy; ListNode second = dummy;
        while(n!=0) {
            second = second.next;
            n--;
        }
        while(second!=null) {
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }
}
