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