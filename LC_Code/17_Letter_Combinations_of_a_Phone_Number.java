class Solution {

    ArrayList<String> res = new ArrayList<>();
    String[] arr = new String[]{
        "",
        " ",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")){
            return res;
        }

        String s = "";

        process(digits,0,s);
        return res;
    }

    public void process(String digits, int i, String s){
        if(i == digits.length()){
            res.add(s);
            return;
        }

        int index = digits.charAt(i)-'0';
        String result = arr[index];//for '2', "abc"
        for(int j = 0; j < result.length(); j++){
            process(digits,i+1,s+result.charAt(j));
        }
    }
}



//round 2
class Solution {
    public List<String> letterCombinations(String digits) {
        
        HashMap<Character,String> map = new HashMap<>();

        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        List<String> res = new ArrayList<>();
        int n = digits.length();

        if(digits.equals("")){
            return res;
        }
        dfs(digits,map,res,0,n,new StringBuilder());
        return res;
    }

    public void dfs(String digits, HashMap<Character,String> map, List<String> res, int index, int n, StringBuilder sb){
        if(index == n){
            res.add(sb.toString());
            return;
        }

        String temp = map.get(digits.charAt(index));

        for(Character c : temp.toCharArray()){
            sb.append(c);
            dfs(digits,map,res,index+1,n,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        return;
    }
}