package aston.hometask.task1;

import java.util.ArrayList;

public class MyHashSet<E> {
    private static final int DEFAULT_CAPACITY = 16;
    private ArrayList<Node<E>> buckets;

    public MyHashSet() {
        this.buckets = new ArrayList<>(DEFAULT_CAPACITY);
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            buckets.add(null);
        }
    }

    public boolean add(E element) {
        if (element == null) {
            return false;
        }
        int bucketIndex = getBucketIndex(element);
        Node<E> head = buckets.get(bucketIndex);
        Node<E> current = head;
        while (current != null) {
            if (current.item.equals(element)) {
                return false;
            }
            current = current.next;
        }
        Node<E> newNode = new Node<>(element);
        if (head == null) {
            buckets.set(bucketIndex, newNode);
        } else {
            Node<E> last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        return true;
    }

    public boolean remove(E element) {
        if (element == null) {
            return false;
        }
        int bucketIndex = getBucketIndex(element);
        Node<E> current = buckets.get(bucketIndex);
        Node<E> previous = null;
        while (current != null) {
            if (current.item.equals(element)) {
                if (previous == null) {
                    buckets.set(bucketIndex, current.next);
                } else {
                    previous.next = current.next;
                }
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    private int getBucketIndex(E element) {
        int hashCode = element.hashCode();
        return Math.abs(hashCode) % buckets.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        boolean firstElement = true;
        for (Node<E> bucket : buckets) {
            Node<E> current = bucket;
            while (current != null) {
                if (!firstElement) {
                    sb.append(", ");
                } else {
                    firstElement = false;
                }
                sb.append(current.item);
                current = current.next;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element) {
            this.item = element;
            this.next = null;
        }
    }
}

