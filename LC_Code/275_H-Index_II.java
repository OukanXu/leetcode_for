package LC_Code;

class Solution {
    public int hIndex(int[] citations) {
        if(citations.length == 1){
            return citations[0] == 0 ? 0 : 1;
        }
        int left = 0; 
        int right = citations.length-1;

        while(left <= right){
            int mid = left + (right-left)/2;

            int count = citations.length-mid;

            if(count <= citations[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return citations.length-left;
    }
}
