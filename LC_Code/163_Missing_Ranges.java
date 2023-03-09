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



//round 2
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();

        if(nums.length == 0){
            if(upper-lower> 0){
                res.add(deal(lower-1,upper+1));
            }else{
                res.add(String.valueOf(lower));
            }
            return res;
        }
        if(nums[0] - lower > 1){
            res.add(deal(lower-1,nums[0]));
        }else if(nums[0] - lower == 1){
            res.add(String.valueOf(lower));
        } 
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i+1] - nums[i] > 1){
                res.add(deal(nums[i],nums[i+1]));
            }
        }

        if(upper - nums[nums.length-1] > 1){
            res.add(deal(nums[nums.length-1],upper+1));
        }else if(upper - nums[nums.length-1] == 1){
            res.add(String.valueOf(upper));
        }
        return res;
    }

    public String deal(int a, int b){
        StringBuilder sb = new StringBuilder();

        if(b-a == 2){
            sb.append(String.valueOf(a+1));
        }else{
            sb.append(String.valueOf(a+1));
            sb.append("->");
            sb.append(String.valueOf(b-1));
        }

        return sb.toString();
    }
}