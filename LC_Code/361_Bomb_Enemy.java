class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] dp = new int[row][col];

        //从左往右看，只考虑左边的
        for(int i = 0; i < row; i++){
            int pre = 0;
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 'W'){
                    pre = 0;
                }else if(grid[i][j] == 'E'){
                    pre += 1;
                }
                dp[i][j] += pre;
            }

            //从右往左，只考虑右边
            pre = 0;
            for(int j = col-1; j >= 0; j--){
                if(grid[i][j] == 'W'){
                    pre = 0;
                }else if(grid[i][j] == 'E'){
                    pre += 1;
                }
                dp[i][j] += pre;
            }
        }


        //从上往下看，只考虑上边
        for(int i = 0; i < col; i++){
            int pre = 0;
            for(int j = 0; j < row; j++){
                if(grid[j][i] == 'W'){
                    pre = 0;
                }else if(grid[j][i] == 'E'){
                    pre += 1;
                }
                dp[j][i] += pre;
            }

            pre = 0;
            for(int j = row-1; j >= 0; j--){
                if(grid[j][i] == 'W'){
                    pre = 0;
                }else if(grid[j][i] == 'E'){
                    pre += 1;
                }
                dp[j][i] += pre;
            }

        }

        int res = 0;
        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '0' && dp[i][j] > res){
                    res = dp[i][j];
                }
            }
        }
        return res;
    }
}
