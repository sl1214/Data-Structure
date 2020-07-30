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
        if (n==1) {
            to.push(from.pop());
        } else {
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
