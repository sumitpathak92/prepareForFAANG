package leetcode;


import commonDataStructures.ListNode;

/**
 *
 * LC Easy : #160 https://leetcode.com/problems/intersection-of-two-linked-lists/
 * */

public class LinkedListIntersectionPoint {

    public static void main(String[] args) {
        ListNode A = new ListNode(4);
        A.next = new ListNode(1);
        A.next.next = new ListNode(8);
        A.next.next.next = new ListNode(4);
        A.next.next.next.next = new ListNode(5);

        ListNode B = new ListNode(5);
        B.next = new ListNode(0);
        B.next.next = new ListNode(1);
        B.next.next.next = new ListNode(8);
        B.next.next.next.next = new ListNode(4);
        B.next.next.next.next.next = new ListNode(5);
        System.out.println(getIntersectionNode(A, B));
    }

    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB == null) return null;
        int s1 = getLength(headA); int s2 = getLength(headB);
        int diff = Math.abs(s1-s2);
        if(s1>s2){
            for(int i = 0; i<diff; i++) {
                headA = headA.next;
            }
        } else {
            for(int i = 0; i<diff; i++) {
                headB = headB.next;
            }
        }
        while(headA!=headB) {
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }

    static int getLength(ListNode root) {
        int l = 0;
        while(root!=null) {
            l++;
            root=root.next;
        }
        return l;
    }
}
