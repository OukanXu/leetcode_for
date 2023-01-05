class Solution {
    int[] nums;
    int[] alter;
    public Solution(int[] nums) {
        alter = new int[nums.length];
        this.nums = nums;
        for(int i = 0; i < nums.length; i++){
            alter[i] = nums[i];
        }
    }
    
    public int[] reset() {
        return nums;
    }
    
    public int[] shuffle() {
        
        for(int i = 0; i < nums.length; i++){
            int nextIndex = i + (int) (Math.random() * (nums.length - i));
            swap(alter, i, nextIndex);
        }
        return alter;
    }

    public void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */