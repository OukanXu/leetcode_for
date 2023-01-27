class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
            for(int i = nums1.length-1; i >=0; i--){
                if(m-1>=0 && n-1>=0){
                    nums1[i] = nums1[m-1] > nums2[n-1] ? nums1[--m] : nums2[--n];
                }else if(m-1>=0){
                    nums1[i] = nums1[--m];
                }else if(n-1>=0){
                    nums1[i] = nums2[--n];
                }

                
            }
        
    }
}


//round 2
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while(m > 0 && n > 0){
            if(nums1[m-1] > nums2[n-1]){
                nums1[m+n-1] = nums1[m-1];
                m--;
            }else{
                nums1[m+n-1] = nums2[n-1];
                n--;
            }
        }

        while(n > 0){
            nums1[n-1] = nums2[n-1];
            n--;
        }
        
    }
}