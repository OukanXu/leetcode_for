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
