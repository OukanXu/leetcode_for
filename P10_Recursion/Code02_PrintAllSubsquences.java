package P10_Recursion;

import java.util.ArrayList;
import java.util.List;

public class Code02_PrintAllSubsquences {
    public static void function(String str){
        char[] chs = str.toCharArray();
        process(chs,0,new ArrayList<Character>());
    }


    //当前来到i位置，要和不要str[i]，走两条路
    //res：之前的选择所形成的列表
    public static void process(char[] str, int i, List<Character> res){
        if(i == str.length){
            printList(res);//打印
            return;
        }

        List<Character> resKeep = copyList(res);//深拷贝
        resKeep.add(str[i]);
        process(str, i+1, resKeep);//要的路
        List<Character> resNoInclude = copyList(res);
        process(str, i+1, resNoInclude);//不要的路
    }





    //改进方法 通过string的复用来节省空间
    public static void printAllSubsequence(String str){
        char[] chs = str.toCharArray();
        process1(chs,0);
    }

    public static void process1(char[] str, int i){
        if(i == str.length){
            System.out.println(String.valueOf(str));
            return;
        }
        process1(str,i+1);//要当前字符的路
        char temp = str[i];//记录当前字符
        str[i] = 0;//将当前字符变更为0
        process1(str,i+1);//不要当前字符的路
        str[i] = temp;//将当前字符还回去
    }
}
