class Solution {
    List<List<Integer>> res = new ArrayList<>();
public List<List<Integer>> permuteUnique(int[] nums) {
    if(nums == null || nums.length == 0){
        return res;
    }

    Arrays.sort(nums);

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
        if(i-1 >= 0 && newNums.get(i) == newNums.get(i-1)){
            continue;
        }else{
            int temp = newNums.get(i);
            newNums.remove(i);
            tempArray.add(temp);
            len = newNums.size();
            process(len, tempArray,newNums);
            tempArray.remove(tempArray.size()-1);
            newNums.add(i,temp);
        }
        
    }
}
}





//round 2
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> newNums = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            newNums.add(nums[i]);
        }

        dfs(newNums,temp,res);
        return res;
    }

    public void dfs(List<Integer> newNums, List<Integer> temp, List<List<Integer>> res){
        if(newNums.size() == 0){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < newNums.size(); i++){
            if(i-1 >= 0 && newNums.get(i) == newNums.get(i-1)) continue;

            int number = newNums.get(i);
            temp.add(number);
            newNums.remove(i);
            dfs(newNums,temp,res);
            newNums.add(i,number);
            temp.remove(temp.size()-1);
        }
    }
}



//use visited[]   faster
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        boolean[] visited = new boolean[nums.length];

        dfs(nums,visited,temp,res);
        return res;
    }


    public void dfs(int[] nums, boolean[] visited, List<Integer> temp, List<List<Integer>> res){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;
            if(i-1 >= 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;

            temp.add(nums[i]);
            visited[i] = true;
            dfs(nums,visited,temp,res);
            temp.remove(temp.size()-1);
            visited[i] = false;
        }
    }
}