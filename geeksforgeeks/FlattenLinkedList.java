package geeksforgeeks;

public class FlattenLinkedList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(5);
        n1.bottom = new ListNode(7);
        n1.bottom.bottom = new ListNode(8);
        n1.bottom.bottom.bottom = new ListNode(30);
        n1.next = new ListNode(10);

        ListNode n2 = n1.next;
        n2.bottom = new ListNode(20);
        n2.next = new ListNode(19);

        ListNode n3 = n2.next;
        n3.bottom = new ListNode(22);
        n3.bottom.bottom = new ListNode(28);
        n3.bottom.bottom.bottom = new ListNode(35);

        System.out.println(flattenList(n1).bottom.bottom.bottom.bottom.data);

    }

    static ListNode flattenList(ListNode root) {
        if(root==null || root.next == null) return root;

        root.next = flattenList(root.next);
        root = mergeLists(root, root.next);
        return root;
    }

    static ListNode mergeLists(ListNode a, ListNode b) {
        ListNode tmp = new ListNode(0); ListNode res = tmp;
        while(a!=null && b!=null) {
            if(a.data<b.data) {
                tmp.bottom = a;
                tmp = tmp.bottom;
                a = a.bottom;
            } else {
                tmp.bottom = b;
                tmp = tmp.bottom;
                b = b.bottom;
            }
        }
        if(a!=null) tmp.bottom = a;
        else tmp.bottom = b;
        return res.bottom;
    }
}

class ListNode {
    int data;
    ListNode next;
    ListNode bottom;

    public ListNode(int data) {
        this.data = data;
    }
}
