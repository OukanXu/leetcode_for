// dfs
class Solution {
    private int a = 201;
    int[][] cache = new int[a][a];
    public int getMoneyAmount(int n) {
        return dfs(1,n);
    }

    public int dfs(int l, int r){
        if(l >= r) return 0;
        if(cache[l][r] != 0) return cache[l][r];

        int res = Integer.MAX_VALUE;
        
        for(int x = l; x <= r; x++){
            int temp = Math.max(dfs(l,x-1),dfs(x+1,r))+x;
            res = Math.min(res,temp);
        }
        cache[l][r] = res;
        return res;
    }
}



//dp

class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+10][n+10];

        for(int len = 2; len <= n; len++){
            for(int l = 1; l+len-1 <= n; l++){
                int r = l+len-1;
                dp[l][r] = Integer.MAX_VALUE;
                for(int x = l; x <= r; x++){
                    int cur = Math.max(dp[l][x-1],dp[x+1][r])+x;
                    dp[l][r] = Math.min(dp[l][r],cur);
                }
            }
        }
        
        return dp[1][n];
    }
}