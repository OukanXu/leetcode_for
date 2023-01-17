
class Solution {
    public String countAndSay(int n) {
        String s1 = "1";

        for(int i = 2; i <= n; i++){
            StringBuilder str = new StringBuilder();

            int pos = 0;
            int start = 0;
            while(pos < s1.length()){
                while(pos < s1.length() && s1.charAt(pos) == s1.charAt(start)){
                    pos++;
                }
                str.append(Integer.toString(pos-start));
                str.append(s1.charAt(start));
                start = pos;
            }
            s1 = str.toString();
        }
        return s1;
    }
}


//round 2
class Solution {
    public String countAndSay(int n) {
        String res = "1";

        for(int i = 2; i <= n; i++){
            StringBuilder sb = new StringBuilder();
            int head = 0;
            int tail = head;
            int count = 0;
            while(tail < res.length()){
                while(tail < res.length() && res.charAt(head) == res.charAt(tail)){
                    tail++;
                    count++;
                }

                sb.append(String.valueOf(count));
                sb.append(res.charAt(head));
                head = tail;
                count = 0;
            }
            res = sb.toString();
        }
        return res;
    }
}
