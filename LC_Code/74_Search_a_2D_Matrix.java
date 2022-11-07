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