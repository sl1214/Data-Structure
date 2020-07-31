public class Queen {
    int n;
    int count;
    int[] x;

    public Queen(int n) {
        this.n = n;
        x = new int[n];
    }

    //非递归求解。
    // 关键在于向上回朔的点，一种是当前行已用完回朔，二个是回朔后的行也已用完需要再向上回朔。
    public void findQueenSite() {
        int start = 0;
        for (int i = 0; i < n; i++) {

            //回朔之后的行也已用完，再向上回朔。
            if (start >= n ) {
                //当回朔到第一行时，且第一行已用完时，退出程序。
                if (i==0) {
                    break;
                }
                start = x[i-1]+1;
                i = i - 2;
                continue;
            }
            for (int j = start; j < n; j++) {
                x[i] = j;
                Boolean flag = Boolean.TRUE;
                for (int z = 0; z < i; z++) {
                    if (x[z] == x[i] || (Math.abs(x[z] - x[i]) == Math.abs(z - i))) {
                        flag = Boolean.FALSE;
                        break;
                    }
                }
                if (flag) {
                    start = 0;
                    break;
                }
                //当前行已用完，开始回朔
                if (j == n - 1) {
                    start = x[i-1]+1;
                    i = i - 2;
                    break;
                }
            }

            if (i == n - 1) {
                System.out.println(this.toString());
                start = x[i-1]+1;
                i = i - 2;
                count++;
            }
        }
    }

    //递归算法
    //该递归回朔算法的关键在于分步分析，
    // 将每一行的皇后的位置放置作为递归函数，区别所有皇后都放置好的情况（传入行数i>n）
    // 将皇后循环放置到该行的所有位置，并判断每一位置是否合理，如果合理则进行下一行的放置，不合理则取消该位置的放置，循环完就结束当前行的放置。所以可以查询所有的行
    public void findSite(int i) {
        if (i>=n) {
            System.out.println(this.toString());
            count++;
            return;
        }
        for (int j=0;j<n;j++) {
            x[i]=j;
            if (checkSite(i)){
                findSite(i+1);
            } else {
                x[i] = -1;
            }
        }
    }

    private Boolean checkSite(int i) {
        for (int j = 0;j<i;j++) {
            if (x[i] == x[j] || Math.abs(x[i]-x[j])==Math.abs(i-j)){
                return false;
            }
        }
        return true;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0;i<n;i++) {
            stringBuilder.append(x[i]);
            if (i!=n-1){
                stringBuilder.append(",");
            }
        }
        return new String(stringBuilder);
    }

}
