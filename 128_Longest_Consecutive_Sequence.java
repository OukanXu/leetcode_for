class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLength = 0;
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i]-1)){
                continue;
            }else{
                int currentLength = 1;
                int currentNum = nums[i];
                while(set.contains(currentNum+1)){
                    currentLength+=1;
                    currentNum+=1;
                }
                maxLength = Math.max(maxLength,currentLength);
            }
        }
        return maxLength;
    }
}
