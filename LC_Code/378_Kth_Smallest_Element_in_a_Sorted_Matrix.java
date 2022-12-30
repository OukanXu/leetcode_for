//多路归并  只考虑了每行升序
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return matrix[a[0]][a[1]]-matrix[b[0]][b[1]];
            }
        });

        for(int i = 0; i < matrix.length; i++){
            pq.add(new int[]{i,0});
        }

        while(k != 1 && !pq.isEmpty()){
            int[] temp = pq.poll();
            if(temp[1]+1 < matrix[0].length){
                pq.add(new int[]{temp[0],temp[1]+1});
            }
            k--;
        }

        int[] res = pq.peek();
        return matrix[res[0]][res[1]];
    }
}



//best 区域二分查找 考虑了每行和每列都升序
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        int left  = matrix[0][0];
        int right = matrix[n-1][n-1];

        while(left < right){
            int mid = left + ((right-left)>>1);
            if(check(matrix,k,n,mid)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    public boolean check(int[][] matrix, int k, int n, int mid){
        int i = n-1;
        int j = 0;
        int num = 0;

        while(i >= 0 && j < n){
            if(matrix[i][j] <= mid){
                num += i+1;
                j++;
            }else{
                i--;
            }
        }
        return num >= k;
    }
}