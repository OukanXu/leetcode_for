class Solution {
    public int titleToNumber(String columnTitle) {
        int res = 0;

        for(int i = 0; i < columnTitle.length(); i++){
            char temp = columnTitle.charAt(i);
            res = res * 26;
            res = res + (int)(temp-'A'+1);
            
        }
        return res;
    }
}


//round 2
class Solution {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        int index = 0;
        int len = columnTitle.length();

        while(index < len){
            res = res*26;
            res += columnTitle.charAt(index)-'A'+1;
            
            index++;
        }
        return res;
    }
}