class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() <= 2){
            return s.length();
        }

        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int next = 0;
        int right = 1;
        int max = 1;

        map.put(s.charAt(left),0);
        while(left < s.length() && right < s.length()){
            if(s.charAt(right) == s.charAt(left)){
                map.put(s.charAt(left),right);
                right++;
            }else if(s.charAt(right) == s.charAt(next)){
                map.put(s.charAt(next),right);
                right++;
            }else{
                if(map.size() < 2){
                    map.put(s.charAt(right),right);
                    next = right;
                    right++;
                }else{
                    if(map.get(s.charAt(left)) < map.get(s.charAt(next))){
                        max = Math.max(max,right-left);

                        int index = map.get(s.charAt(left));
                        map.remove(s.charAt(left));
                        map.put(s.charAt(right),right);
                        left = index+1;
                        next = right;
                        right++;
                    }else{
                        max = Math.max(max,right-left);
                        int index = map.get(s.charAt(next));
                        map.remove(s.charAt(next));
                        map.put(s.charAt(right),right);
                        left = index+1;
                        next = right;
                        right++;
                    }
                }
            }
        }
        max = Math.max(max,right-left);
        
        
        return max;
    }
}


//round 2
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() < 3){
            return s.length();
        }
        int left = 0;
        int right = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        int res = 2;
        while(right < n){
            map.put(s.charAt(right),right);
            if(map.size() > 2){
                int min_index = Collections.min(map.values());
                map.remove(s.charAt(min_index));
                res = Math.max(res,right-left);
                left = min_index+1;
            }
            right++;
        }
        return Math.max(res,right-left);
    }
}


//faster
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        if (len < 3) {
            return len;
        }
        int[] temp = new int[128];
        int left = 0, right = 0;
        int count = 0, ans = 0;
        while (right < len) {
            if (temp[chars[right] - '0'] == 0) {
                count++;
            }
            temp[chars[right] - '0']++;
            while (count > 2) {
                temp[chars[left] - '0']--;
                if (temp[chars[left] - '0'] == 0) {
                    count--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}