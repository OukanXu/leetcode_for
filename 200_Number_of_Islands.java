class Solution {
    
    public int numIslands(char[][] grid) {
        /**
            矩阵四周被水环绕
            四周环水算岛

            思路：设定边界条件，从边上为1的点开始遍历相邻点，如果为1改为#，如果碰到0返回，四个方向全返回时，num+1
         */

        int num = 0;
         if(grid == null || grid.length ==0){
            return num;
         }

        int height = grid.length;
        int width = grid[0].length;

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(grid[i][j] == '1'){
                    num++;
                    dfs(grid,i,j);
                }
            }
        }
        return num;

    }

    public void dfs(char[][]grid,int i,int j){
        if(i < 0 || j < 0 || i > grid.length-1 || j > grid[0].length-1 || grid[i][j] == '#' || grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '#';

        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
    }
}
