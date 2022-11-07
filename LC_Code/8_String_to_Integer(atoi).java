class Solution {
    public int myAtoi(String s) {
        char[] str = s.toCharArray();
        int res = 0;
        int sign = 1;
        int index = 0;

        while(index < str.length){
            if(str[index] == ' '){
                index++;
            }else{
                break;
            }
        }
        if(index == str.length){
            return 0;
        }
        
        if(str[index] == '+'){
            index++;
        }else if(str[index] == '-'){
            sign = -1;
            index++;
        }
        
        while(index < str.length){
            if(str[index] - '0' >= 0 && str[index] - '0' <= 9){
                if(res > 214748364 || (res == 214748364 && str[index] - '0' > 7)){
                    return Integer.MAX_VALUE;
                }
                if(res < -214748364 || (res == -214748364 && str[index] - '0' > 8)){
                    return Integer.MIN_VALUE;
                }
                res = res*10 + sign * (str[index] - '0');
                index++;
            }else{
                break;
            }
        }
        
        return res;
    }
}