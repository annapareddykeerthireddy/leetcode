import java.util.Stack;

class MyQueue {
    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    
    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

   
    public void push(int x) {
        inputStack.push(x);
    }
 
    public int pop() {
        shiftStacks();
        return outputStack.pop();
    }

    
    public int peek() {
        shiftStacks();
        return outputStack.peek();
    }

    
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    
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

        myQueue.push(1);                   
        myQueue.push(2);                    

        System.out.println("Peek: " + myQueue.peek());  
        System.out.println("Pop: " + myQueue.pop());    
        System.out.println("Is Empty: " + myQueue.empty()); 
    }
}
