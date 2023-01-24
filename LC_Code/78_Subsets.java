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


//round 2
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int index = 0;
        dfs(nums,index,temp,res);
        return res;
    }

    public void dfs(int[] nums,int index, List<Integer> temp, List<List<Integer>> res){
        if(index == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        //不要
        dfs(nums,index+1,temp,res);

        //要
        temp.add(nums[index]);
        dfs(nums,index+1,temp,res);
        temp.remove(temp.size()-1);
    }
}