package LC_Code;

class Solution {
    private static final List<int[]> DIRECTIONS = Arrays.asList(
        new int[] { 1,  0},
        new int[] {-1,  0},
        new int[] { 0,  1},
        new int[] { 0, -1}
);
    public void wallsAndGates(int[][] rooms) {
        


        int m = rooms.length;
        int n = rooms[0].length;

        Queue<int[]> stack = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rooms[i][j] == 0){
                    stack.add(new int[]{i,j});
                }
            }
        }

        while(!stack.isEmpty()){
            int[] point = stack.poll();
            int row = point[0];
            int col = point[1];

            for(int[] i : DIRECTIONS){
                int newRow = row+i[0];
                int newCol = col+i[1];

                if(newRow < 0 || newRow > m-1 || newCol < 0 || newCol > n-1 || rooms[newRow][newCol] != 2147483647){
                    continue;
                }
                rooms[newRow][newCol] = rooms[row][col] + 1;
                stack.add(new int[]{newRow,newCol});
            }
        }
    }
}
