class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }

        int left = 0;
        int right = matrix[0].length-1;//列
        int top = 0;
        int buttom = matrix.length-1;//行

        while(left <= right && top <= buttom){
            for(int i = left; i <= right; i++){
                res.add(matrix[left][i]);
            }

            for(int j = top+1; j <= buttom; j++){
                res.add(matrix[j][right]);
            }

            if(left < right && top < buttom ){
                for(int i = right-1; i > left; i--){
                    res.add(matrix[buttom][i]);
                }

                for(int j = buttom; j > top; j--){
                    res.add(matrix[j][left]);
                }
            }
            left++;
            top++;
            right--;
            buttom--;
        }
        return res;



    }
}


//round 2
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length-1;
        int top = 0;
        int buttom = matrix.length-1;

        List<Integer> res = new ArrayList<>();

        while(left <= right && top <= buttom){
            for(int i = left; i <= right; i++){
                res.add(matrix[top][i]);
            }

            for(int j = top+1; j <= buttom; j++){
                res.add(matrix[j][right]);
            }

            if(left < right && top < buttom){
                for(int i = right-1; i >= left; i--){
                    res.add(matrix[buttom][i]);
                }

                for(int j = buttom-1; j >= top+1; j--){
                    res.add(matrix[j][left]);
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
