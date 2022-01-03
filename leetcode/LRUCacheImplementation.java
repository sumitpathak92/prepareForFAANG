package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * LC Medium : https://leetcode.com/problems/lru-cache/
 * **/
public class LRUCacheImplementation {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }

}

class LRUCache {

    class Node {
        Node next, prev;
        int key, val;
        Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    int capacity;
    Map<Integer, Node> map;
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0,0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node n = map.get(key);
        delete(n);
        insert(n);
        return n.val;
    }

    private void insert(Node node) {
        map.put(node.key, node);
        Node headN = head.next;
        head.next = node;
        node.prev = head;
        headN.prev = node;
        node.next = headN;
    }

    private void delete(Node n) {
        map.remove(n.key);
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            delete(map.get(key));
            insert(new Node(key, value));
        }
        else if(map.size()==capacity) {
            delete(tail.prev);
            insert(new Node(key, value));
        } else {
            insert(new Node(key, value));
        }
    }

}
