import java.util.Stack;

class QueueWithTwoStacks<T> {
    private Stack<T> enqueueStack;
    private Stack<T> dequeueStack;

    public QueueWithTwoStacks() {
        enqueueStack = new Stack<>();
        dequeueStack = new Stack<>();
    }

    public void enqueue(T item) {
        enqueueStack.push(item);
    }

    public T dequeue() {
        if (dequeueStack.isEmpty()) {
            transferElements();
        }
        if (!dequeueStack.isEmpty()) {
            return dequeueStack.pop();
        }
        return null; // Queue is empty
    }

    private void transferElements() {
        while (!enqueueStack.isEmpty()) {
            dequeueStack.push(enqueueStack.pop());
        }
    }

    public boolean isEmpty() {
        return enqueueStack.isEmpty() && dequeueStack.isEmpty();
    }

    public int size() {
        return enqueueStack.size() + dequeueStack.size();
    }

    public static void main(String[] args) {
        QueueWithTwoStacks<Integer> queue = new QueueWithTwoStacks<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue()); // Should print 1
        System.out.println(queue.dequeue()); // Should print 2

        queue.enqueue(4);

        System.out.println(queue.dequeue()); // Should print 3
        System.out.println(queue.dequeue()); // Should print 4
    }
}


