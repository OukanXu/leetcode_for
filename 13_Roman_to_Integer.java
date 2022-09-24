
class Solution {
    public int romanToInt(String s) {
        if(s == ""){
            return 0;
        }


        //IV\IX\XL\XC\CD\CM
        //a \b \c \d \e \f 
        //4 \9 \40\90\400\900
        s = s.replace("IV","a");
        s = s.replace("IX","b");
        s = s.replace("XL","c");
        s = s.replace("XC","d");
        s = s.replace("CD","e");
        s = s.replace("CM","f");

        int i = 0;
        int num = 0;
        while(i < s.length()){
            switch(s.charAt(i)){
                case 'I':
                    num+=1;
                    break;
                case 'a':
                    num+=4;
                    break;
                case 'V':
                    num+=5;
                    break;
                case 'b':
                    num+=9;
                    break;
                case 'X':
                    num+=10;
                    break;
                case 'c':
                    num+=40;
                    break;
                case 'L':
                    num+=50;
                    break;
                case 'd':
                    num+=90;
                    break;
                case 'C':
                    num+=100;
                    break;
                case 'e':
                    num+=400;
                    break;
                case 'D':
                    num+=500;
                    break;
                case 'f':
                    num+=900;
                    break;
                case 'M':
                    num+=1000;
                    break;

            }
            i++;
        }
        return num;
    }
}