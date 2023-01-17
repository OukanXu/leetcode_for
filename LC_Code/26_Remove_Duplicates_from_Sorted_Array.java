class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null){
            return 0;
        }
        int i = 0;
        int j = i+1;
        int sum = 1;

        while(j < nums.length){
            if(nums[i] == nums[j]){
                j++;
            }else{
                swap(nums,i+1,j);
                i++;
                j++;
                sum++;
            }
        }
        return sum;
    }

    public void swap(int[] arr, int i, int j){
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


//round 2
class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = slow+1;

        int n = nums.length;
        int sum = 1;

        while(fast < n){
            if(nums[slow] == nums[fast]){
                fast++;
            }else{
                swap(nums,slow+1,fast);
                slow++;
                fast++;
                sum++;

            }
        }
        return sum;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
