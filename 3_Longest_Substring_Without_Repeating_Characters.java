class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        HashMap<Character,Integer> list = new HashMap<>();
        int start = 0;
        int end = 0;
        int result = 0;


        /**
            对于未重复的字符，加入哈希表，并且更新当前窗口开始点到目前的距离
            对于重复的字符，找到上个相同的字符的位置，将开始节点放置在其+1位置和当前节点所在位置的最大值，更新窗口最大长度和哈希表
         */
        for(int i = 0; i < s.length(); i++){
            if(!list.containsKey(s.charAt(i))){
                list.put(s.charAt(i),i);
                result = Math.max(result,i-start+1);
            }else{
                start = Math.max(start,list.get(s.charAt(i))+1);
                result = Math.max(result,i-start+1);
                list.put(s.charAt(i),i);
            }
            
        }

        return result;
    }
}