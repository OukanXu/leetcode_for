/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

 class Solution {
    public NestedInteger deserialize(String s) {
        if(s.charAt(0) != '['){
            NestedInteger temp = new NestedInteger(Integer.parseInt(s));
            return temp;
        }



        Deque<NestedInteger> dp = new LinkedList<>();

        int index = 0;
        int length = s.length();
        int count = 0;
        int flag = 1;
        while(index < length){
            if(s.charAt(index) == '['){
                dp.push(new NestedInteger());// important
            }else if(s.charAt(index) - '0' >= 0 && s.charAt(index)-'0' <= 9){
                count = count*10 + s.charAt(index)-'0';
            }else if(s.charAt(index) == '-' ){
                flag = -1;
            }else if(s.charAt(index) == ',' || s.charAt(index) == ']'){
                if(Character.isDigit(s.charAt(index-1))){
                    count = count * flag;
                    dp.peek().add(new NestedInteger(count));//important
                    count = 0;
                    flag = 1;
                }
                if(s.charAt(index) == ']' && dp.size() > 1){//important
                    NestedInteger ni = dp.pop();
                    dp.peek().add(ni);
                }
            }
            index++;
        }
        return dp.peek();
    }
}
