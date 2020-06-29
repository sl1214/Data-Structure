import java.util.List;

public abstract class AbsList<T> implements Iterable<T>, List<T> {
    protected int length;

    public abstract T get(int i);

    public abstract int indexOf(int begin, int end, Object x);

    public abstract void add(int i, T x);

    public abstract void clear();

    public abstract T remove(int i);

    public abstract Iterable<T> iterable();

    public boolean isEmpty() {
        return length == 0;
    }

    public int length() {
        return length;
    }

    public boolean add(T x) {
        add(length, x);
        return true;
    }

    public void append(T x) {
        add(length, x);
    }

    public int indexOf(Object o) {
        return indexOf(0, length, o);
    }

    public int indexOf(int begin, T o) {
        return indexOf(begin, length, o);
    }

    public T remace(T o) {
        return remove(indexOf(o));
    }
}
