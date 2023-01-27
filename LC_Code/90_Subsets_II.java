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

//round 2
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        int index = 0;
        boolean pre = false;
        dfs(nums,index,temp,res,pre);
        return res;
    }

    public void dfs(int[] nums, int index, List<Integer> temp, List<List<Integer>> res, boolean pre){
        if(index == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        dfs(nums,index+1,temp,res,false);

        if(index > 0 && nums[index] == nums[index-1] && !pre){
            return;
        }else{
            temp.add(nums[index]);
            dfs(nums,index+1,temp,res,true);
            temp.remove(temp.size()-1);
        }
        
    }
}

