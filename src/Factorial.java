public class Factorial {
    public long getFactorial(long num) {
        long sum = 0;
        if (num == 1) {
            return num;
        } else {
            sum = num * getFactorial(num-1);
            return sum;
        }
    }
}
