package leetcode;


import commonDataStructures.ListNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
LC Medium : https://leetcode.com/problems/reorder-list/
* **/
public class ReorderList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        reorderListII(head);
    }

    public static void reorderList(ListNode head) {
        if(head == null) return;
        ListNode tmp = head;
        Stack<ListNode> st = new Stack<>();
        Queue<ListNode> q = new LinkedList<>();
        int c = 0;
        while(tmp!=null) {
            st.push(tmp);
            q.add(tmp);
            tmp=tmp.next;
            c++;
        }
        ListNode ll = new ListNode(-1);
        while(c>0) {
            ll.next = q.poll();
            ll = ll.next;
            ll.next = st.pop();
            ll = ll.next;
            c-=2;
        }
//        ll.next = null;
//        System.out.println(head.data);
//        System.out.println(head.next.data);
//        System.out.println(head.next.next.data);
//        System.out.println(head.next.next.next.data);

    }

    public static void reorderListII(ListNode head) {
        if(head == null) return;
        ListNode tmp = head;
        Stack<ListNode> st = new Stack<>();
        int c = 0;
        while(tmp!=null) {
            st.push(tmp);
            tmp=tmp.next;
            c++;
        }
        int count = 0;
        ListNode ll = new ListNode(-1);
        ListNode first = head; ListNode second = st.pop();
        while(count<c/2) {
            ll = first.next;
            first.next = second;
            first = ll;
            second.next = first;
            second = st.pop();
            count++;
        }
        ll.next = null;
        System.out.println(head.data);
        System.out.println(head.next.data);
        System.out.println(head.next.next.data);
        System.out.println(head.next.next.next.data);
        System.out.println(head.next.next.next.next.data);

    }

    private static ListNode adjust(ListNode l1, ListNode l2) {
        l1.next = l2;
        return l1;
    }
}
