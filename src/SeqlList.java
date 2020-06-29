import java.util.*;

public class SeqlList<T> extends AbsList<T> {

    private int incrementSize;

    protected T[] data;

    public SeqlList() {
        this(16);
    }

    public SeqlList(int capacity) {
        if (capacity <= 0) {
            capacity = 16;
        }
        length = 0;
        incrementSize = 0;
        data = (T[]) new Object[capacity];
    }

    public SeqlList(T[] elem) {
        length = elem.length;
        incrementSize = 0;
        data = Arrays.copyOf(elem, length);
    }

    public void setIncr(int inc) {
        incrementSize = inc;
    }

    public void setCapacity(int newSize) {
        data = Arrays.copyOf(data, newSize);
    }

    public int getCapacity() {
        return data.length;
    }

    private void grow() {
        int newSzie = data.length + incrementSize;
        data = Arrays.copyOf(data, newSzie);
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public T get(int i) {
        if (i < 0 || i > length - 1) {
            return null;
        } else {
            return data[i];
        }
    }

    @Override
    public T set(int i, T x) {
        if (i < 0 || i > length - 1) {
            return null;
        } else {
            T oldValue = data[i];
            data[i] = x;
            return oldValue;
        }
    }

    private int compare(T a, T b) {
        return 0;
    }


    @Override
    public int indexOf(int begin, int end, Object x) {
        return 0;
    }

    public void addSort(T x) {
    }

    @Override
    public void add(int i, T x) {
        if (length == data.length) {
            grow();
        }
        if (i<0) {
            i = 0;
        }
        if (i>length) {
            i = length;
        }
        for (int j = length-1;j>=i;j++) {
            data[j+1] = data[j];
        }
        data[i] = x;
        length++;
    }

    public void sort() {
    }

    protected void insertOrder(int end, T x) {
    }

    public String toString() {
        return null;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T remove(int i) {
        return null;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Iterable<T> iterable() {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator<T> {
        private int index = 0;

        public boolean hasNext() {
            return index != length();
        }

        public T next() {
            return get(index++);
        }

        public void remove() {

        }

    }
}
