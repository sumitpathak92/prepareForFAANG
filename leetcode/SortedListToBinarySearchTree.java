package leetcode;

import commonDataStructures.ListNode;
import commonDataStructures.TreeNode;

import java.util.Arrays;

/*
LC Medium : https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
* **/
public class SortedListToBinarySearchTree {

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        System.out.println(sortedListToBST(head).left.val);
    }

    public static TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ListNode tmp = head; int count = 0;
        while(tmp!=null) {
            count++;
            tmp=tmp.next;
        }
        int[] A = new int[count]; int i=0;
        while(head!=null) {
            A[i++] = head.data;
            head = head.next;
        }
        return helper(A, 0, count-1);
    }

    private static TreeNode helper(int[] A, int l, int r) {
        if(l>r) return null;
        int mid = l+(r-l)/2;
        TreeNode root = new TreeNode(A[mid]);
        root.left = helper(A, l, mid-1);
        root.right = helper(A, mid+1, r);
        return root;
    }
}
