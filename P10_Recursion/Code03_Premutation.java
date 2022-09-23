package P10_Recursion;

import java.util.ArrayList;

public class Code03_Premutation {
    public static ArrayList<String> Premutation(String str){
        ArrayList<String> res = new ArrayList<>();
        if(str == null || str.length() == 0){
            return res;
        }

        char[] chs = str.toCharArray();
        process(chs,0,res);
        return res;
    }
    //str[i...]范围上，所有点字符都可以在i位置上
    //str[0...i-1]范围上，是之前做的选择
    public static void process(char[] str, int i, ArrayList<String> res){
        if(i == str.length){//如果字符串长度够了，说明已经一条分支到头，加入到结果
            res.add(String.valueOf(str));
        }
        boolean[] visited = new boolean[26];
        for(int j = i; j < str.length; j++){
            if(!visited[str[j] - 'a']){
                visited[str[j] - 'a'] = true;//去重
                swap(str,i,j);
                process(str,i+1,res);
                swap(str,i,j);
            }
            
        }
    } 
}
