/* *****************************************************************************
 *  Name: ylyin
 *  Date: 2023-08-19
 *  Description: Deque (double linked list)
 **************************************************************************** */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int size;

    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        // corner case check
        if (item == null) {
            throw new IllegalArgumentException("Can not add null item!");
        }

        // new node to the first
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = first;
        newNode.prev = null;
        // build the double linked
        if (isEmpty()) {
            last = newNode;
        }
        else {
            first.prev = newNode;
        }
        // move the first pointer
        first = newNode;
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        // corner case check
        if (item == null) {
            throw new IllegalArgumentException("Can not add null item!");
        }
        // new node to the last
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = null;
        newNode.prev = last;

        // build the double linked
        if (isEmpty()) {
            first = newNode;
        }
        else {
            last.next = newNode;
        }
        // move the last pointer
        last = newNode;
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is now empty !");
        }
        Item item = first.item;
        first = first.next;
        size--;

        if (isEmpty()) {
            last = null;
        }
        else {
            first.prev = null;
        }
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is now empty !");
        }
        Item item = last.item;
        last = last.prev;
        size--;

        if (isEmpty()) {
            first = null;
        }
        else {
            last.next = null;
        }
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    // create DequeIterator class
    private class DequeIterator implements Iterator<Item> {

        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("There are no more items to return !");
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove operation is not support !");
        }
    }
    // unit testing (required)

    public static void main(String[] args) {

        Deque<Integer> deque = new Deque<>();

        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(4);
        deque.removeLast();
        deque.addLast(5);
        deque.addLast(6);
        deque.addLast(7);
        deque.addLast(8);
        deque.removeFirst();

        for (Integer item : deque) {
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println("Current Size: " + deque.size());
    }
}
