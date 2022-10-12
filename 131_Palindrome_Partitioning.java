class Solution {
    List<List<String>> res = new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {
        if(s.length() == 0){
            return res;
        }
        if(s.length() == 1){
            List<String> temp = new ArrayList<>();
            temp.add(s);
            res.add(temp);
            return res;
        }
        List<String> temp = new ArrayList<>();
        dfs(s,temp,0,s.length());
        return res;
    }

    public void dfs(String s, List<String> temp, int start, int end){
        if(start >= s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start+1; i <= end; i++){
            String subString = s.substring(start,i);
            if(check(subString,0,subString.length()-1)){
                temp.add(subString);
                dfs(s,temp,i,end);
                temp.remove(temp.size()-1);
            }
        }
    }

    public boolean check(String s, int left, int right){
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}