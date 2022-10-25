class Solution {
    public void rotate(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();

        int length =nums.length;
        int i = k > length ? length-(k%length) : length-k;
        while(res.size() <= nums.length){
            res.add(nums[i%length]);
            i++;
        }

        for(i = 0; i < length; i++){
            nums[i] = res.get(i);
        }
    }
}
