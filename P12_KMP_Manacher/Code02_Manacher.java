package P12_KMP_Manacher;

public class Code02_Manacher {
    public static char[] manacherString(String str){
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 +1];
        int index = 0;
        for(int i = 0; i != res.length; i++){
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }




    public static int maxLcpsLength(String s){
        if(s == null || s.length() == 0){
            return 0;
        }

        char[] str = manacherString(s);// 1221 -> #1#2#2#1#
        int[] pArr = new int[str.length];//回文半径数组
        int C = -1;//中心点
        int R = -1;//回文右边界的再往右一个位置，最右有效区域是R-1位置
        int max = Integer.MAX_VALUE;//扩出来的最大值
        for(int i = 0; i != str.length; i++){//对于每一个位置，求最大回文半径
            //i至少的回文区域，先给pArr[i]

            //不用验证也知道，以i为中心，目前最大的回文区域,如果右边界R小于i，扩充1，情况1
            //否则扩充区域取最小值，两个值为R-i 和 i'的回文半径，2*C-i为i',情况2的三种情况
            pArr[i] = R > i ? Math.min(pArr[2*C-i], R-i) : 1;


            //从至少不用验证的区域开始，向外验证
            while(i+pArr[i] < str.length && i - pArr[i] > -1){
                if(str[i + pArr[i]] == str[i - pArr[i]]){//将i加上之前的回文半径和减去之前的回文半径，找到两个点，如果相同，回文半径++
                    pArr[i]++;
                }else{
                    break;
                }
            }
            if(i + pArr[i] > R){//如果i>R了，更新R和C，然后求一下最大回文半径
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max-1;
    }
}
