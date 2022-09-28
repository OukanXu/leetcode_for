class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 0){
            return res;
        }

        ArrayList<Integer> tempArray = new ArrayList<>();
        int i = 0;
        process(candidates,target,tempArray,i);
        return res;
    }

    public void process(int[] candidates, int target, ArrayList<Integer> tempArray,int i){
        if(target < 0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(tempArray));
            return;
        }

        for(; i < candidates.length; i++){
            tempArray.add(candidates[i]);
            
            process(candidates,target-candidates[i],tempArray, i);
            tempArray.remove(tempArray.size()-1);
        }
    }
}