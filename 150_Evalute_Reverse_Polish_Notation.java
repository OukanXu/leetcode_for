class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();

        for(int i = 0; i < tokens.length; i++){
            if(isNumber(tokens[i])){
                stack.push(Integer.parseInt(tokens[i]));
            }else{
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch(tokens[i]){
                    case "+":
                        stack.push(num1+num2);
                        break;
                    case "-":
                        stack.push(num2-num1);
                        break;
                    case "*":
                        stack.push(num2*num1);
                        break;
                    case "/":
                        stack.push(num2/num1);
                        break;
                }
            }
        }
        return stack.pop();



    }

    public boolean isNumber(String s){

        return !("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s));
        
    }
}
