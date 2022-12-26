class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] preSum = new int[length];

        for(int i = 0; i < updates.length; i++){
            preSum[updates[i][0]] += updates[i][2];

            if(updates[i][1]+1 < length){
                preSum[updates[i][1]+1] -= updates[i][2];
            }
        }

        for(int i = 1; i < length; i++){
            preSum[i] += preSum[i-1];
        }
        return preSum;
    }
}