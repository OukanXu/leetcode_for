class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int x = 0;
        int y = matrix[0].length-1;

        while(x >= 0 && x <= matrix.length-1 && y >= 0 && y <= matrix[0].length-1){
            if(matrix[x][y] > target){
                y = y-1;
            }else if(matrix[x][y] < target){
                x = x+1;
            }else if(matrix[x][y] == target){
                return true;
            }
        }
        return false;
    }
}