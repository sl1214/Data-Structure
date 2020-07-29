import java.util.Iterator;

public class test {

    public static void main(String [] args ){

        //测试迭代器
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

        //树的遍历
        /*BinNode<String> root = new BinNode<String>();
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
        System.out.println(root.count);
        root.inOrder(root);
        System.out.println("中序遍历完");
        root.postOrdeer(root);
        System.out.println("后序遍历完");
        root.order(root);
        System.out.println("层次遍历完");*/

        //根据先序遍历和中序遍历还原树结构
       /* BinNode<Character> root = new BinNode<Character>();
        char[] a = {'A','B','C','D','E','F','G','H','I'};
        char[] b = {'B','C','A','E','D','G','H','F','I'};
        BinNode<Character> s = root.restore(a,b,0,0,a.length-1);
        System.out.println();*/

        //测试huffman数结构
        /*char[] c = {'a','b','c'};
        double[] w = {2,3,4};
        CodeTable codeTable = new CodeTable(c,w);
        System.out.println(codeTable.toString());*/

        //测试huffman编码解码
        char[] sym = {'北','京','天','很','蓝','人','好'};
        double[] wei = {8,8,2,7,3,6,6};
        Huffman ht = new Huffman(sym,wei);
        ht.createHuffmanTree();
        ht.createCodeTable();
        ht.outputTree();
        String x = "北京天很蓝被禁人很好很好很蓝";
        String code = ht.HuffmanCode(x);
        System.out.println(code);

        String y = "01110001000001011001100100111101001100110100010001110100010110011100111101";
        System.out.println(ht.HuffmanDecode(y));
    }
}
