package LC_Code;

class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n+1];

        dp[1] = 1;

        int p2 = 1;
        int p3 = 1;
        int p5 = 1;

        int i = 2;
        while(i >= 2 && i <dp.length){
            int num2 = 2*dp[p2];
            int num3 = 3*dp[p3];
            int num5 = 5*dp[p5];

            dp[i] = (Math.min(num2,Math.min(num3,num5)));
            if(dp[i] == num2){
                p2++;
            }
            if(dp[i] == num3){
                p3++;
            }
            if(dp[i] == num5){
                p5++;
            }
            i++;
        }

        return dp[n];
    }
}
