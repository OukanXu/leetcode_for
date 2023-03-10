class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }

        int res = 0;
        for(int i : map.keySet()){
            if(map.get(i) > nums.length/2){
                res = i; 
            }
        }
        return res;
    }
}



//round 2
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            if(!map.containsKey(num)){
                map.put(num,1);
            }else{
                map.put(num,map.get(num)+1);
            }
        }
        
        int res = 0;
        for(int k : map.keySet()){
            if(map.get(k) > nums.length/2){
                res = k;
            }
        }
        return res;
    }
}