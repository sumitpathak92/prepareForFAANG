package leetcode;

import commonDataStructures.ListNode;

public class AddTwoNumbersII {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
//        l1.next = new ListNode(9);
//        l1.next.next = new ListNode(9);
//        l1.next.next.next = new ListNode(9);
//        l1.next.next.next.next = new ListNode(9);
//        l1.next.next.next.next.next = new ListNode(9);
//        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(0);
//        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(9);
//        l2.next.next.next = new ListNode(9);

        System.out.println(addTwoNumbers(l1, l2).data);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode ans = res;
        int carry = 0;
        while(l1!=null || l2!=null || carry > 0) {
            int d1 = (l1 == null) ? 0 : l1.data;
            int d2 = (l2 == null) ? 0 : l2.data;
            int sum = d1+d2+carry;
            res.next = new ListNode(sum%10);
            carry = sum/10;
            res = res.next;
//            if(l1==null)
            l1=(l1 == null) ? null : l1.next;
            l2=(l2 == null) ? null : l2.next;
        }
        return ans.next;
    }
}
