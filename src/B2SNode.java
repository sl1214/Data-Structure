public class B2SNode<T extends Comparable<T>> implements Comparable<B2SNode<T>>{

    protected T data;
    protected B2SNode<T> lChild;
    protected B2SNode<T> rChild;

    public B2SNode() {
        data = null;
        lChild = null;
        rChild = null;
    }

    public B2SNode(T key) {
        data = key;
        lChild = null;
        rChild = null;
    }

    public B2SNode(T key, B2SNode<T> lChild,B2SNode<T> rChild) {
        data = key;
        this.lChild = lChild;
        this.rChild = rChild;
    }

    public boolean equals(B2SNode<T> e) {
        return data.equals(e);
    }

    public String toString(){
        return data.toString();
    }

    @Override
    public int compareTo(B2SNode<T> o) {
        return data.compareTo(o.data);
    }
}
