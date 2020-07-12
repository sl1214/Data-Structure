import java.util.Iterator;

public class test {

    public static void main(String [] args ){
        /*LinkList<Integer> linkList = new LinkList<>();
        linkList.add(31);
        linkList.add(21);
        linkList.add(5);
        linkList.add(2);
        linkList.add(3);
        linkList.add(43);
        linkList.add(18);
        System.out.println("迭代器使用方法");
        Iterator<Integer> itreator = linkList.iterator();
        while (itreator.hasNext()) {
            int a = 2*itreator.next();
            System.out.println(a+" ");
        }
        System.out.println("整体排序，迭代器使用方法二");
        linkList.sort();
        for (Integer i :linkList) {
            System.out.println(i+" ");
        }*/

        BinNode<String> root = new BinNode<String>();
        root.data = "A";
        root.lChild = new BinNode<String>();
        root.lChild.data = "B";
        root.lChild.lChild = new BinNode<String>();
        root.lChild.lChild.data = "D";
        root.lChild.rChild = new BinNode<String>();
        root.lChild.rChild.data ="E";
        root.lChild.rChild.lChild = new BinNode<String>();
        root.lChild.rChild.lChild.data = "G";
        root.rChild = new BinNode<String>();
        root.rChild.data = "C";
        root.rChild.rChild = new BinNode<String>();
        root.rChild.rChild.data = "F";
        root.preOrder(root);
        System.out.println("先序遍历完");
        root.inOrder(root);
        System.out.println("中序遍历完");
        root.postOrdeer(root);
        System.out.println("后序遍历完");
        root.order(root);
        System.out.println("层次遍历完");
    }
}
