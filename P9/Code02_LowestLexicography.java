package P9;

import java.util.Arrays;
import java.util.Comparator;

public class Code02_LowestLexicography {
    
    public static class MyComparator implements Comparator<String>{
        @Override
        public int compare(String a, String b){
            return (a+b).compareTo(b+a);//比较字典序
        }
    }

    public static String lowestString(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }

        Arrays.sort(strs,new MyComparator());
        String res = "";
        for(int i = 0; i < strs.length; i++){
            res+=strs[i];
        }
        return res;
    }
}
