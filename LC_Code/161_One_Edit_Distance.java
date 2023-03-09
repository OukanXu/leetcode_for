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


//round 2
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();

        if(lenT > lenS){
            return isOneEditDistance(t,s);
        }
        if(lenS-lenT >= 2){
            return false;
        }

        if(lenS == 0 || lenT == 0){
            return lenS-lenT == 1;
        }
        boolean res = false;

        for(int i = 0; i < lenT; i++){
            if(s.charAt(i) != t.charAt(i)){
                if(lenT == lenS){
                    return res = s.substring(i+1).equals(t.substring(i+1));
                }else{
                    return res = s.substring(i+1).equals(t.substring(i));
                }
            }
        }
        return lenS-lenT == 1;
    }
}