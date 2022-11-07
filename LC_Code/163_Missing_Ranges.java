class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();

        if(nums.length == 0){
            if(lower < upper){
                res.add(Integer.toString(lower) + "->"+ Integer.toString(upper));
            }else if(lower == upper){
                res.add(Integer.toString(lower));
            }
            return res;
        }

        if(lower < nums[0] && nums[0] - lower >= 2){
            res.add(Integer.toString(lower) + "->"+ Integer.toString(nums[0]-1));
        }else if(lower < nums[0] && nums[0] - lower == 1){
            res.add(Integer.toString(lower));
        }

        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] < nums[i] && nums[i] - nums[i-1] > 2){
                res.add(Integer.toString(nums[i-1]+1) + "->"+ Integer.toString(nums[i]-1));
            }else if(nums[i-1] < nums[i] && nums[i] - nums[i-1] == 2){
                res.add(Integer.toString(nums[i-1]+1));
            }
        }

        if(nums[nums.length-1] < upper && upper - nums[nums.length-1] >= 2){
            res.add(Integer.toString(nums[nums.length-1]+1) + "->"+ Integer.toString(upper));
        }else if(nums[nums.length-1] < upper && upper - nums[nums.length-1] == 1){
            res.add(Integer.toString(upper));
        }
        return res;
    }
}