package LC_Code;

class Solution {
    public List<String> generatePalindromes(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }else{
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
        }

        ArrayList<Character> array = new ArrayList<>();
        int count = 0;
        Character mid = null;
        for(char c : map.keySet()){
            if(map.get(c)%2 == 1){
                mid = c;
                count +=1;
            }
            for(int i = 1; i <= map.get(c)/2; i++){
                array.add(c);
            }
            
        }

        if(count > 1){
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        
        boolean[] visited = new boolean[array.size()];
        
        dfs(array,visited,new StringBuilder(),mid,res);
        return res;
    }

    public void dfs(ArrayList<Character> array, boolean[] visited, StringBuilder temp,Character mid, List<String> res){
        if(temp.length() == array.size()){
            String str = "";
            StringBuilder str1 = new StringBuilder(temp.toString());
            StringBuilder str2 = new StringBuilder(temp.toString());
            if(mid != null){
                str = str1.toString() + mid + str2.reverse().toString();
            }else{
                str = str1.toString() + str2.reverse().toString();
            }
            res.add(str);
            return;
        }
        

        for(int i = 0; i < array.size(); i++){
            if(visited[i]){
                continue;
            }else{
                if(i > 0 && array.get(i) == array.get(i-1) && visited[i-1]){
                    continue;
                }else{
                    temp.append(array.get(i));
                    visited[i] = true;
                    dfs(array,visited,temp,mid,res);
                    temp.deleteCharAt(temp.length()-1);
                    visited[i] = false;
                }
            }
        }
    }
}