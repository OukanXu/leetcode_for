class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.put(nums[i], map.get(nums[i])+1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return map.get(a)-map.get(b);
            }
        }   
        ); 



        for(Integer key : map.keySet()){
            if(pq.size() < k){
                pq.add(key);
            }else{
                if(map.get(key) > map.get(pq.peek())){
                    pq.remove();
                    pq.add(key);
                }
            }
        }

        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = pq.remove();
        }
        return res;
    }
}