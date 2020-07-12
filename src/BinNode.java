public class BinNode<T> {
    T data;
    BinNode<T> lChild;
    BinNode<T> rChild;

    public void preOrder(BinNode<T> root) {
        if (root != null) {
            System.out.println(root);
            preOrder(root.lChild);
            preOrder(root.rChild);
        }
    }

    public void inOrder(BinNode<T> root) {
        inOrder(root.lChild);
        System.out.println(root);
        inOrder(root.rChild);
    }

    public void postOrdeer(BinNode<T> root) {
        postOrdeer(root.lChild);
        postOrdeer(root.rChild);
        System.out.println(root);
    }

    public void order(BinNode<T> root) {
        LinkQue<BinNode> que = new LinkQue<BinNode>();
        que.add(root);
        while (!que.isEmpty()) {
            BinNode p = que.getHead();
            visit(p);
            if (p.lChild != null) {
                que.add(p.lChild);
            }
            if (p.rChild != null) {
                que.add(p.rChild);
            }
        }
    }

    public void visit(BinNode<T> node) {
        System.out.println(node.data.toString());
    }

}
