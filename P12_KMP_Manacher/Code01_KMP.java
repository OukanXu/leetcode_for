package P12_KMP_Manacher;

public class Code01_KMP {
    public static int getIndexOf(String s, String m){
        if(s == null || m == null || m.length() < 1 || s.length() < m.length()){
            return -1;
        }

        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(str2);//O(N)，获取next数组

        //O(N)
        while(i1 < str1.length && i2 < str2.length){//比对过程中要求两个指针都不越界，i2越界表示已经求出了一个开头，包含整个str2
            if(str1[i1] == str2[i2]){
                i1++;
                i2++;
            }else if(next[i2] == -1){//等同于i2在str2的0位置，在next中人工赋值-1，i2已经没有办法再往前跳了，说明开头就不相等
                i1++;
            }else{
                i2 = next[i2];//假设该位置最大前后缀相等值为7，说明最大前缀位置为0-6，调到7，说明str2还可以往前跳
            }
        }
        //i1越界或者i2越界，如果i2越界了，那么i1来到的位置，减去i2的长度，就是这个str的开头
        return i2 == str2.length ? i1-i2 : -1;
    }



    public static int[] getNextArray(char[] ms){
        if(ms.length == 1){
            return new int[]{-1};
        }

        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;//next数组的位置
        int cn = 0;//拿哪个位置的字符和i-1的字符对比
        while(i < next.length){
            if(ms[i-1] == ms[cn]){// i-1位置与cn位置匹配，将i位置的信息变成cn+1
                next[i++] = ++cn;
                //cn = cn+1;
                //next[i] = cn;
                //i++;
            }

            //当前跳到cn位置的字符，和i-1位置的字符配不上
            else if( cn > 0){
                cn = next[cn];
            }else{
                next[i++] = 0;
            }
        }
        return next;
    }
}
