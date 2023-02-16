/*
 * 遍历数组，确定边界值，将边界上的‘O’先标记换成‘#’，然后以此‘#’为原点，深度优先遍历上、下、左、右四个方位，如果遇到相邻的‘O’同样变成‘#’。
 * 最后遍历数组，将‘#’重新变成‘O’，剩余未改变的‘O’变成‘X’
 * 
 */

class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0){
            return;
        }

        int height = board.length;
        int width = board[0].length;

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){

                boolean isEdge = false;
                if(i == 0 || j == 0 || i == height-1 || j == width-1){
                    isEdge = true;
                }

                if(isEdge && board[i][j] == 'O'){
                    dfs(board,i,j);
                }
                
            }
        }

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }

    }

    public void dfs(char[][] board, int i, int j){
        if(i < 0 || j < 0 || i > board.length-1 || j > board[0].length-1 || board[i][j] == 'X' || board[i][j] == '#'){
            return;
        }
        board[i][j] = '#';

        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);
    }
}


//round 2
class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int j = 0; j < n; j++){
            if(board[0][j] == 'O'){
                dfs(board,0,j);
            }
            if(board[m-1][j] == 'O'){
                dfs(board,m-1,j);
            }
        }

        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O'){
                dfs(board,i,0);
            }
            if(board[i][n-1] == 'O'){
                dfs(board,i,n-1);
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == '1'){
                    board[i][j] = 'O';
                }
            }
        }
    }


    public void dfs(char[][] board, int row, int col){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'O'){
            return;
        }

        board[row][col] = '1';
        dfs(board,row+1,col);
        dfs(board,row-1,col);
        dfs(board,row,col+1);
        dfs(board,row,col-1);
    }
}