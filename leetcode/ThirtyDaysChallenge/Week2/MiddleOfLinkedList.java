package leetcode.ThirtyDaysChallenge.Week2;


import commonDataStructures.ListNode;

/**
 *
 * Problem Statement:  Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 *
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 * */


public class MiddleOfLinkedList {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println("output   "+middleNode2(head).data);
    }

    public static ListNode middleNode(ListNode head) {
        if(head==null) return null;
        int c=0;
        ListNode tmp = head;
        while(head!=null) {
            c++;
            head=head.next;
        }
        c/=2;
        while(c>0){
            tmp=tmp.next;
            c--;
        }
        return tmp;
    }

    public static ListNode middleNode2(ListNode head) {
        ListNode A = head;
        ListNode B= head;
        while(B!=null) {
            B = B.next;
            if(B==null) return A;
            B = B.next;
            A=A.next;
        }
        return A;
    }
}
