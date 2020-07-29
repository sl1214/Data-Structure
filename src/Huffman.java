public class Huffman {
    private int n;
    private int m;
    private HFnode[] HT;
    private CodeTable CO;

    public Huffman(char[] c, double[] w) {
        n = c.length;
        m = 2 * n - 1;
        CO = new CodeTable(c, w);
        HT = new HFnode[m];
        for (int i = 0; i < m; i++) {
            HT[i] = new HFnode(0, -1, -1, -1);
        }
    }

    //创建Human树，
    public void createHuffmanTree() {
        int i;
        int s[] = new int[2];
        //首先将n个叶子节点存入前n个位置内。
        for (i = 0; i < n; i++) {
            HT[i]= new HFnode(CO.w[i],-1,-1,-1);
        }
        //再循环选出前i-1位中权值最小的两个节点作为左右子树节点，计算出上级节点的权值，并存入第i位数组中。
        for (i = n;i<m;i++){
            select(i-1,s);
            HT[i].lchild = s[0];

            HT[i].rchild = s[1];
            HT[s[0]].parent = i;
            HT[s[1]].parent = i;
            HT[i].weight = HT[s[0]].weight+HT[s[1]].weight;
        }
    }

    //选出前low位权值最小的两个节点，作为左右子树节点，保存在s[]数组中。
    private void select(int low, int[] minw) {
        double minL = Double.MAX_VALUE;
        double minR = Double.MAX_VALUE;
        int indexL = -1;
        int indexR = -1;
        for (int i=0;i<=low;i++) {
            if (HT[i].parent == -1 && HT[i].weight< minL) {
                minR = minL;
                indexR = indexL;
                minL = HT[i].weight;
                indexL = i;
            } else if (HT[i].parent == -1 && HT[i].weight < minR){
                minR = HT[i].weight;
                indexR = i;
            }
            minw[0] = indexL;
            minw[1] = indexR;
        }
    }

    //给传入字符进行huffman编码，，
    public String charCode(char ch) {
        char[] cd = new char[n];
        int i;
        int start;
        //首先找到huffman树数组中该字符的位置
        for (i=0;i<n;i++) {
            if (CO.c[i]==ch) {
                break;
            }
        }
        if (i>=n) {
            return null;
        }
        start = n-1;
        int j = i;
        int p = HT[i].parent;
        //循环向上寻找父节点，
        while(p!=-1) {
            //判断该节点是父节点的左子树还是右子树（左子树则往记录数组中队首添加0，右子树则添加1）
            if (HT[p].lchild==j) {
                cd[--start]='0';
            } else {
                cd[--start]='1';
            }
            j = p;
            p = HT[p].parent;
        }
        //取记录数组中记录的编码
        return new String(cd,start,n-start-1);
    }

    //创建编码表
    public void createCodeTable(){
        for (int i=0;i<n;i++) {
            CO.code[i] = new String(charCode(CO.c[i]));
        }
    }

    //将传入的字符串进行Huffman编码，并返回编码后的字符串
    public String HuffmanCode(String str){
        StringBuilder codeStr = new StringBuilder();
        //循环给字符串中每个字符编码
        for (int i = 0;i<str.length();i++) {
            codeStr.append(charCode(str.charAt(i)));
        }
        return new String(codeStr);
    }

    //将传入的编码字符进行Huffman解码，并返回解码后的字符串
    public String HuffmanDecode(String codeStr) {
        int p;
        StringBuilder strb = new StringBuilder();
        //我能看明白这一段，但是我写不出这一段
        for (int i= 0;i< codeStr.length();){
            p = m-1;
            while(true) {
                if (codeStr.charAt(i)=='0'){
                    p = HT[p].lchild;
                    i++;
                } else if(codeStr.charAt(i) == '1') {
                    p = HT[p].rchild;
                    i++;
                } else {
                    return null;
                }
                if (HT[p].lchild == -1 && HT[p].rchild==-1) {
                    strb.append(CO.c[p]);
                    break;
                }
            }
        }
        return new String(strb);
    }

    public void outputTree() {
        System.out.println("===Huffman树===");
        for (int i = 0;i<m;i++) {
            System.out.println(i+" | " +HT[i]);
        }
        System.out.println("===编码表===");
        System.out.println(CO);
    }
}
