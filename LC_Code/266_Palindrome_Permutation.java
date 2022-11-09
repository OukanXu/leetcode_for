package LC_Code;

class Solution {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }else{
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
        }

        int count = 0;
        for(Integer i : map.values()){
            if(i % 2 != 0){
                count +=1;
            }
        }

        if(count == 0 || count == 1){
            return true;
        }else{
            return false;
        }
    }
}