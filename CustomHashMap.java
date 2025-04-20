import java.util.*;

public class CustomHashMap<K, V> {

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity = 16; // default bucket size
    private Node<K, V>[] buckets;

    public CustomHashMap() {
        buckets = new Node[capacity];
    }

    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    // put(key, value)
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        Node<K, V> head = buckets[index];

        // update if key exists
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // insert new node at the head
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        Node<K, V> head = buckets[index];

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return null; // not found
    }

    public void remove(K key) {
        int index = getBucketIndex(key);
        Node<K, V> head = buckets[index];
        Node<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = head.next;
                } else {
                    prev.next = head.next;
                }
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    public void printMap() {
        for (int i = 0; i < capacity; i++) {
            Node<K, V> head = buckets[i];
            System.out.print("Bucket " + i + ": ");
            while (head != null) {
                System.out.print("[" + head.key + "=" + head.value + "] -> ");
                head = head.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("orange", 30);
        map.put("apple", 40); // update

        System.out.println("apple: " + map.get("apple"));   // 40
        System.out.println("banana: " + map.get("banana")); // 20

        map.remove("banana");
        System.out.println("banana after remove: " + map.get("banana")); // null

        map.printMap(); // visualize
    }
}
