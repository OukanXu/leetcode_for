class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }

        String res = strs[0];
        for(int i = 1; i < strs.length; i++){
            int j = 0;
            for(;j < strs[i].length() && j < res.length(); j++){
                if(res.charAt(j) != strs[i].charAt(j)){
                    break;
                }
            }
            res = res.substring(0,j);
            if(res.equals("")){
                return res;
            }
        }
        return res;
    }
}

// round 2
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = strs[0];

        for(int i = 1; i < strs.length; i++){
            if(res.equals("")){
                return res;
            }
            int j = 0;
            while(j < strs[i].length() && j < res.length()){
                if(res.charAt(j) == strs[i].charAt(j)){
                    j++;
                }else{
                    break;
                }
                
            }
            res = res.substring(0,j);
            
        }
        return res;
    }
}