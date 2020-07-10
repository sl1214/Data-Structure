import java.util.Objects;

public class SeqQue<T> implements Queue<T> {

    private int front;

    private int rear;

    private int maxSize;

    Object[] data;

    public SeqQue(int maxQueueSize) {
        maxSize = maxQueueSize;
        front = 0;
        rear = 0;
        data = new Object[maxSize];
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    @Override
    public T getHead() {
        return (T) data[front];
    }

    @Override
    public void add(T x) throws IllegalAccessException {
        if (isFull()) {
            throw new IllegalAccessException("队列已满");
        }
        data[rear] = x;
        rear = (rear + 1) % maxSize;
    }

    @Override
    public T remove() {
        T x = (T) data[front];
        data[front] = null;
        front = (front + 1) % maxSize;
        return x;
    }
}
