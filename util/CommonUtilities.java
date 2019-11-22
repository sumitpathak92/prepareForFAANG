package util;

import commonDataStructures.ListNode;

public class CommonUtilities {

    public static void arrayPrintHelper(int [] array) {
        for (int n : array) {
            System.out.print( n + " --> ");
        }
        System.out.println(" ");
    }

    public static void linkedListPrintHelper(ListNode listNode) {
        while(listNode!=null) {
            System.out.print(listNode.data + " --> ");
            listNode = listNode.next;
        }
        System.out.println(" ");
    }
}

