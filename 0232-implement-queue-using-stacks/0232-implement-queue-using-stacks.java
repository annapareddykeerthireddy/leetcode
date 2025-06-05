import java.util.Stack;

class MyQueue {
    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    // Constructor
    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    // Push element x to the back of queue.
    public void push(int x) {
        inputStack.push(x);
    }

    // Removes the element from the front of queue and returns it.
    public int pop() {
        shiftStacks();
        return outputStack.pop();
    }

    // Get the front element.
    public int peek() {
        shiftStacks();
        return outputStack.peek();
    }

    // Returns true if the queue is empty.
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    // Helper to move elements only when outputStack is empty
    private void shiftStacks() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();

        myQueue.push(1);                    // Queue: [1]
        myQueue.push(2);                    // Queue: [1, 2]

        System.out.println("Peek: " + myQueue.peek());  // Output: 1
        System.out.println("Pop: " + myQueue.pop());    // Output: 1
        System.out.println("Is Empty: " + myQueue.empty()); // Output: false
    }
}
