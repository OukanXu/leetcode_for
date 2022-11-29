/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

 //方法二
public class NestedIterator implements Iterator<Integer> {
    private List<NestedInteger> list;
    private int size;
    private int index;
    private NestedIterator iterator;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.list = nestedList;
        size = list.size();
        index = 0;
        iterator = null;
    }

    @Override
    public Integer next() {
        NestedInteger n = list.get(index);
        if(n.isInteger()){
            index++;
            return n.getInteger();
        }else{
            return iterator.next();
        }
    }

    @Override
    public boolean hasNext() {
        while(index < size){
            NestedInteger temp = list.get(index);
            if(temp.isInteger()){
                return true;
            }else{
                if(iterator == null){
                    iterator = new NestedIterator(temp.getList());
                }
                
                if(iterator.hasNext()){
                    return true;
                }else{
                    iterator = null;
                    index++;
                }
            }
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */








 //方法一

 /**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private ArrayList<Integer> array;
    private int index;
    private int size;
    public NestedIterator(List<NestedInteger> nestedList) {
        array = new ArrayList<>();
        dfs(nestedList);
        index = 0;
        size = array.size();
    }

    @Override
    public Integer next() {
        return array.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < size;
    }

    public void dfs(List<NestedInteger> nestedList){
        for(NestedInteger n : nestedList){
            if(n.isInteger()){
                array.add(n.getInteger());
            }else{
                dfs(n.getList());
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */