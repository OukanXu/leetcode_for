class Solution {
    public List<String> summaryRanges(int[] nums) {
        int start = 0;
        int end = 1;
        List<String> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }

        
        while(end < nums.length){
            if(nums[end] - nums[end-1] == 1){
                end++;
            }else{
                if(end-1 == start){
                    StringBuilder str = new StringBuilder();
                    str.append(String.valueOf(nums[start]));
                    res.add(str.toString());
                    start = end;
                    end++;
                }else{
                    StringBuilder str = new StringBuilder();
                    str.append(String.valueOf(nums[start]));
                    str.append('-');
                    str.append('>');
                    str.append(String.valueOf(nums[end-1]));
                    res.add(str.toString());
                    start = end;
                    end++;
                }
            }
        }
        if(end-1 == start){
            StringBuilder str = new StringBuilder();
            str.append(String.valueOf(nums[start]));
            res.add(str.toString());
        }else{
            StringBuilder str = new StringBuilder();
            str.append(String.valueOf(nums[start]));
            str.append('-');
            str.append('>');
            str.append(String.valueOf(nums[end-1]));
            res.add(str.toString());
        }
        return res;

    }
}
