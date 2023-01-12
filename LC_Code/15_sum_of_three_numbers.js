/**
 * @param {number[]} nums
 * @return {number[][]}
 */

/* 标签：数组遍历
 首先对数组进行排序，排序后固定一个数 nums[i]，再使用左右指针指向 nums[i]后面的两端，数字分别为 nums[L] 和 nums[R]，计算三个数的和 sumsum 判断是否满足为 00，满足则添加进结果集
 如果 nums[i]nums[i]大于 00，则三数之和必然无法等于 00，结束循环
 如果 nums[i]nums[i] == nums[i-1]nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
 当 sumsum == 00 时，nums[L]nums[L] == nums[L+1]nums[L+1] 则会导致结果重复，应该跳过，L++
 当 sumsum == 00 时，nums[R]nums[R] == nums[R-1]nums[R−1] 则会导致结果重复，应该跳过，R--
 时间复杂度：O(n^2)O(n 

  )，nn 为数组长度
 */

 var threeSum = function(nums) {
    let res = [];
    let len = nums.length;
    if(nums == null || len < 3) return res;
    nums.sort((a,b) => a-b);
    for(let i = 0; i < len; i++){
        if(nums[i]>0) break;
        if(nums[i] == nums[i-1]) continue;
        let left = i+1;
        let right = len-1;
        while(left < right){
            let sum = nums[i] + nums[left] + nums[right];
            if(sum == 0){
                res.push([nums[i],nums[left],nums[right]]);
                while(left<right && nums[left] == nums[left+1]) left++;
                while(left<right && nums[right] == nums[right-1]) right--;
                left++;
                right--;
            }else if(sum < 0){
                left++;
            }else if(sum > 0){
                right--;
            }
        }
    }
    return res;
};


//round 2
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int target = -nums[i];

            if(target < 0) break;
            if( i > 0 && nums[i] == nums[i-1]) continue;

            int left = i+1;
            int right = nums.length-1;

            while(left < right){
                int temp = nums[left] + nums[right];

                if(temp > target){
                    while(right-1 >= 0 && nums[right] == nums[right-1] && left < right){
                        right--;
                    }
                    right--;
                }else if(temp < target){
                    while(left+1 < nums.length && nums[left] == nums[left+1] &&  left < right){
                        left++;
                    }
                    left++;
                }else{
                    List<Integer> temp1 = new ArrayList<>();
                    temp1.add(-target);
                    temp1.add(nums[left]);
                    temp1.add(nums[right]);
                    res.add(temp1);
                    while(left+1 < nums.length && nums[left] == nums[left+1] &&  left < right){
                        left++;
                    }
                    while(right-1 >= 0 && nums[right] == nums[right-1] && left < right){
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }

        return res;
    }
}