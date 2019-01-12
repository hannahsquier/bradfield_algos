public interface MyQueue<T> {
   
    boolean isEmpty();

    void enqueue(T item);

    T dequeue();

    int size();

}