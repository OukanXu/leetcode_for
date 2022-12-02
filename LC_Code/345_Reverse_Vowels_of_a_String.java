class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        char[] str = s.toCharArray();
        int left = 0; 
        int right = str.length-1;

        while(left < right){
            while(left < right && !set.contains(str[left])){
                left++;
            }
            while(left < right && !set.contains(str[right])){
                right--;
            }

            swap(str,left,right);
            left++;
            right--;
        }
        String string = String.valueOf(str);
        return string;
    }
    public void swap(char[] s, int left, int right){        
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
}
