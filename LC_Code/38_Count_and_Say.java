
class Solution {
    public String countAndSay(int n) {
        String s1 = "1";

        for(int i = 2; i <= n; i++){
            StringBuilder str = new StringBuilder();

            int pos = 0;
            int start = 0;
            while(pos < s1.length()){
                while(pos < s1.length() && s1.charAt(pos) == s1.charAt(start)){
                    pos++;
                }
                str.append(Integer.toString(pos-start));
                str.append(s1.charAt(start));
                start = pos;
            }
            s1 = str.toString();
        }
        return s1;
    }
}

