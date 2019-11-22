package leetcode;

import commonDataStructures.ListNode;

import util.CommonUtilities;

public class AddTwoNumbersLinkedList {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(1);

        ListNode head2 = new ListNode(3);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(1);
        CommonUtilities.linkedListPrintHelper(addTwoNumbers(head1, head2));
    }

    private static ListNode addTwoNumbers(ListNode n1, ListNode n2) {
        int carry = 0;
        ListNode res, head = null, prev = null;
        while (n1!=null || n2!=null || carry>0) {
            int sum = 0;
            if(n1!=null) sum+=n1.data;
            if(n2!=null) sum+=n2.data;
            int v = sum%10;
            carry = sum/10;
            res = new ListNode(v);
            if(head==null) head = res;
            if(prev!=null) prev.next = res;
            n1=(n1!=null) ? n1.next : null;
            n2=(n2!=null) ? n2.next : null;
            prev = res;
        }
        return head;
    }
}
