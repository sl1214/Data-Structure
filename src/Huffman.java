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

    public void createHuffmanTree() {
        int i;
        int s[] = new int[2];
        for (i = 0; i < n; i++) {
            HT[i]= new HFnode(CO.w[i],-1,-1,-1);
        }
        for (i = n;i<m;i++){
            select(i-1,s);
            HT[i].lchild = s[0];
            System.out.println(HT.length);
            System.out.println(s.length);
            System.out.println(i);
            HT[i].rchild = s[i];
            HT[s[0]].parent = i;
            HT[s[1]].parent = i;
            HT[i].weight = HT[s[0]].weight+HT[s[1]].weight;
        }
    }

    private void select(int low, int[] minw) {
        double minL;
        double minR;
        int indexL;
        int indexR;
        minL = Double.MAX_VALUE;
        minR = Double.MAX_VALUE;
        indexL = -1;
        indexR = -1;
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

    public String charCode(char ch) {
        char[] cd = new char[n];
        int i;
        int start;
        for (i=0;i<n;i++) {
            if (CO.c[i]==ch) {
                break;
            }
            if (i>=n) {
                return null;
            }
        }
        start = n-1;
        int j = i;
        int p = HT[i].parent;
        while(p!=-1) {
            if (HT[p].lchild==j) {
                cd[--start]='0';
            } else {
                j = p;
                p = HT[p].parent;
            }

        }
        return new String(cd,start,n-start-1);
    }

    public void createCodeTable(){
        for (int i=0;i<n;i++) {
            CO.code[i] = new String(charCode(CO.c[i]));
        }
    }

    public String HuffmanCode(String str){
        StringBuilder codeStr = new StringBuilder();
        for (int i = 0;i<str.length();i++) {
            codeStr.append(charCode(str.charAt(i)));
        }
        return new String(codeStr);
    }

    public String HuffmanDecode(String codeStr) {
        int p;
        StringBuilder strb = new StringBuilder();

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
