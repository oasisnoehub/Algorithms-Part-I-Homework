import java.util.Stack;

class MaxStack {
    private Stack<Double> mainStack;  // Holds the elements
    private Stack<Double> maxStack;   // Holds the maximum elements

    public MaxStack() {
        mainStack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(double value) {
        mainStack.push(value);
        if (maxStack.isEmpty() || value >= maxStack.peek()) {
            maxStack.push(value);
        }
    }

    public double pop() {
        if (mainStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        double poppedValue = mainStack.pop();
        if (poppedValue == maxStack.peek()) {
            maxStack.pop();
        }
        return poppedValue;
    }

    public double getMax() {
        if (maxStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return maxStack.peek();
    }

    public boolean isEmpty() {
        return mainStack.isEmpty();
    }

    public static void main(String[] args) {
        MaxStack stack = new MaxStack();

        stack.push(3.0);
        stack.push(5.0);
        stack.push(2.0);
        stack.push(7.0);

        System.out.println("Max: " + stack.getMax()); // Should print 7.0

        stack.pop();
        stack.pop();

        System.out.println("Max: " + stack.getMax()); // Should print 5.0
    }
}
