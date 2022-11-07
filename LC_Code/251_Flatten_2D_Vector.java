package LC_Code;

class Vector2D {
    private ArrayList<Integer> res;
    private int index;
    public Vector2D(int[][] vec) {
        res = new ArrayList<>();
        for(int i = 0; i < vec.length; i++){
            for(int j = 0; j < vec[i].length; j++){
                res.add(vec[i][j]);
            }
        }
        index = 0;
    }
    
    public int next() {
        return res.get(index++);
    }
    
    public boolean hasNext() {
        return index < res.size();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
