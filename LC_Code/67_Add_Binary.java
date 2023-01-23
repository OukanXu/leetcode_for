class Solution {
    public String addBinary(String a, String b) {
        if(a.length() > b.length()){
            int n = a.length() - b.length();
            String pre = new String();
            for(int i = 0; i < n; i++){
                pre+="0";
            }
            b = pre + b;
        }else{
            int n = b.length() - a.length();
            String pre = new String();
            for(int i = 0; i < n; i++){
                pre += "0";
            }
            a = pre + a;
        }

        int[] res = new int[a.length()];
        int cur = 0;
        for(int i = a.length()-1; i >= 0; i--){
            int aNum = a.charAt(i)-'0';
            int bNum = b.charAt(i)-'0';
            res[i] = (aNum+bNum+cur)%2;
            cur = (aNum+bNum+cur)/2;
        }
        
        String string = new String();
        for(int i = 0; i < res.length; i++){
            string += String.valueOf(res[i]);
        }

        //System.out.println(string);
        if(cur == 1){
            String pre = "1";
            
            return pre+string;
        }
        return string;
    }
}


//round 2
class Solution {
    public String addBinary(String a, String b) {
        int lengthA = a.length();
        int lengthB = b.length();

        if(lengthA < lengthB){
            return addBinary(b,a);
        }

        for(int i = 0; i < lengthA-lengthB; i++){
            b = '0' + b;
        }

        String res = new String();
        int carry = 0;
        for(int i = lengthA-1; i >= 0; i--){
            int temp = a.charAt(i)-'0' + b.charAt(i) - '0' + carry;
            carry = temp/2;
            temp = temp % 2;
            res = String.valueOf(temp) + res;
        }

        if(carry == 1){
            res = '1'+res;
        }
        return res;

    }
}


class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        for(int i = a.length()-1, j = b.length()-1; i >= 0 || j >= 0; i--,j--){
            int temp = 0;
            temp += i >= 0 ? a.charAt(i)-'0' : 0;
            temp += j >= 0 ? b.charAt(j)-'0' : 0;
            temp += carry;
            carry = temp/2;
            temp = temp % 2;

            res.append(String.valueOf(temp));
        }

        if(carry == 1){
            res.append('1');
        }
        return res.reverse().toString();
    }
}