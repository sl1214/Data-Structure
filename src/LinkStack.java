public class LinkStack<T> extends LinkList<T> implements Stack<T>{

    public LinkStack() {
        super();
    }

    @Override
    public T getTop() {
        return get(0);
    }

    @Override
    public void push(T x) {
        addFront(x);
    }

    @Override
    public T pop() {
        return remove(0);
    }
}
