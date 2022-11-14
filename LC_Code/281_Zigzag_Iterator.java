package LC_Code;

public class ZigzagIterator {

    List<Integer> res;
    int index;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        res = new ArrayList<>();

        int i = Math.min(v1.size(),v2.size())*2;
        if(i == 0){
            res.addAll(i == v1.size() ? v2 : v1);
        }else{
            int j = 0;
            while(j < i){
                res.add(v1.get(j/2));
                j++;
                res.add(v2.get(j/2));
                j++;
            }

            if(j == v1.size()*2){
                res.addAll(v2.subList(j/2,v2.size()));
            }else{
                res.addAll(v1.subList(j/2,v1.size()));
            }
        }
    }

    public int next() {
        return res.get(index++);
    }

    public boolean hasNext() {
        return index < res.size();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */



public class ZigzagIterator {
    List<Integer> res;
    int index;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        index = 0;
        res = new ArrayList<>();
        int l1 = 0;
        int l2 = 0;

        while(l1<v1.size() && l2 < v2.size()){
            res.add(v1.get(l1));
            l1++;
            res.add(v2.get(l2));
            l2++;
        }

        if(l1<v1.size()){
            for(int i = l1; i < v1.size(); i++){
                res.add(v1.get(i));
            }
        }

        if(l2 < v2.size()){
            for(int i = l2; i < v2.size(); i++){
                res.add(v2.get(i));
            }
        }
    }

    public int next() {
        return res.get(index++);
    }

    public boolean hasNext() {
        return index < res.size();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */