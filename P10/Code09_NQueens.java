package P10;

public class Code09_NQueens {
    public static int num1(int n){
        if(n < 1){
            return 0;
        }

        int[] record = new int[n];//record[i] -> i行的皇后,放在了第几列
        return process1(0,record,n);
    }

    //record[0...i-1]的皇后，一定不共行不共列不共斜线
    //i表示现在来到第i行，record表示之前摆的皇后的位置， n表示整体有多少行。 返回值为摆完所有皇后，合理的摆法的种类
    public static int process1(int i, int[] record, int n){
        if(i == n){//来到终止行
            return 1;
        }
        int res = 0;
        for(int j = 0; j < n; j++){//当前行永远是i行，尝试i行所有的列
            //当前i行的皇后，放在j列，会不会和之前的皇后，共行共列共斜线？ 如果是，认为该位置无效，否则有效
            if(isValid(record,i,j)){
                record[i] = j;
                res += process1(i+1,record,n);
            }
        }
        return res;
    }

    //判断放在i行，j列的皇后合不合法
    public static boolean isValid(int[] record, int i, int j){
        for(int k = 0; k < i; k++){//       考察之前的某个k行的皇后
            if(j == record[k] || Math.abs(record[k]-j) == Math.abs(i-k)){//行数肯定大于之前，所以不会同行，不考虑。考虑是否同列或者同斜线
                return false;
            }
        }
        return true;
    }
}
