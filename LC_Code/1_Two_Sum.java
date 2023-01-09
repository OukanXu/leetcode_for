class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{i,map.get(target - nums[i])};
            }
            map.put(nums[i],i);
        }

        return new int[2];
    }
}

//round 2
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        HashMap<Integer,Integer> map= new HashMap<>();
        ;
        for(int i = 0; i < length; i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[2];

    }
}