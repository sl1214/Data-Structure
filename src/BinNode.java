public class BinNode<T> {
    T data;
    Integer count = 0;
    BinNode<T> lChild;
    BinNode<T> rChild;

    public BinNode(T c) {
        data = c;
    }

    public BinNode() {

    }

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

    public BinNode<Character> restore(char pre[],char ino[], int ps, int low, int high) {
        BinNode<Character> t = new BinNode<Character>();
        if (low>high || ps>8) {
            t = null;
        } else {
            t = new BinNode<Character>(pre[ps]);
            int k = findInRoot(ino,pre[ps],low,high);
            t.lChild = restore(pre,ino,ps+1,low,k-1);
            t.rChild = restore(pre,ino,ps+1+(k-low),k+1,high);
        }
        return t;
    }

    private int findInRoot(char ino[],char root,int low,int high) {
        for (int i = low ;i<=high;i++) {
            if (ino[i] == root) {
                return  i;
            }
        }
        return 0;
    }


}
