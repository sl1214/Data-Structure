public class SeqStack<T> {
    private SeqlList<T> seqlList;
    public SeqStack(int num){
        seqlList = new SeqlList<T>(num);
    }
    boolean isEmpty() {
        return seqlList.isEmpty();
    }
    public void push(T x) {
        seqlList.add(x);
    }

    public T pop() {
        return seqlList.remove(seqlList.length-1);
    }

    public T getTop() {
        return seqlList.get(seqlList.length-1);
    }

    public T[] toArray(T a[]) {
        return seqlList.toArray(a);
    }
}
