class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][10];
        int[][] colum = new int[9][10];
        int[][] box = new int[9][10];

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.')continue;
                int curNum = board[i][j] - '0';
                if(row[i][curNum] == 1)return false;
                if(colum[j][curNum] == 1)return false;
                if(box[j/3 + (i/3)*3][curNum] == 1)return false;


                row[i][curNum] = 1;
                colum[j][curNum] = 1;
                box[j/3 + (i/3)*3][curNum] = 1;
            }
        }
        return true;
    }
}
