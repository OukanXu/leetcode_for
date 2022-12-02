
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length <= nums2.length){
            HashSet<Integer> set = new HashSet<>();
            for(int i = 0; i < nums1.length; i++){
                if(!set.contains(nums1[i])){
                    set.add(nums1[i]);
                }
            }
            ArrayList<Integer> array = new ArrayList<>();
            
            for(int i = 0; i < nums2.length; i++){
                if(set.contains(nums2[i])){
                    set.remove(nums2[i]);
                    array.add(nums2[i]);
                }
            }
            int[] res = new int[array.size()];
            for(int i = 0; i < array.size(); i++){
                res[i] = array.get(i);
            }
            return res;
        }else{
            return intersection(nums2,nums1);
        }
    }
}