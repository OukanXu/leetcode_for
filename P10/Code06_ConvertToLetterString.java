package P10;

public class Code06_ConvertToLetterString {

    //对于0而已，无法处理，直接返回
    //对于1而言，可以看成单个，也可以与i+1组成两个
    //对于2而言，可以看成单个，如果i+1 >= 0 并且 <= 6时，也可以看成两个
    //其余都看成一个
    public static int process(char[] chs,int i){
        if(i == chs.length){
            return 1;
        }
        if(chs[i] == '0'){
            return 0;
        }
        if(chs[i] == '1'){
            int res = process(chs,i+1);//i自己作为单独部分，求后续的方法数
            if(i+1<chs.length){
                res+= process(chs,i+2);//i与i+1作为一部分，求后续的方法数 
            }
            return res;
        }
        if(chs[i] == '2'){
            int res = process(chs,i+1);
            if(i+1 < chs.length && (chs[i+1] >= '0' && chs[i+1] <= '6')){
                res+= process(chs,i+2);
            }
            return res;
        }
        return process(chs,i+1);
    }
}
