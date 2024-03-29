class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] dp= new int[row][col];

        dp[0][0] = grid[0][0];
        //init
        for(int i = 1; i < row; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for(int j = 1; j < col; j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        //begin
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[row-1][col-1];
    }
}


//round 2
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        int i = 0;
        int j = 0;

        dp[0][0] = grid[0][0];

        for(j = 1; j < n; j++){
            dp[0][j] = dp[0][j-1]+grid[0][j];
        }

        for(i = 1; i < m; i++){
            dp[i][0] = dp[i-1][0]+grid[i][0]; 
        }

        for(i = 1; i < m; i++){
            for(j = 1; j < n; j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }

        return dp[m-1][n-1];
    }
}