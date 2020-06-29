public class Lnode<T> implements Comparable<Lnode<T>> {
    public T data;
    public Lnode<T> next;

    public Lnode(T key) {
        data = key;
        next = null;
    }

    public Lnode(T key, Lnode<T> next) {
        data = key;
        this.next = next;
    }

    public boolean equals(Object e) {
        Lnode<T> node = (Lnode<T>) e;
        return data.equals(node.data);
    }

    @Override
    public int compareTo(Lnode<T> e) {
        Comparable<T> x;
        if (data instanceof Comparable) {
            x = (Comparable<T>) data;
            return x.compareTo(e.data);
        } else {
            throw new ClassCastException("类型无法比较！");
        }
    }

    public String toString() {
        return data.toString();
    }
}
