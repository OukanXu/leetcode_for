class Solution {
    public int trailingZeroes(int n) {
        //求解1-n中5的个数
        if(n < 5){
            return 0;
        }
        int ans = 0;

        for(int x = 5; x <= n; x+=5){
            int y = x;
            while(y%5 == 0 && y>=5){
                y = y/5;
                ans++;
            }
        }
        return ans;
    }
}


//round 2
class Solution {
    public int trailingZeroes(int n) {
        if(n < 5){
            return 0;
        }

        int res = 0;
        for(int i = 5; i <= n; i+=5){
            int y = i;
            while(y % 5 == 0 && y >= 5){
                res++;
                y /= 5;
            }
        }
        return res;
    }
}


// 分别计算数里面有几个数含有几个5
class Solution {
    public int trailingZeroes(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }
}