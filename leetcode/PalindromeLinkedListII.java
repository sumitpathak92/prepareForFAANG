package leetcode;

import commonDataStructures.ListNode;

/*
LC Easy : https://leetcode.com/problems/palindrome-linked-list/

Approach 2 - using recursion
* **/
public class PalindromeLinkedListII {

    private static ListNode left;
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        left = head;
        return helper(head);
    }

    public static boolean helper(ListNode head) {
        if(head!=null) {
            if(!helper(head.next)) return false;
            if(head.data != left.data) return false;
            left = left.next;
            System.out.println(head.data);
        }
        return true;
    }
}
