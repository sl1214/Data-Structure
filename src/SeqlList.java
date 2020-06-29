import java.util.*;

public class SeqlList<T> extends AbsList<T> {

    private int incrementSize;
    protected T[] data;
    public SeqlList(){
        this(16);
    }
    public SeqlList(int capacity){
        if (capacity <= 0) {
            capacity = 16;
        }
        length = 0;
        incrementSize = 0;
        data = (T[]) new Object[capacity];
    }
    public SeqlList(T[] elem){
        length = elem.length;
        incrementSize = 0;
        data = Arrays.copyOf(elem,length);
    }

    public void setInc(int inc) {}

    public void setCapacity(int newSize){}

    public int getCapacity(){return data.length;}

    @Override
    public int size(){return length;}

    @Override
    public T get(int i){return data[i];}

    @Override
    public T set(int i, T x) {
        return null;
    }

    private int compare(T a,T b){return 0;}


    @Override
    public int indexOf(int begin, int end, Object x) {
        return 0;
    }

    private void grow(){}

    public void addSort(T x){}

    @Override
    public void add(int i, T x) {

    }

    public void sort(){}

    protected void insertOrder(int end,T x){}

    public String toString(){return null;}

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

    class MyIterator implements Iterator<T>{
        private int index = 0;

        public boolean hasNext(){
            return index != length();
        }

        public T next(){
            return get(index++);
        }

        public void remove(){

        }

    }
}
