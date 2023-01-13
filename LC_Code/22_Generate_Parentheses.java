class Solution {
    LinkedList<String> res = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        if(n == 0){
            return new LinkedList<>();
        }
        

        int left = n;
        int right = n;
        String str = "";
        dfs(str,left,right);
        return res;
    }

    public void dfs(String str, int left, int right){
        if(left < 0 || right < 0 || left > right){
            return;
        }
        if(left == 0 && right == 0){
            res.add(str);
        }

        str = str + '(';
        dfs(str,left-1,right);
        str = str.substring(0,str.length()-1);
        str = str + ')';
        dfs(str,left,right-1);
    }
}


//round 2
class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        String temp = "";

        dfs(list,temp,n,n,n);
        return list;
    }

    public void dfs(ArrayList<String> list,String temp,int left, int right, int n){
        if(left == 0 && right == 0){
            list.add(temp);
            return;
        }

        if(left == right){
            dfs(list,temp+'(',left-1,right,n);
        }

        if(left < right){
            if(left > 0){
                dfs(list,temp+'(',left-1,right,n);
            }
            dfs(list,temp+')',left,right-1,n);
        }

        return;
    }
}
