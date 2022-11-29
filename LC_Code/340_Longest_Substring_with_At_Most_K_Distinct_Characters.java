class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        if(k == 0){
            return 0;
        }
        int len = 1;
        while(right < n){
            map.put(s.charAt(right),right);
            if(map.size() > k){
                int temp = Collections.min(map.values());
                map.remove(s.charAt(temp));
                left = temp+1;
            }
            len = Math.max(right-left+1,len);
            right++;
        }
        return len;
    }
}
