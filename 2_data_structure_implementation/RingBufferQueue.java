import java.util.*;

public class RingBufferQueue<T> implements MyQueue<T> { 
    
    private Object[] arr;
    private int load;
    private int unload;

    RingBufferQueue(int capacity) {
        this.arr = new Object[capacity];
        this.load = 0;
        this.unload = 0;
    }

    @Override
    public boolean isEmpty() {
        return load == unload;
    }

    @Override
    public void enqueue(T item) {
        arr[load] = item;
        load = load == 0 ? arr.length - 1 : load - 1;
    }

    @Override
    public T dequeue() {
        T item = (T) arr[unload];
        unload = unload == 0 ? arr.length - 1 : unload - 1;
        return item;
    }

    @Override
    public int size() {
        if (load <= unload) {
            return this.unload - this.load;
        } else {
            return arr.length - this.load + this.unload;
        }

    }
    
   public static void main(String[] args) { 
        RingBufferQueue<Integer> ringBufferQueue = new RingBufferQueue<>(5);
        ringBufferQueue.enqueue(1);
        ringBufferQueue.enqueue(2);
        ringBufferQueue.enqueue(3);
        ringBufferQueue.enqueue(4);

        System.out.println(ringBufferQueue.size() == 4 ? "PASS" : "FAIL");
        System.out.println(ringBufferQueue.dequeue() == 1 ? "PASS" : "FAIL");
        System.out.println(ringBufferQueue.size() == 3 ? "PASS" : "FAIL");

        ringBufferQueue.enqueue(5);
        
        System.out.println(ringBufferQueue.dequeue() == 2 ? "PASS" : "FAIL");
        System.out.println(ringBufferQueue.dequeue() == 3 ? "PASS" : "FAIL");
        System.out.println(ringBufferQueue.size() == 2 ? "PASS" : "FAIL");
   }
}