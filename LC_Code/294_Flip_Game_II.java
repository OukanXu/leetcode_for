package LC_Code;

class Solution {
    public boolean canWin(String currentState) {

        for(int i = 0; i < currentState.length()-1; i++){
            if(currentState.charAt(i) == '+' && currentState.charAt(i+1) == '+'){
                StringBuilder str = new StringBuilder(currentState);

                str.setCharAt(i, '-');
                str.setCharAt(i+1, '-');
                String newStr = str.toString();

                if(!canWin(newStr)){
                    return true;
                }
            }
        }
        return false;

    }
}
