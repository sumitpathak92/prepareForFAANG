package commonDataStructures;

public class ListNode {

    public int data;
    public ListNode next;

    public ListNode(int d) {
        this.data = d;
        this.next = null;
    }
    public ListNode(int d, ListNode next) { this.data = d; this.next = next; }
}
