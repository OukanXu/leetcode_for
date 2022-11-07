
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        int[] res = new int[2];
        while(left < right){
            int temp = numbers[left]+numbers[right];
            if(temp > target){
                right--;
            }else if(temp < target){
                left++;
            }else{
                res[0] = left+1;
                res[1] = right+1;
                break;
            }
        }
        return res;
    }
}