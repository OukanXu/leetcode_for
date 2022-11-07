class Solution {
    public String longestPalindrome(String s) {
        //求字符串中最大回文子串，可以用manacher算法
        if(s == null || s.length() == 1){
            return s;
        }
        char[] charArr = manacherString(s);
        int[] pArr = new int[charArr.length];

        int R = -1;//右边界再往右一个位置
        int C = -1;
        int max = -1;

        for(int i = 0; i != charArr.length; i++){
            if(i >= R){//情况1：i在右边界R外
                pArr[i] = 1;
            }else{
                /**情况2：i在R内
                2.1 i的对称点回文在L内，i = i'的情况
                2.2 i的对称点部分在L外，i-R
                2.3 i的对称点在L上，i-R
                 */
                 pArr[i] = Math.min(R-i,pArr[2*C-i]);
            }

            //除去不要验证的部分，现在开始向外验证,要保证不要越界
            while(i - pArr[i] > -1 && i + pArr[i] < charArr.length){
                if(charArr[i + pArr[i]] == charArr[i - pArr[i]]){
                    pArr[i]++;
                }else{
                    break;
                }
            }

            if(i + pArr[i] > R){
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max,pArr[i]);

            

        }
        String res = "";
        for(int i = 0; i < pArr.length; i++){
            if(pArr[i] == max){
                int start = i - (max-1);
                int end = i + (max-1);
                for(int j = start; j <= end; j++){
                    if(charArr[j] != '#'){
                        res = res + (charArr[j]);
                    }
                }
                return res;
            }
        }
        return "";






    }

    public char[] manacherString(String s){

        char[] sto = s.toCharArray();
        char[] newchar = new char[2*sto.length+1];
        int j=0;

        for(int i = 0; i < newchar.length; i++){
            newchar[i] = (i%2) == 0 ? '#' : sto[j++];
        }
        return newchar;
    }
}
