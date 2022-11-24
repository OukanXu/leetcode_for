class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }else{
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
        }

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(!stack.contains(s.charAt(i))){
                if(stack.isEmpty()){
                    stack.push(s.charAt(i));
                }else{
                    while(!stack.isEmpty() && s.charAt(i) < stack.peek() && map.get(stack.peek()) > 0){
                        stack.pop();   
                    }
                    stack.push(s.charAt(i));
                }
                
            }
            map.put(s.charAt(i),map.get(s.charAt(i))-1);
        }

        StringBuilder sb = new StringBuilder();

        for(Character c : stack){
            sb.append(c);
        }

        return sb.toString();
    }
}







class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lab = new int[26];
        boolean[] visited = new boolean[26];

        for(int i = 0; i < s.length(); i++){
            lab[s.charAt(i) - 'a'] = i;
        }

        Deque<Character> queue = new LinkedList<>();

        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if(!visited[temp-'a']){
                while(!queue.isEmpty() && temp < queue.getLast() && lab[queue.getLast()-'a'] > i){
                    visited[queue.getLast()-'a'] = false;
                    queue.pollLast();
                }
                queue.addLast(temp);
                visited[temp-'a'] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Character c : queue){
            sb.append(c);
        }
        return sb.toString();
    }
}