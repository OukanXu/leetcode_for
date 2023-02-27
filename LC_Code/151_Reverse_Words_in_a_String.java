class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] str = s.split(" ");

        String res = "";
        for(int i = str.length-1; i >= 0; i--){
            if(!str[i].equals("")){
                res += str[i];
                res += " ";
            }
        }

        return res.trim();
    }
}


//round 2
class Solution {
    public String reverseWords(String s) {
        int n = s.length()-1;

        StringBuilder sb = new StringBuilder();

        int right = n;
        int left = n;

        while(left >= 0){
            if(s.charAt(left) == ' '){
                left--;
            }else{
                right = left+1;
                while(left >= 0 && Character.isLetterOrDigit(s.charAt(left))){
                    left--;
                }
                sb.append(s.substring(left+1,right));
                sb.append(' ');
            }
        }
        
        return sb.toString().trim();
    }
}