class Solution {
    public int[][] generateMatrix(int n) {
        

        int left = 0;
        int right = n-1;//列
        int top = 0;
        int buttom = n-1;//行

        int[][] matrix = new int[n][n];
        int m = 1;
        while(left <= right && top <= buttom){
            for(int i = left; i <= right; i++){
                matrix[top][i] = m;
                m++;
            }

            for(int j = top+1; j <= buttom; j++){
                matrix[j][right] = m;
                m++;
            }

            if(left < right && top < buttom){
                for(int i = right-1; i >= left; i--){
                    matrix[buttom][i] = m;
                    m++;
                }

                for(int j = buttom-1; j > top; j--){
                    matrix[j][left] = m;
                    m++;
                }
            }
            left++;
            right--;
            top++;
            buttom--;
        }
        return matrix;
    }
}







//round 2
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int left = 0;
        int right = n-1;
        int top = 0;
        int buttom = n-1;
        int count = 1;

        while(left <= right && top <= buttom){
            for(int i = left; i <= right; i++){
                res[top][i] = count;
                count++;
            }

            for(int i = top+1; i <= buttom; i++){
                res[i][right] = count;
                count++;
            }

            if(left < right && top < buttom){
                for(int i = right-1; i >= left; i--){
                    res[buttom][i] = count;
                    count++;
                }

                for(int i = buttom-1; i > top; i--){
                    res[i][left] = count;
                    count++;
                }
            }
            left++;
            right--;
            top++;
            buttom--;
        }
        return res;
    }
}