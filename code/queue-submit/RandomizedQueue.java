/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description: RandomizedQueue
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Node<Item> first;
    private int size;

    private class Node<Item> {
        Item item;
        Node<Item> next;
    }

    // construct an empty randomized queue
    public RandomizedQueue() {
        first = null;
        size = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item (enqueue add the item to the first)
    public void enqueue(Item item) {
        if (item == null) {
            throw new NoSuchElementException("Enqueue Null is not allowed!");
        }
        Node<Item> newNode = new Node<Item>();
        newNode.item = item;
        newNode.next = first;
        first = newNode; // update the first pointer
        size++;
    }

    // remove and return a random item
    public Item dequeue() {
        // corner case
        if (isEmpty()) {
            throw new NoSuchElementException("RandomizedQueue is empty.");
        }
        int randomIndex = StdRandom.uniformInt(size);
        if (randomIndex == 0) {
            return dequeueFirst();
        }
        else {
            Node<Item> prev = getNodeAtIndex(randomIndex - 1);
            Node<Item> cur = prev.next;
            prev.next = cur.next;
            size--;
            return cur.item;
        }
    }

    private Item dequeueFirst() {
        Item res = first.item;
        first = first.next;
        size--;
        return res;
    }

    private Node<Item> getNodeAtIndex(int index) {
        Node<Item> cur = first;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        int randomIndex = StdRandom.uniformInt(size);
        return getNodeAtIndex(randomIndex).item;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {

        private int currentIndex = 0;
        private int[] randomIndices;

        public RandomizedQueueIterator() {
            // initialize the indices for Queue
            randomIndices = new int[size];
            for (int i = 0; i < size; i++) {
                randomIndices[i] = i;
            }
            // shuffle the indices to achieve the uniformly random order
            for (int i = size - 1; i > 0; i--) {
                int j = StdRandom.uniformInt(i + 1);
                swap(randomIndices, i, j);
            }
        }

        public boolean hasNext() {
            return currentIndex < size;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more items in the RandomizedQueue.");
            }
            return getNodeAtIndex(randomIndices[currentIndex++]).item;
        }

        private void swap(int[] array, int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        public void remove() {
            throw new UnsupportedOperationException("Unsupport remove operation!");
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println("size: " + queue.size());
        Integer dequeue = queue.dequeue();
        System.out.println("random dequeue: " + dequeue);
        System.out.println("size: " + queue.size());
        System.out.println("random get : " + queue.sample());
    }
}
