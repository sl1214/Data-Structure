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
        if (a instanceof Comparable && b instanceof Comparable) {
            return ((Comparable) a).compareTo((Comparable) b);
        } else {
            return ((String) a).compareTo((String) b);
        }
    }


    @Override
    public int indexOf(int begin, int end, Object x) {
        if (x == null) {
            for (int i = begin; i <= end; i++) {
                if (data[i] == x) {
                    return i;
                }
            }
        } else {
            for (int i = begin; i <= end; i++) {
                if (x.equals(data[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void addSort(T x) {
        insertOrder(length, x);
        length++;
    }

    @Override
    public void add(int i, T x) {
        if (length == data.length) {
            grow();
        }
        if (i < 0) {
            i = 0;
        }
        if (i > length) {
            i = length;
        }
        for (int j = length - 1; j >= i; j++) {
            data[j + 1] = data[j];
        }
        data[i] = x;
        length++;
    }

    public void sort() {
        for (int i = 1; i < length; i++) {
            insertOrder(i, data[i]);
        }
    }

    protected void insertOrder(int end, T x) {
        if (length == data.length) {
            grow();
        }
        int k;
        for (k = end - 1; k >= 0; k--) {
            if (compare(x, data[k]) < 0) {
                data[k + 1] = data[k];
            } else {
                break;
            }
        }
        data[k + 1] = x;
    }

    public String toString() {
        StringBuilder strb = new StringBuilder();
        strb.append("(");
        for (int i=0;i<length-1;i++) {
            strb.append(data[i].toString()).append(",");
        }
        strb.append(data[length - 1]).append(")");
        return new String(strb);
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.data, this.length);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < length) {
            return (T[]) Arrays.copyOf(this.data, this.length, a.getClass());
        }
        System.arraycopy(this.data,0,a,0,this.length);
        if (a.length > this.length) {
            for (int i = this.length;i<a.length;i++) {
                a[i] = null;
            }
        }
        return a;
    }

    @Override
    public boolean remove(Object o) {
        remove(indexOf(o));
        return true;
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
        for (int i = 0; i < length - 1; i++) {
            data[i] = null;
            length = 0;
        }
    }

    @Override
    public T remove(int i) {
        if (i < 0 || i > length - 1) {
            throw new IndexOutOfBoundsException("下标越界：i=" + i);
        }
        T oldData = data[i];
        for (int j = i; j < length - 2; j++) {
            data[j] = data[j + 1];
        }
        data[length - 1] = null;
        return oldData;
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
