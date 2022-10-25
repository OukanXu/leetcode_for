class Solution {
    public void reverseWords(char[] s) {
        //reverse array
        for(int i = 0, j = s.length-1; i <= j; i++, j--){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }

        //reverse every word
        int left = 0;
        int right = 0;
        while(right <= s.length-1){
            while(right <= s.length-1 && s[right] != ' '){
                right++;
            }
            for(int i = left, j = right-1; i <= j; i++, j--){
                char temp = s[i];
                s[i] = s[j];
                s[j] = temp;
            }
            right++;
            left = right;
        }

    }
}
