
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            res = res ^ nums[i];
        }
        return res;
    }
}

//round 2
class Solution {
    public int singleNumber(int[] nums) {
        int temp = 0;
        for(int num : nums){
            temp ^= num;
        }
        return temp;
    }
}