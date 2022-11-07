class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();

        if(lenS > lenT){
            return isOneEditDistance(t,s);
        }

        if(lenT -lenS >= 2){
            return false;
        }

        if(s.equals(t)){
            return false;
        }

        for(int i = 0; i < lenS; i++){
            if(s.charAt(i) != t.charAt(i)){
                if(lenS == lenT){
                    return s.substring(i+1).equals(t.substring(i+1));
                }else{
                    return s.substring(i).equals(t.substring(i+1));
                }
            }
        }

        return (lenT-lenS == 1);
    }
}
