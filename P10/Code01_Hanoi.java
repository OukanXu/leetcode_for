package P10;

public class Code01_Hanoi {
    public static void hanoi(int n){
        if(n > 0){
            func(n,"左","右","中");
        }
    }

    //1~i 圆盘目标是from->to, other 是另外一个
    public static void func(int i, String start, String end, String other){
        if(i == 1){
            System.out.println("Move 1 from " + start + " to " + end);
        }else{
            func(i-1, start, other, end);//1~i-1 从start出发，移动到other，借助的第三方是end
            System.out.println("Move" + i + " from " + start + " to " + end);
            func(i-1, other, end, start);//1~i-1 从other出发，移动到end，借助第三方是start
        }
    }
}
