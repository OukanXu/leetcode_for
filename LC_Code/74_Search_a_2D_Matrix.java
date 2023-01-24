class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int buttom = matrix.length-1;
        int index = 0;
        while(top <= buttom){
            int mid = top + (buttom-top)/2;
            if(matrix[mid][0] <= target){
                index = mid;
                top = mid+1;
            }else{
                buttom = mid-1;
            }
        }

        int left = 0;
        int right = matrix[0].length-1;
        boolean res = false;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(matrix[index][mid] == target){
                res = true;
                return res;
            }else if(matrix[index][mid] < target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return res;
    }
}

//round 2
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int rowLeft = 0;
        int rowRight = m-1;
        int rowMid = 0;
        while(rowLeft <= rowRight){
            rowMid = rowLeft + (rowRight-rowLeft)/2;
            if(target < matrix[rowMid][0]){
                rowRight = rowMid-1;
            }else if(target > matrix[rowMid][n-1]){
                rowLeft = rowMid+1;
            }else{
                break;
            }
        }

        if(rowMid >= m){
            return false;
        }

        int left = 0;
        int right = n-1;
        while(left <= right){
            int mid = left + (right-left)/2;

            if(target < matrix[rowMid][mid]){
                right = mid-1;
            }else if( target > matrix[rowMid][mid]){
                left = mid+1;
            }else if(target == matrix[rowMid][mid]){
                return true;
            }
        }
        return false;

    }
}