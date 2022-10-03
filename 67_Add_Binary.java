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
