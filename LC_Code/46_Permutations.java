class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0){
            return res;
        }

        ArrayList<Integer> newNums = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            newNums.add(nums[i]);
        }


        int len = newNums.size();
        ArrayList<Integer> tempArray = new ArrayList<>();

        process(len,tempArray,newNums);
        return res;
    }

    public void process(int len, ArrayList<Integer> tempArray, ArrayList<Integer> newNums){
        if(len == 0){
            res.add(new ArrayList<>(tempArray));
            return;
        }

        for(int i = 0; i < newNums.size(); i++){
            int temp = newNums.get(i);
            newNums.remove(i);
            tempArray.add(temp);
            len = newNums.size();
            process(len, tempArray,newNums);
            tempArray.remove(Integer.valueOf(temp));
            newNums.add(i,temp);
        }
    }
}

// round 2
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int[] visited = new int[nums.length];

        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        dfs(nums, visited, temp, res);
        return res;
    }

    public void dfs(int[] nums, int[] visited, List<Integer> temp, List<List<Integer>> res){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i] == 1) continue;
            temp.add(nums[i]);
            visited[i] = 1;
            dfs(nums,visited,temp,res);
            temp.remove(temp.size()-1);
            visited[i] = 0;
        }
    }
}