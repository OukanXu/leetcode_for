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
