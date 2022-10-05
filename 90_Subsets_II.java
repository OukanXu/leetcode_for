class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        process(false,nums,0);
        return res;
    }

    public void process(boolean choosePre,int[] nums, int index){
        if(index == nums.length){
            res.add(new ArrayList(temp));
            return;
        }

        
        process(false,nums,index+1);
        if(!choosePre && index > 0 && nums[index-1] == nums[index]){
            return;
        }
        temp.add(nums[index]);
        process(true,nums,index+1);
        temp.remove(temp.size()-1);
        
        
    }
}



