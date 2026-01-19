/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;

public class DequeTest {
    public static void main(String[] args) {
        String[] words = StdIn.readAllStrings();
        Deque<String> deque = new Deque<>();
        for (String word : words) {
            deque.addFirst(word);
        }
        for (String word : words) {
            deque.addLast(word);
        }
        
        for (String word : deque) {
            System.out.print(word + " ");
        }
    }
}
