class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length == 0){
            return res;
        }

        ArrayList<Integer> tempArray = new ArrayList<>();
        Arrays.sort(candidates);
        int i = 0;
        process(candidates,target,tempArray,i);
        return res;
    }


    public void process(int[] candidates, int target, ArrayList<Integer> tempArray,int start){
        if(target < 0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(tempArray));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if(i > start && candidates[i] == candidates[i-1]){
                continue;
            }
            tempArray.add(candidates[i]);
            process(candidates,target-candidates[i],tempArray,i+1);
            tempArray.remove(tempArray.size()-1);
            
        }
        
    }
}
