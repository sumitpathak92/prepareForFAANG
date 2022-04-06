package leetcode;
import commonDataStructures.ListNode;

public class RotateLinkedListByKPlaces {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(rotateRight(head, 2).next.next.next.next.data);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        ListNode tmp = head;
        ListNode tmp1 = head;
        int len = 1;
        while(tmp.next!=null) {
            tmp = tmp.next;
            len++;
        }

        System.out.println("length :::  "+tmp.data);
        int cutAt = len - k%len;
        for(int i = cutAt; i>1; i--) {
            tmp1 = tmp1.next;
        }
        System.out.println("head reached at :::  "+head.data);
        tmp.next = head;
        head = tmp1.next;
        tmp1.next = null;
        return head;
    }

    static ListNode helper(ListNode head) {
        ListNode prev = null; ListNode curr = head;
        while(curr.next!=null){
            prev = curr;
            curr = curr.next;
        }
        curr.next = head;
        prev.next = null;
        return curr;
    }
}
