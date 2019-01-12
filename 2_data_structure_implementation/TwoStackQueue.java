import java.util.*;

public class TwoStackQueue<T> implements MyQueue<T> { 
    private Stack<T> enqueueStack;
    private Stack<T> dequeueStack;

    TwoStackQueue() {
        this.enqueueStack = new Stack<>();
        this.dequeueStack = new Stack<>();
    }

    @Override
    public boolean isEmpty() {
        return enqueueStack.isEmpty() && dequeueStack.isEmpty();
    }

    @Override
    public void enqueue(T item) {
        enqueueStack.add(item);
    }

    @Override
    public T dequeue() {
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) dequeueStack.add(enqueueStack.pop());
        }
        return dequeueStack.pop();
    }

    @Override
    public int size() {
        return enqueueStack.size() + dequeueStack.size();
    }
    
   public static void main(String[] args) { 
        TwoStackQueue<Integer> twoStackQueue = new TwoStackQueue<>();
        twoStackQueue.enqueue(1);
        twoStackQueue.enqueue(2);

        System.out.println(twoStackQueue.size() == 2 ? "PASS" : "FAIL");
        System.out.println(twoStackQueue.dequeue() == 1 ? "PASS" : "FAIL");
        System.out.println(twoStackQueue.size() == 1 ? "PASS" : "FAIL");

        twoStackQueue.enqueue(3);
        
        System.out.println(twoStackQueue.dequeue() == 2 ? "PASS" : "FAIL");
        System.out.println(twoStackQueue.dequeue() == 3 ? "PASS" : "FAIL");
        System.out.println(twoStackQueue.size() == 0 ? "PASS" : "FAIL");
   }
}