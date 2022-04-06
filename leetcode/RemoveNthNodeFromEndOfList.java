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
        ListNode temp = head; ListNode tmp2 = head;
        while(temp!=null){
            temp=temp.next;
            len++;
        }
        if(len==1 && n==1) return null;
        int dist = len-n;
        if(dist==0) return tmp2.next;
        for(int i =1; i<dist; i++ ) {
            tmp2=tmp2.next;
        }
        tmp2.next = tmp2.next.next;
        return head;
    }
}
