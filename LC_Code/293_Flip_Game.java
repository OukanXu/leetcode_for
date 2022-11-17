package LC_Code;

class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {

        List<String> res = new ArrayList<>();

        for(int i = 0; i < currentState.length()-1; i++){
            if(currentState.charAt(i) == '+' && currentState.charAt(i+1) == '+'){
                StringBuilder str = new StringBuilder(currentState);

                str.setCharAt(i, '-');
                str.setCharAt(i+1, '-');
                res.add(str.toString());
            }
        }
        return res;
    }
}