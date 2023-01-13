/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[][]}
 */
 var fourSum = function(nums, target) {
    let len = nums.length;
    let res = [];
    if(nums == null || len < 4) return [];
    nums.sort((a,b) => a-b);

    for(let i = 0; i < len-3; i++){
        if(i>0 && nums[i] == nums[i-1]) continue;
        if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3] > target) break;
        if(nums[i]+nums[len-1]+nums[len-2]+nums[len-3] < target) continue;
        for(let j = i+1; j < len-2; j++){
            if(j> i+1 && nums[j] == nums[j-1]) continue;
            if(nums[i]+nums[j]+nums[j+1]+nums[j+2] > target) break;
            if(nums[i]+nums[j]+nums[len-1]+nums[len-2] < target) continue;
            let L = j+1;
            let R = len-1;
            while(L<R){
                
                let sum = nums[i] + nums[j] + nums[L] + nums[R];
                if(sum > target){
                    R--;
                }else if(sum < target){
                    L++;
                }else{
                    res.push([nums[i],nums[j],nums[L],nums[R]]);
                    while(L<R && nums[L] == nums[L+1]) L++;
                    while(L<R && nums[R] == nums[R-1]) R--;
                    L++;
                    R--;
                }
                
            }
            
        }
    }
    return res;
};



//round 2
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(nums[0] > 0 && nums[0] > target){
            return res;
        }
        for(int i = 0; i < nums.length-3; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            if(i+3 < n && (long)(nums[i+2]+nums[i+3]) > target-nums[i]-nums[i+1]) break;
            if(n-3 >= 0 && (long)(nums[i]+nums[n-2]+nums[n-3]) < target-nums[n-1]) continue;
            for(int j = i+1; j < nums.length-2; j++){
                if(j != i+1 && nums[j] == nums[j-1]) continue;
                if(j+2 < n && (long)(nums[j+1]+nums[j+2]) > target-nums[i]-nums[j]) break;
                if(n-2 > j && (long)(nums[i]+nums[j]+nums[n-2]) < target-nums[n-1]) continue;
                int left = j+1;
                int right = n-1;
                
                while(left < right){
                    long temp = nums[i]+nums[j]+nums[left]+nums[right];
                    if(temp < target){
                        left++;
                    }else if(temp > target){
                        right--;
                    }else if(temp == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                        while(left+1 < n && nums[left] == nums[left+1]){
                            left++;
                        }
                        while(right-1 >= 0 && nums[right] == nums[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    }

                    
                }
            }
        }

        return res;
    }
}