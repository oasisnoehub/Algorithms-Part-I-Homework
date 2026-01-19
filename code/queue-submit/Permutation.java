/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;

import java.util.NoSuchElementException;

public class Permutation {
    public static void main(String[] args) {
        if (args.length < 1) {
            throw new NoSuchElementException("Please input an integer k for output.");
        }
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> words = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            words.enqueue(StdIn.readString());
        }
        if (words.size() < k) {
            throw new IllegalArgumentException("argument k is larger than input size.");
        }
        for (int i = 0; i < k; i++) {
            System.out.println(words.dequeue());
        }
    }
}
