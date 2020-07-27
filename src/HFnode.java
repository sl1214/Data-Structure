public class HFnode {
    double weight;
    int parent;
    int lchild;
    int rchild;

    public HFnode(double w, int p, int l, int r) {
        weight = w;
        parent = p;
        lchild = l;
        rchild = r;
    }

    public String toString() {
        return String.format("%5.1f %3d %3d %3d",weight,parent,lchild,rchild);
    }
}
