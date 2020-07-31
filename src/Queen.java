public class Queen {
    int n;
    int count;
    int[] x;

    public Queen(int n) {
        this.n = n;
        x = new int[n];
    }

    //非递归求解。
    // 关键在于向上回朔的点，一种是当前行已用完回朔，二个是回朔后的行也已用完需要再向上回朔，且回朔后所在的行要从上一次放置点的后一位开始循环放置。
    //能求解所有的可能关键在于，每次寻找到一个正确结果时依然向上回朔，寻找新的放置可能。
    public void findQueenSite() {
        int start = 0;
        for (int i = 0; i < n; i++) {

            //回朔之后的行也已用完，再向上回朔。
            if (start >= n ) {
                //当回朔到第一行时，且第一行已用完时，退出程序。
                if (i==0) {
                    break;
                }
                //取上一行放置点的后一位
                start = x[i-1]+1;
                i = i - 2;
                continue;
            }

            //将第i个皇后循环放置到第i行的第j个位置上
            for (int j = start; j < n; j++) {
                x[i] = j;
                Boolean flag = Boolean.TRUE;
                //判断当前放置的位置是否合理，合理则结束该层的放置
                if (checkSite(i)) {
                    start = 0;
                    break;
                }
                //不合理，则判断是否是最后一个位置，是则向上一行回朔
                if (j == n - 1) {
                    x[i] = -1;
                    start = x[i-1]+1;
                    i = i - 2;
                }
                /*for (int z = 0; z < i; z++) {
                    if (x[z] == x[i] || (Math.abs(x[z] - x[i]) == Math.abs(z - i))) {
                        flag = Boolean.FALSE;
                        break;
                    }
                }
                if (flag) {
                    start = 0;
                    break;
                }
                //当前行已放置完并无无合理，向上一行回朔
                if (j == n - 1) {
                    x[i] = -1;
                    start = x[i-1]+1;
                    i = i - 2;
                    break;
                }*/
            }

            //判断是否是放置最后一个皇后，是则打印出该次放置的所有皇后的位置，并向上一级回朔，寻找新的放置可能。
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
        //是否已放置完所有皇后
        if (i>=n) {
            System.out.println(this.toString());
            count++;
            return;
        }
        //将皇后循环该行所有位置
        for (int j=0;j<n;j++) {
            //将第i个皇后放置到位置j
            x[i]=j;
            //判断位置j放置皇后是否合理，合理则开始放置下一行，不合理则取消该位置的放置，继续循环。
            if (checkSite(i)){
                findSite(i+1);
            } else {
                x[i] = -1;
            }
        }
    }

    //检查皇后放置在该位置是否满足规则合理
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
