class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        process(nums,0,temp);
        return res;
    }

    public void process(int[] nums, int index, List<Integer> temp){
        if(index == nums.length){
            res.add(new ArrayList(temp));
            return;
        }

        process(nums,index+1,temp);
        temp.add(nums[index]);
        process(nums,index+1,temp);
        temp.remove(temp.size()-1);
    }
}
