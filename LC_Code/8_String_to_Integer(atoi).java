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


//round 2
class Solution {
    public int myAtoi(String s) {
        int res = 0;
        int flag = 1;

        int index = 0;
        int length = s.length();
        while(index < length){
            if(s.charAt(index) == ' '){
                index++;
            }else{
                break;
            }
        }

        if(index == length){
            return 0;
        }

        if(s.charAt(index) == '+'){
            index++;
        }else if(s.charAt(index) == '-'){
            flag = -flag;
            index++;
        }

        while(index < length){
            if(Character.isDigit(s.charAt(index))){
                int temp = s.charAt(index) - '0';

                if(res > 214748364 || (res == 214748364 && temp > 7)){
                    return Integer.MAX_VALUE;
                }
                if(res < -214748364 || (res == -214748364 && temp*flag < -8)){
                    return Integer.MIN_VALUE;
                }
                res = res*10+flag*temp;
                index++;
            }else{
                break;
            }
        }
        return res;
    }
}