import java.lang.reflect.Array;
import java.util.*;

public class LinkList<T> extends AbsList<T> implements Iterator<T> {

    Lnode<T> first;
    Lnode<T> last;
    Iterator<T> iterator = null;

    public LinkList() {
        first = null;
        last = null;
        this.iterator = new LinkIterator();
    }

    private int compare(Lnode<T> a, Lnode<T> b) {
        return a.compareTo(b);
    }

    protected Lnode<T> getNode(int i) {
        Lnode<T> x = null;
        for (x = first; x != null && i >= 0 && i < length; i--) {
            x = x.next;
        }
        return x;
    }

    @Override
    public T get(int i) {
        Lnode<T> p = getNode(i);
        if (p == null) {
            return null;
        } else {
            return p.data;
        }
    }

    @Override
    public T set(int index, T element) {
        Lnode<T> p = getNode(index);
        if (p == null) {
            return null;
        } else {
            T oldData = p.data;
            p.data = element;
            return oldData;
        }
    }

    @Override
    public int indexOf(int begin, int end, Object x) {
        Lnode<T> node = getNode(begin);
        while (begin <= end && node != null) {
            if (x == null && node.data == null) {
                return begin;
            }
            if (node.data.equals(x)) {
                return begin;
            }
            begin++;
            node = node.next;
        }
        return -1;
    }

    @Override
    public void add(int i, T x) {
        Lnode<T> s;
        s = new Lnode<T>(x, null);
        if (first == null || length == 0) {
            first = s;
            last = s;
        } else if (i < 1) {
            s.next = first;
            first = s;
        } else if (i >= length) {
            last.next = s;
            last = s;
        } else {
            Lnode<T> p = getNode(i - 1);
            s.next = p.next;
            p.next = s;
        }
        length++;
    }

    public boolean add(T key) {
        this.add(length, key);
        return true;
    }

    public void addBack(T x) {
        this.add(length, x);
    }

    public void Front(T x) {
        this.add(0, x);
    }

    public void insertBefore(Lnode<T> first, Lnode<T> p, T x) {
        Lnode<T> lnode = new Lnode<T>(x);
        if (p == first) {
            lnode.next = p;
            this.first = lnode;
        } else {
            Lnode<T> q = first;
            while (q.next != p) {
                q = q.next;
            }
            lnode.next = p;
            q.next = lnode;
        }
    }

    public void sort() {
        if (first == null) {
            return;
        } else {
            Lnode<T> node = first.next;
            first.next = null;
            while (node != null) {
                Lnode<T> s = node.next;
                insertOrder(node);
                node = s;
            }

        }
    }

    public void addSort(T e) {
        Lnode<T> s = new Lnode<T>(e);
        this.insertOrder(s);
    }

    private void insertOrder(Lnode<T> s) {
        if (first == null) {
            first = s;
        } else if (s.compareTo(first) <= 0) {
            s.next = first;
            first = s;
        } else if (s.compareTo(last) >= 0) {
            last.next = s;
            last = s;
        } else {
            Lnode<T> node = first;
            while (node != null) {
                if (node.compareTo(s) <= 0 && node.next.compareTo(s) >= 0) {
                    s.next = node.next;
                    node.next = s;
                    break;
                }
                node = node.next;
            }
        }
    }

    protected Lnode<T> removeNode(int i) {
        Lnode<T> q;
        if (i == 0) {
            q = first;
            first = first.next;
        } else {
            Lnode<T> p = getNode(i - 1);
            q = p.next;
            p.next = p.next.next;
        }
        return q;
    }

    public T search(T key) {
        Lnode<T> node = getNode(0);
        int i = 0;
        while (i <= length - 1 && node != null) {
            if (key == null && node.data == null) {
                return key;
            }
            if (node.data.equals(key)) {
                return key;
            }
            i++;
            node = node.next;
        }
        return null;
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] a = new Object[length];
        Lnode<T> p = first;
        for (int i = 0; i < length; i++) {
            a[i] = p.data;
            p = p.next;
        }
        return a;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        Lnode<T> p = (Lnode<T>) this.first;
        if (a.length < length) {
            a = (T[]) Array.newInstance(a.getClass().getComponentType(), length);
        }
        for (int i = 0; i < length; i++) {
            a[i] = p.data;
            p = p.next;
        }
        return a;
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
        this.clear();
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        for (Lnode<T> x = first; x != null; ) {
            Lnode<T> next = x.next;
            x.data = null;
            x.next = null;
            x = next;
        }
        first = last = null;
    }

    @Override
    public T remove(int i) {
        T oldData = null;
        for (Lnode<T> x = first; x != null; ) {
            if (i == 1) {
                oldData = x.next.data;
                x.next = x.next.next;
                break;
            }
            x = x.next;
            i--;
        }
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
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        this.iterator = new LinkIterator();
        return this.iterator;
    }

    private class LinkIterator implements Iterator<T> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }
    }
}
