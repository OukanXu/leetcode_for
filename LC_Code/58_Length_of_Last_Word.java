class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int len = s.length();
        for(int i = len-1; i >= 0; i--){
            if(s.charAt(i) == ' '){
                return len-1-i;
            }
        }
        return len;
    }
}


//round 2
class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length()-1;
        int count = 0;

        while(i >= 0 && s.charAt(i) == ' '){
            i--;
        }

        while(i >= 0 && Character.isAlphabetic(s.charAt(i))){
            i--;
            count++;
        }
        return count;
    }
}