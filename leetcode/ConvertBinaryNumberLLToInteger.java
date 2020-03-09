//Problem statement

/*
 * Given head which is a reference node to a singly-linked list.
 * The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
 *
 * Return the decimal value of the number in the linked list.
 * */


/*
*
* Input: head = [1,0,1]
  Output: 5
  Explanation: (101) in base 2 = (5) in base 10

**/

package leetcode;

import commonDataStructures.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ConvertBinaryNumberLLToInteger {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(0);
//        head.next.next = new ListNode(1);
        System.out.println(getDecimalValue(head));
    }

    public static int getDecimalValue(ListNode head) {
        List<Integer> data = new ArrayList<>();
        while(head!=null) {
            data.add(head.data);
            head=head.next;
        }
        StringBuffer sb = new StringBuffer();

        for (int s : data) {
            sb.append(s);
        }
        System.out.println(sb);
        return Integer.parseInt(String.valueOf(sb), 2);
    }
}
