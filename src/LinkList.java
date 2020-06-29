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
        for (x = first; x != null && i > 0 && i<length; i--) {
            x = x.next;
        }
        return x;
    }

    @Override
    public T get(int i) {
        Lnode<T> p = getNode(i);
        if ( p == null) {
            return null;
        } else {
            return p.data;
        }
    }

    @Override
    public T set(int index, T element) {
        Lnode<T> p = getNode(index);
        if ( p == null) {
            return null;
        } else {
            T oldData = p.data;
            p.data = element;
            return oldData;
        }
    }

    @Override
    public int indexOf(int begin, int end, Object x) {
        return 0;
    }

    @Override
    public void add(int i, T x) {

    }

    public void addBack(T x) {

    }

    public void Front(T x) {

    }

    public void sort() {
    }

    public void addSort() {
    }

    private void insertOrder(Lnode<T> s) {

    }

    protected Lnode<T> removeNode(int i) {
        return null;
    }

    public T search(T key) {
        return null;
    }


    @Override
    public int size() {
        return 0;
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
        return null;
    }

    private class LinkIterator implements Iterator<T> {

    }
}
