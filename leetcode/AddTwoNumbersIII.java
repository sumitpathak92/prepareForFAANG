package leetcode;

import commonDataStructures.ListNode;

/*
LC Medium : https://leetcode.com/problems/add-two-numbers/
* **/
public class AddTwoNumbersIII {

    private static ListNode res = new ListNode(0);
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

        System.out.println(addTwoNumbers(l1, l2).next.next.next.next.next.next.next.next.next.data);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        addHelper(l1, l2, 0, res);
        return res;
    }

    private static void addHelper(ListNode l1, ListNode l2, int carry, ListNode res) {
        if(l1 == null && l2 == null && carry == 0) return;
        int d1 = (l1 != null) ? l1.data : 0;
        int d2 = (l2 != null) ? l2.data : 0;
        int s = d1+d2+carry;
        res.next = new ListNode(s%10);
        carry = s/10;
        addHelper(l1==null?null:l1.next, l2==null?null:l2.next, carry, res.next);
    }
}
