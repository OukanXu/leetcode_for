class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();

        dfs(res,word,0,0,new StringBuilder());
        return res;
    }

    public void dfs(List<String> res, String word, int index, int count, StringBuilder str){
        int len = str.length();
        if(index == word.length()){
            if(count != 0) str.append(String.valueOf(count));
            res.add(str.toString());
        }else{
            
            dfs(res,word,index+1,count+1,str);

            if(count != 0) str.append(String.valueOf(count));
            str.append(word.charAt(index));
            dfs(res,word,index+1,0,str);
            

        }
        str.setLength(len);
    }
}
