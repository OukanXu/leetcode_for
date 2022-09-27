class Solution {
    public boolean isValid(String s) {
        if(s.length()%2 == 1){
            return false;
        }

        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        LinkedList<Character> stack = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            char head = s.charAt(i);
            if(map.containsKey(head)){
                if(stack.peek() == null){
                    return false;
                }else{
                    char stackHead  = stack.peek();
                    if(stackHead == map.get(head)){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
                
            }else{
                stack.push(head);
            }
            
        }

        return stack.isEmpty();
    }
}