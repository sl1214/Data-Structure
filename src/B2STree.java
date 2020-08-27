public class B2STree<T extends Comparable<T>> {

    private int num;
    private B2SNode<T> root;

    public B2STree() {
        root = null;
    }

    public B2STree(B2SNode<T> root) {
        this.root = root;
    }

    public int size() {
        return num;
    }

    //前序遍历，调用preOrderByRecursion完成
    public SeqlList<T> preOrder() {
        SeqlList<T> preSeq = new SeqlList<T>(size());
        preOrderByRecursion(root,preSeq);
        return preSeq;
    }

    private void preOrderByRecursion(B2SNode<T> root, SeqlList<T> preSeq) {
        if (root != null) {
            preSeq.add(root.data);
            preOrderByRecursion(root.lChild,preSeq);
            preOrderByRecursion(root.rChild,preSeq);
        }
    }

    //中序遍历，调用inOrderByRecursion完成
    public SeqlList<T> inOrder() {
        SeqlList<T> inSeq = new SeqlList<T>(size());
        inOrderByRecursion(root,inSeq);
        return inSeq;
    }

    //中序遍历
    private void inOrderByRecursion(B2SNode<T> root, SeqlList<T> inSeq) {
        if (root != null) {
            preOrderByRecursion(root.lChild,inSeq);
            inSeq.add(root.data);
            preOrderByRecursion(root.rChild,inSeq);
        }
    }


    //后序遍历，调用postOrderByRecursion完成
    public SeqlList<T> postOrder() {
        SeqlList<T> postSeq = new SeqlList<T>(size());
        postOrderByRecursion(root,postSeq);
        return postSeq;
    }

    //后序遍历
    private void postOrderByRecursion(B2SNode<T> root, SeqlList<T> postSeq) {
        if (root != null) {
            preOrderByRecursion(root.lChild,postSeq);
            preOrderByRecursion(root.rChild,postSeq);
            postSeq.add(root.data);
        }
    }

    public String toString() {
        return inOrder().toString();
    }

    //求二叉树的最大值
    public T max() {
        //todo
        return null;
    }

    //求二叉树的最小值
    public T min() {
        //todo
        return null;
    }

    //在二叉树中查找包含值为key的节点，若存在则返回key本身，不存在则返回null
    public T search(T key) {
        //todo
        return null;
    }

    //在二叉树中查找包含值为key的节点，若存在则返回true，不存在则返回false
    public boolean contains(T key) {
        return false;
    }

    //向二叉树中插入值为Key的节点
    public void add(T key) {

    }

    //从二叉树中删除值为key的节点
    public void remove(T key) {

    }
}
