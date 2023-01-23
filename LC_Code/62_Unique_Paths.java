class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i = n-1; i >= 0; i-- ){
            dp[m-1][i] = 1;
        }

        for(int j = m-1; j >= 0; j--){
            dp[j][n-1] = 1;
        }


        for(int i = m-2; i >= 0; i--){
            for(int j = n-2; j >= 0; j--){
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }

        return dp[0][0];
    }
}


//round 2
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] res = new int[m+1][n+1];

        Arrays.fill(res[0],1);
        for(int j = 0; j < m; j++){
            res[j][0] = 1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                res[i][j] = res[i][j-1]+res[i-1][j];
            }
        }
        return res[m-1][n-1];
    }
}