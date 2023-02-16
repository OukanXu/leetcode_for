class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLength = 0;
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i]-1)){
                continue;
            }else{
                int currentLength = 1;
                int currentNum = nums[i];
                while(set.contains(currentNum+1)){
                    currentLength+=1;
                    currentNum+=1;
                }
                maxLength = Math.max(maxLength,currentLength);
            }
        }
        return maxLength;
    }
}


//round 2
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        int maxLength = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(set.contains(nums[i]-1)){
                continue;
            }else{
                int currentLength = 1;
                int currentNum = nums[i];
                while(set.contains(currentNum+1)){
                    currentLength++;
                    currentNum++;
                }
                maxLength = Math.max(maxLength,currentLength);
            }
        }
        return maxLength;
    }
}



class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
