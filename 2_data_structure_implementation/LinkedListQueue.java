import java.util.*;

public class LinkedListQueue<T> implements MyQueue<T> { 
    private static class Node<T> {
        Node<T> next;
        T val;

        Node(T val) {
            this.val = val;
            this.next = null;
        }
    }

    Node<T> head;
    Node<T> tail;
    int size;

    LinkedListQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(T item) {
        Node<T> newNode = new Node(item);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T dequeue() {
        Node<T> item = head;
        head = head.next;
        size--;
        return item.val;
    }

    @Override
    public int size() {
        return size;
    }
    
   public static void main(String[] args) { 
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        linkedListQueue.enqueue(1);
        linkedListQueue.enqueue(2);
        linkedListQueue.enqueue(3);
        linkedListQueue.enqueue(4);

        System.out.println(linkedListQueue.size() == 4 ? "PASS" : "FAIL");
        System.out.println(linkedListQueue.dequeue() == 1 ? "PASS" : "FAIL");
        System.out.println(linkedListQueue.size() == 3 ? "PASS" : "FAIL");

        linkedListQueue.enqueue(5);
        
        System.out.println(linkedListQueue.dequeue() == 2 ? "PASS" : "FAIL");
        System.out.println(linkedListQueue.dequeue() == 3 ? "PASS" : "FAIL");
        System.out.println(linkedListQueue.size() == 2 ? "PASS" : "FAIL");
   }
}