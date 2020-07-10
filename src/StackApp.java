public class StackApp {

    public static void main(String[] args) {
        StackApp stackApp  = new StackApp();
        stackApp.decimalToBinary(3467,8);
    }

    public void decimalToBinary(int n, int r) {
        SeqStack<Integer> s = new SeqStack<>(16);
        Integer x=0;
        while(n!=0){
            s.push(n%r);
            n = n/r;
        }
        while (!s.isEmpty()) {
            x=x*10+s.pop();
        }
        System.out.println(x);
    }
}
