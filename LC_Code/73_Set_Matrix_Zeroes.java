class Solution {
    public void setZeroes(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        boolean[] rowFlag = new boolean[row];
        boolean[] colFlag = new boolean[col];

        for(int i = 0; i < row; i++){
            for(int j = 0;j < col; j++){
                if(matrix[i][j] == 0){
                    rowFlag[i] = true;
                    colFlag[j] = true;
                }
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0;j < col; j++){
                if(rowFlag[i] == true || colFlag[j] == true){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}


//round 2
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean flagi0 = false;
        boolean flagj0 = false;

        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0){
                flagi0 = true;
            }
        }
        for(int j = 0; j < n; j++){
            if(matrix[0][j] == 0){
                flagj0 = true;
            }
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(flagi0 == true){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }

        if(flagj0 == true){
            for(int j = 0; j < n; j++){
                matrix[0][j] = 0;
            }
        }
    }
}