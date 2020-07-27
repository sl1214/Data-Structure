public class CodeTable {
    int n;
    char [] c;
    double[] w;
    String[] code;
    public CodeTable(char[] c,double[] w) {
        n = c.length;
        this.c = c;
        this.w = w;
        this.code = new String[n];
    }
    public String toString() {
        StringBuilder strb = new StringBuilder();
        strb.append("symb").append("       ").append("weight").append(" ").append("code\n");
        for (int i=0;i<n ;i++) {
            strb = strb.append(String.format("%-7c %9.1f %s\n",c[i],w[i],code[i]));
        }
        return new String(strb);
    }
 }
