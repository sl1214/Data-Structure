public class SeqStack<T> {
    private Integer length = 0;
    private SeqlList<T> seqlList;
    public SeqStack(int num){
        seqlList = new SeqlList<T>(num);
    }
    boolean isEmpty() {
        return seqlList.isEmpty();
    }
    public void push(T x) {
        seqlList.add(x);
        length++;
    }

    public T pop() {
        length--;
        return seqlList.remove(seqlList.length-1);
    }

    public T getTop() {
        length--;
        return seqlList.get(seqlList.length-1);
    }

    public T[] toArray(T a[]) {
        return seqlList.toArray(a);
    }

    public Integer getLength(){
        return length;
    }
}
