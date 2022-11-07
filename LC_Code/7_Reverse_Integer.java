class Solution {
    public int reverse(int x) {
        

        int res = 0;
        while(x != 0){
            int mod = x%10;
            
            if(res > 214748364 || (res == 214748364 && mod > 7)){
                return 0;
            }
            if(res < -214748364 || (res == -214748364 && mod < -8)){
                return 0;
            }

            res = res*10 + mod;
            x/=10;
        }

        
        return res;
    }
}