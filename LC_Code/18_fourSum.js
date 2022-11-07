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