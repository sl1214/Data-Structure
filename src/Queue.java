public interface Queue<T> {
    boolean isEmpty();
    boolean isFull();
    T getHead();
    void add(T x) throws IllegalAccessException;
    T remove();
}
