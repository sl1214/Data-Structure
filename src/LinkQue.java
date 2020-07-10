public class LinkQue<T> extends LinkList<T>{
    public LinkQue() {
        super();
    }

    public boolean isFull() {
        return false;
    }

    public T getHead() {
        return remove(0);
    }



}