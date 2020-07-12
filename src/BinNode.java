public class BinNode<T> {
    T data;
    Integer count = 0;
    BinNode<T> lChild;
    BinNode<T> rChild;

    public void preOrder(BinNode<T> root) {
        if (root != null) {
            visit(root);
            preOrder(root.lChild);
            preOrder(root.rChild);
        }
    }

    public void inOrder(BinNode<T> root) {
        if (root != null) {
            inOrder(root.lChild);
            visit(root);
            inOrder(root.rChild);

        }
    }

    public void postOrdeer(BinNode<T> root) {
        if (root != null) {
            postOrdeer(root.lChild);
            postOrdeer(root.rChild);
            visit(root);
        }

    }

    public void order(BinNode<T> root) {
        LinkQue<BinNode> que = new LinkQue<BinNode>();
        que.add(root);
        BinNode p;
        while ((p = que.getHead()) != null) {
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
        if (node.lChild == null && node.rChild == null) {
            count++;
        }
        System.out.print(node.data.toString());
    }

}
