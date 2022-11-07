class Solution {
    public boolean isIsomorphic(String s, String t) {
        int lens = s.length();
        int lent = t.length();

        HashMap<Character,Character> map = new HashMap<>();
        HashMap<Character,Character> remap = new HashMap<>();
        for(int i = 0; i < lens; i++){
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);

            if(!map.containsKey(s1)){
                map.put(s1,t1);
            }else{
                char tempT1 = map.get(s1);
                if(tempT1 != t1){
                    return false;
                }
            }

            if(!remap.containsKey(t1)){
                remap.put(t1,s1);
            }else{
                char tempS1 = remap.get(t1);
                if(tempS1 != s1){
                    return false;
                }
            }

        }
        return true;
    }
}