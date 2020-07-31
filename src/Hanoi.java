public class Hanoi {
    private SeqStack<Integer> a;
    private SeqStack<Integer> b;
    private SeqStack<Integer> c;

    public Hanoi(SeqStack<Integer> a, SeqStack<Integer> b, SeqStack<Integer> c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void findHanoi(int n, SeqStack<Integer> from ,SeqStack<Integer> buffer ,SeqStack<Integer> to ) {
        //当只有一个盘子要移动时，直接从出发盘移到目的盘
        if (n==1) {
            to.push(from.pop());
        } else {
            //否则，则先将前n-1个盘子移动到中间盘，再将第n盘移动到目的盘，再将前n个盘从中间盘移动到目的盘
            findHanoi(n-1,from,to,buffer);
            findHanoi(1,from,buffer,to);
            findHanoi(n-1,buffer,from,to);
        }
    }

    public static void pr(int n,String a,String b,String c) {
        if (n==1) {
            System.out.println(a+"->"+c);
        } else {
            pr(n-1,a,c,b);
            pr(1,a,b,c);
            pr(n-1,b,a,c);
        }
    }
}
