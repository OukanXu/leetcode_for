class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char preSign = '+';
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if(Character.isDigit(temp)){
                num = num*10 + (int)(temp-'0');
            }

            if(!Character.isDigit(temp) && s.charAt(i) != ' ' || i == s.length()-1){
                switch(preSign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '/':
                        stack.push(stack.pop()/num);
                        break;
                    case '*':
                        stack.push(stack.pop()*num);
                        break;
                }
                preSign = s.charAt(i);
                num = 0;

            }
            
        }

        while(!stack.isEmpty()){
            num += stack.pop();
        }
        return num;
    }
}