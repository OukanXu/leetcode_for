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
