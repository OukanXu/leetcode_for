class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int preSum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        map.put(0,-1);
        for(int i = 0; i < nums.length; i++){
            preSum += nums[i];
            if(map.containsKey(preSum-k)){
                max = Math.max(max,i-map.get(preSum-k));
            }

            map.putIfAbsent(preSum,i);
        }
        return max;
    }
}