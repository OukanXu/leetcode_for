class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        int row = obstacleGrid.length; 
        int col = obstacleGrid[0].length;

        if(obstacleGrid[row-1][col-1] == 1){
            return 0;
        }

        int[][] dp = new int[row][col];

        for(int i = 0 ; i < row; i++){
            if(obstacleGrid[i][0] == 1){
                dp[i][0] = 0;
                break;
            }
            dp[i][0] = 1;
        }

        for(int j = 1; j < col; j++){
            if(obstacleGrid[0][j] == 1){
                dp[0][j] = 0;
                break;
            }
            dp[0][j] = 1;
        }

        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
                
            }
        }
        return dp[row-1][col-1];
    }
}


//round 2
logo
学习
题库
讨论
竞赛
求职
商店
0

不同路径 II
提交记录
41 / 41 个通过测试用例
状态：通过
执行用时: 0 ms
内存消耗: 39.5 MB
提交时间：2 分钟前
执行用时分布图表
执行消耗内存分布图表
邀请好友来挑战 不同路径 II
提交的代码： 2 分钟前
语言： java

添加备注


class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m+1][n+1];
        int j = 0;
        int i = 0;
        while(j < n && obstacleGrid[0][j] == 0){
            dp[0][j] = 1;
            j++;
        }

        while(j < n){
            dp[0][j] = 0;
            j++;
        }

        while(i < m && obstacleGrid[i][0] == 0){
            dp[i][0] = 1;
            i++;
        }

        while(i < m){
            dp[i][0] = 0;
            i++;
        }

        for(i = 1; i < m; i++){
            for(j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 0){
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m-1][n-1];
    }
}
