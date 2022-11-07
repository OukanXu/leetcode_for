class Solution {
    public int maxArea(int[] height) {
        //find top 2
        if(height == null || height.length == 0){
            return 0;
        }

        int maxArea = 0;
        int left = 0;
        int right = height.length-1;

        while(left>=0 && right <= height.length-1 && left < right){
            int mi = Math.min(height[left],height[right]);
            int area = (right-left) * mi;
            if(maxArea < area){
                maxArea = area;
            }
            if(height[left] == mi){
                left++;
            }else{
                right--;
            }
        }
        

        return maxArea;
    }
}
