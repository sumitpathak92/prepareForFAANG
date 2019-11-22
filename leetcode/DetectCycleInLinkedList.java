package leetcode;

import commonDataStructures.ListNode;

import java.util.HashMap;
import java.util.HashSet;

public class DetectCycleInLinkedList {

    public static void main(String [] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = head.next;
        System.out.println("the linked list has cycle " + hasCycleApproachOne(head));
        System.out.println("the linked list has cycle " + hasCycleApproachTwo(head));
    }

    static boolean hasCycleApproachOne(ListNode head) {
        // approach one : using hashset
        HashSet<ListNode> hs = new HashSet<>();
        while(head!=null) {
            System.out.println(head.data);
            if(hs.contains(head)) return true;
            hs.add(head);
            head = head.next;
        }
        return false;
    }

    static boolean hasCycleApproachTwo(ListNode head) {
        // approach two: floyd warshall algorithm
        // using two pointers, fast and slow
        ListNode fast = head, slow = head;
        while(fast!=null){
            if(fast.next != null) {
                fast = fast.next.next;
            }
            else return false;
            slow = slow.next;
            if(slow == fast) return true;
        }
        return false;
    }
}
