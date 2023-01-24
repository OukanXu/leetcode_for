class Solution {
    boolean res = false;
    
    public boolean exist(char[][] board, String word) {

        
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    int[][] visited = new int[board.length][board[0].length];
                    process(board,word,0,i,j,visited);
                }
            }
        }
        return res;
    }

    public void process(char[][] board, String word,int index,int i, int j, int[][] visited){
        if(index == word.length()){
            res = true;
            return;
        }
        if(i > board.length-1 || i < 0 || j > board[0].length-1 || j < 0|| index > word.length()-1|| board[i][j] != word.charAt(index)|| visited[i][j] == 1){
            return;
        }
        
        visited[i][j] = 1;
        process(board,word,index+1,i-1,j,visited);
        process(board,word,index+1,i+1,j,visited);
        process(board,word,index+1,i,j+1,visited);
        process(board,word,index+1,i,j-1,visited);
        visited[i][j] = 0;

    }
}


//round 2
class Solution {
    public boolean res = false;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    dfs(board,0,word,visited,i,j);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] board, int index, String word, boolean[][] visited, int i, int j){
        if(index == word.length()){
            res = true;
            return;
        }

        if(i < 0 || i > board.length-1 || j < 0 || j > board[0].length-1 || visited[i][j] == true || board[i][j] != word.charAt(index) || index > word.length()-1 || res == true){
            return;
        }

        visited[i][j] = true;
        dfs(board,index+1,word,visited,i-1,j);
        dfs(board,index+1,word,visited,i+1,j);
        dfs(board,index+1,word,visited,i,j-1);
        dfs(board,index+1,word,visited,i,j+1);
        visited[i][j] = false;

    }
}