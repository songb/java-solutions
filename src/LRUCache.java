import java.util.*;

public class LRUCache {
    Map<Integer, DoubleLinkedNode> map;
    DoubleLinkedNode head, tail;
    int c;
    int room;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        c = capacity;
        room = 0;
    }

    public int get(int key) {
        DoubleLinkedNode val = map.get(key);
        if (val != null) {
            if (tail == val && val.pre != null) {
                tail = val.pre;
            }
            if (head != val) {
                moveToHead(val);
            }
            return val.v;
        } else {
            return -1;
        }

    }

    public void set(int key, int value) {
        DoubleLinkedNode val = map.get(key);
        if (val == null) {
            if (room == c) {
                map.remove(tail.k);
                if (tail.pre != null)
                    tail.pre.next = null;
                tail = tail.pre;
                room--;
            }
            val = new DoubleLinkedNode();
            val.v = value;
            val.k=key;
            if (head != null) {
                head.pre = val;
            }
            if (tail == null)
                tail = val;
            val.next = head;
            head = val;
            map.put(key, val);
            room++;
        } else {
            val.v = value;
            if (head != val)
                moveToHead(val);
        }


    }

    private void moveToHead(DoubleLinkedNode node) {
        if (node.pre != null)
            node.pre.next = node.next;
        if (node.next != null)
            node.next.pre = node.pre;
        node.next = head;
        head.pre = node;
        node.pre = null;
        head = node;
    }

    private static class DoubleLinkedNode {
        int v;
        int k;
        DoubleLinkedNode next;
        DoubleLinkedNode pre;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DoubleLinkedNode that = (DoubleLinkedNode) o;
            return v == that.v;
        }

        @Override
        public int hashCode() {
            return Objects.hash(v);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.set(6, 1);
        cache.set(2, 1);
        cache.set(2, 2);
        System.out.println(cache.get(2));
        cache.set(1, 1);
        cache.set(4, 1);
        System.out.println(cache.get(2));
    }
}
