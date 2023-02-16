class Solution {
    public boolean isPalindrome(String s) {

        if(s.trim().length() == 0){
            return true;
        }

        int left = 0;
        int right = s.length()-1;
        
        while(left < right){
            while(left < right&&!Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(left < right&&!Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(left < right && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
                
                }else{
                    left++;
                    right--;
                }

        }
        return true;
    }
}

//round 2
class Solution {
    public boolean isPalindrome(String s) {
        if(s.equals("")){
            return true;
        }
        int left = 0; 
        int right = s.length()-1;

        while(left <= right){
            while(left < s.length() && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }

            while(right >= 0 && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }

            if(left < s.length() && right >= 0 && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }else{
                left++;
                right--;
            }
            

        }
        return true;
    }
}
