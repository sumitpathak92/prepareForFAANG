package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
LC Medium : https://leetcode.com/problems/copy-list-with-random-pointer/
* **/
public class CopyListWithRandomPointer {

    public static void main(String[] args) {

    }

    public ListNode copyRandomList(ListNode head) {
        if(head == null) return null;
        Map<ListNode, ListNode> hm = new HashMap<>();
        ListNode curr = head;
        while(curr!=null) {
            hm.put(curr, new ListNode(curr.val));
            curr = curr.next;
        }

        for(Map.Entry<ListNode, ListNode> entry : hm.entrySet()) {
            ListNode newNode = entry.getValue();
            newNode.next = hm.get(entry.getKey().next);
            newNode.random = hm.get(entry.getKey().random);
        }

        return hm.get(head);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode random;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
