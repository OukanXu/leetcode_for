class Solution {
    public boolean isPalindrome(int x) {
        int mod = 0;
        int res = 0;
        int newX = x;
        if(x < 0){
            return false;
        }
        while(x != 0){
            mod = x%10;
            if(res > 214748364 || (res == 214748364 && mod > 7)){
                return false;
            }
            res = res*10 + mod;
            x = x/10;
        }
        if(newX == res){
            return true;
        }else{
            return false;
        }
    }
}

//round 2
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }

        int temp = x;
        int res = 0;
        while(temp != 0){
            int mod = temp%10;
            res = res*10+mod;
            temp /= 10;
        }

        return res == x;
    }
}