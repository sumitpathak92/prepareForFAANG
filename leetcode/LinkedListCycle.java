package leetcode;

import commonDataStructures.ListNode;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

/**
 * LC Easy : https://leetcode.com/problems/linked-list-cycle/
 * **/
public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();
        visited.add(head);
        while(head!=null) {
            head = head.next;
            if(visited.contains(head)) {
                return true;
            }else {
                visited.add(head);
            }
        }
        return false;
    }
}

