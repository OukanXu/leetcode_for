class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(k,new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return nums1[a[0]]+nums2[a[1]]-nums1[b[0]]-nums2[b[1]];
            }
        });

        for(int i = 0; i < nums1.length && i < k; i++){
            pq.add(new int[]{i,0});
        }

        while(!pq.isEmpty() && res.size() < k){
            int[] temp = pq.poll();
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nums1[temp[0]]);
            list.add(nums2[temp[1]]);
            res.add(list);
            if(temp[1] + 1 < nums2.length){
                pq.add(new int[]{temp[0],temp[1]+1});
            }
        }
        return res;
    }
}
