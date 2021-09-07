package leetcode;

/*

LC Easy : https://leetcode.com/problems/palindrome-linked-list/
* **/

import commonDataStructures.ListNode;

import java.util.Stack;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
//        head.next.next.next.next = new ListNode(2);

        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode tmp = head;
        while(tmp!=null) {
            tmp = tmp.next;
            len++;
        }
        System.out.println(len);
        Stack<Integer> st = new Stack<>();
        int c = 1;
        while(c<=len/2 && head!=null) {
            st.push(head.data);
            head = head.next;
            c++;
        }
        if(len%2 != 0) {
            head = head.next;
        }
        while(head!=null) {
            if(st.pop()!=head.data) return false;
            else head = head.next;
        }
        return true;
    }
}
