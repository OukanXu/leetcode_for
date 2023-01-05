//34%
class Solution {
    public char findTheDifference(String s, String t) {
        int[] array = new int[26];
        for(int i = 0; i < s.length(); i++){
            array[s.charAt(i)-'a']++;
        }

        for(int i = 0; i < t.length(); i++){
            array[t.charAt(i)-'a']--;
        }
        char ch;
        int index = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] == -1){
                index = i;
            }
        }

        return (char)(index+97);
    }
}




//76%
class Solution {
    public char findTheDifference(String s, String t) {
        int res = 0;
        for(int i = 0; i < t.length(); i++){
            res ^= t.charAt(i);
        }

        for(int i = 0; i < s.length(); i++){
            res ^= s.charAt(i);
        }

        return (char)res;
    }
}


//98%
class Solution {
    public char findTheDifference(String s, String t) {
        char[] charArr = s.concat(t).toCharArray();

        char res = 0;
        for(char c : charArr){
            res ^= c;
        }
        return res;
    }
}
