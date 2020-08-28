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
        preOrderByRecursion(root, preSeq);
        return preSeq;
    }

    private void preOrderByRecursion(B2SNode<T> root, SeqlList<T> preSeq) {
        if (root != null) {
            preSeq.add(root.data);
            preOrderByRecursion(root.lChild, preSeq);
            preOrderByRecursion(root.rChild, preSeq);
        }
    }

    //中序遍历，调用inOrderByRecursion完成
    public SeqlList<T> inOrder() {
        SeqlList<T> inSeq = new SeqlList<T>(size());
        inOrderByRecursion(root, inSeq);
        return inSeq;
    }

    //中序遍历
    private void inOrderByRecursion(B2SNode<T> root, SeqlList<T> inSeq) {
        if (root != null) {
            inOrderByRecursion(root.lChild, inSeq);
            inSeq.add(root.data);
            inOrderByRecursion(root.rChild, inSeq);
        }
    }


    //后序遍历，调用postOrderByRecursion完成
    public SeqlList<T> postOrder() {
        SeqlList<T> postSeq = new SeqlList<T>(size());
        postOrderByRecursion(root, postSeq);
        return postSeq;
    }

    //后序遍历
    private void postOrderByRecursion(B2SNode<T> root, SeqlList<T> postSeq) {
        if (root != null) {
            postOrderByRecursion(root.lChild, postSeq);
            postOrderByRecursion(root.rChild, postSeq);
            postSeq.add(root.data);
        }
    }

    public String toString() {
        return inOrder().toString();
    }

    //求二叉树的最大值
    public T max() {
        return findMax(root).data;
    }

    //求二叉树的最小值
    public T min() {
        B2SNode<T> node = root;
        while (node.lChild != null) {
            node = node.lChild;
        }
        return node.data;
    }

    //在二叉树中查找包含值为key的节点，若存在则返回key本身，不存在则返回null
    public T search(T key) {
        B2SNode<T> node = root;
        while (node != null) {
            if (key.compareTo(node.data) == 0) {
                return key;
            }
            if (key.compareTo(node.data) > 0) {
                node = node.rChild;
            } else {
                node = node.lChild;
            }
        }
        return null;
    }

    //在二叉树中查找包含值为key的节点，若存在则返回true，不存在则返回false
    public boolean contains(T key) {
        B2SNode<T> node = root;
        while (node != null) {
            if (key.compareTo(node.data) == 0) {
                return true;
            }
            if (key.compareTo(node.data) > 0) {
                node = node.rChild;
            } else {
                node = node.lChild;
            }
        }
        return false;
    }

    //向二叉树中插入值为Key的节点
    public void add(T key) {
        B2SNode<T> node = root;
        B2SNode<T> newNode = new B2SNode<T>(key);
        if (node == null) {
            root = newNode;
            num++;
            return;
        }
        B2SNode<T> fatherNode = root;
        while (node != null) {
            if (key.compareTo(node.data) == 0) {
                return;
            }
            fatherNode = node;
            if (key.compareTo(node.data) > 0) {
                node = node.rChild;
            } else {
                node = node.lChild;
            }
        }
        if (key.compareTo(fatherNode.data) > 0) {
            fatherNode.rChild = newNode;
        } else {
            fatherNode.lChild = newNode;
        }
        this.num++;
    }

    //从二叉树中删除值为key的节点
    public void remove(T key) {
        deleteByRecur(root,key,null);
        /*B2SNode<T>[] fatherNode = new B2SNode[1];
        B2SNode<T> node = findNode(root, key, fatherNode);
        if (node != null) {
            //无左右子树节点
            if (node.lChild == null && node.rChild == null) {
                if (fatherNode[0] == null) {
                    root.data = null;
                    root = null;
                    return;
                }
                if (key.compareTo(fatherNode[0].data) > 0) {
                    fatherNode[0].rChild = null;
                } else {
                    fatherNode[0].lChild = null;
                }
            }
            //有左子树，无右子树
            else if (node.rChild == null) {
                node.data = node.lChild.data;
                node.rChild = node.lChild.rChild;
                node.lChild = node.lChild.lChild;
            }
            //有右子树，无左子树
            else if (node.lChild == null) {
                node.data = node.rChild.data;
                node.lChild = node.rChild.lChild;
                node.rChild = node.rChild.rChild;
            }
            //有左子树，右子树
            else {
                B2SNode<T> tempNode = node.lChild;
                B2SNode<T> tempFatherNode = node;
                while (tempNode.rChild != null) {
                    tempFatherNode = tempNode;
                    tempNode = tempNode.rChild;
                }
                node.data = tempNode.data;
                if (tempFatherNode != node) {
                    tempFatherNode.rChild = tempNode.lChild;
                } else {
                    tempFatherNode.lChild = tempNode.lChild;
                }
            }
            this.num--;
        }*/

    }

    private B2SNode<T> findNode(B2SNode<T> root, T key, B2SNode<T>[] fatherNode) {
        B2SNode<T> node = root;
        while (node != null) {
            if (key.compareTo(node.data) == 0) {
                return node;
            }
            fatherNode[0] = node;
            if (key.compareTo(node.data) > 0) {
                node = node.rChild;
            } else {
                node = node.lChild;
            }
        }
        return null;
    }

    public void deleteByRecur(B2SNode<T> node, T key, B2SNode<T> fatherNode) {
        B2SNode<T> s = null;
        if (node == null) {
            return;
        } else if (key.compareTo(node.data) < 0) {
            deleteByRecur(node.lChild, key, node);
        } else if (key.compareTo(node.data) > 0) {
            deleteByRecur(node.rChild, key, node);
        } else {
            if (node.lChild != null && node.rChild != null) {
                s = findMax(node.lChild);
                node.data = s.data;
                deleteByRecur(node.lChild, s.data, node);
            } else {
                if (node.lChild == null && node.rChild != null) {
                    node.data = node.rChild.data;
                    node.lChild = node.rChild.lChild;
                    node.rChild = node.rChild.rChild;
                } else if (node.lChild != null) {
                    node.data = node.lChild.data;
                    node.rChild = node.lChild.rChild;
                    node.lChild = node.lChild.lChild;
                } else {
                    //如果左右子树都为空，就必须得要知道父节点
                    if (fatherNode == null) {
                        root = null;
                    }
                    if (fatherNode.rChild == node) {
                        fatherNode.rChild = null;
                    } else {
                        fatherNode.lChild = null;
                    }
                }
            }
        }
    }

    private B2SNode<T> findMax(B2SNode<T> node) {
        while (node.rChild != null) {
            node = node.rChild;
        }
        return node;
    }
}
