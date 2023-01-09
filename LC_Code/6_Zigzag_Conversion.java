
class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();

        for(int i = 0; i < numRows; i++){
            list.add(new StringBuilder());
        }

        int flag = 1;
        int index = 0;
        for(char c : s.toCharArray()){
            list.get(index).append(c);
            index += flag;
            if(index == 0 || index == numRows-1){
                flag = -flag;
            }
        }

        StringBuilder str = new StringBuilder();
        for(StringBuilder sb : list){
            str.append(sb);
        }
        return str.toString();
    }
}