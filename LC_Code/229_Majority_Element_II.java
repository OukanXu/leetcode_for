class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int length = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i <length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.put(nums[i], map.get(nums[i])+1);
            }
        }

        for(int key : map.keySet()){
            if(map.get(key) > length/3){
                res.add(key);
            }
        }
        return res;
    }
}
