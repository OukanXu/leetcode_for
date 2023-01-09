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


//round 2
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;

        int max = 0;
        while(left < right){
            int less = Math.min(height[left],height[right]);
            int area = (right-left)*less;
            max = Math.max(max,area);

            if(height[left] == less){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}