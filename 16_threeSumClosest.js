/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */

/* 超时
 var threeSumClosest = function(nums, target) {
    let len = nums.length;
    let res = [];
    let sumArr =[];
    if(nums == null || len < 3) return;

    nums.sort((a,b) => a-b);
    for(let i = 0; i < len; i++){
        for(let L = i+1; L<len; L++){
            for(let R = L+1; R<len; R++){
                let sum = nums[i] + nums[L] + nums[R];
                let result = Math.abs(sum-target);
                sumArr.push(sum);
                res.push(result);
            }
        }       
    }
    let minIndex = 0;
    for(let i = 0; i < res.length; i++){
        if(res[i] < res[minIndex]){
            minIndex = i;
        }
    }
    return sumArr[minIndex];

};
*/

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
 var threeSumClosest = function(nums, target) {
    let len = nums.length;
    if(nums == null || len < 3)return;
    nums.sort((a,b) => a-b);
    let result = nums[0]+nums[1]+nums[2];

    for(let i = 0; i < len; i++){
        let L = i+1;
        let R = len-1;
        while(L<R){
            let sum = nums[i]+nums[L]+nums[R];
            if(Math.abs(sum-target) < Math.abs(result-target)){
                result = sum;
            }
            if(sum > target) {
                R--;
            }else if(sum < target) {
                L++;
            }else{
                return result;
            }

        }
    }
    return result;

};