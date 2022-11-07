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