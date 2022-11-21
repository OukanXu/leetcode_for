package LC_Code;

class NumArray {
    int[] nums;
    int[] preSum;
    public NumArray(int[] nums) {
        this.nums = nums;
        preSum = new int[nums.length+1];

        for(int i = 1; i <= nums.length; i++){
            int j = i;
            while(j <= nums.length){
                preSum[j] += nums[i-1];
                j += (j&(-j));//获取j的最后一位1，j+j的最后一位1，好处是每次update只需要调整部分preSum数组
            }
        }
        
    }
    
    public void update(int index, int val) {
        int increase = val - nums[index];
        nums[index] = val;
        index+=1;
        while(index <= nums.length){
            preSum[index] += increase;
            index += (index&(-index));
        }
    }
    
    public int sumRange(int left, int right) {
        
        right +=1;
        int sumleft = 0,sumright = 0;

        while(left>0){
            sumleft += preSum[left];
            left -= (left&(-left));
        }
        
        while(right>0){
            sumright += preSum[right];
            right -= (right&(-right));
        }
        
        return sumright-sumleft;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
