package P11_HashMap;

public class Code05_BitMap {
    public static void main(String[] args) {
        int a = 0;
        // a 32 bit

        int [] arr = new int[10];//32 bit * 10 -> 320 bits

        int i = 178;//想获取178个bit的状态

        int numIndex = i/32;//找到应该去数组的哪个位置

        int bitIndex = i%32;//找到应该是该位置的第几个bit

        //拿到178位的状态s
        int s = ((arr[numIndex] >> (bitIndex)) & 1);


        //把178位状态改成1
        arr[numIndex] = arr[numIndex] | (1 << (bitIndex));


        i = 178;//把178位的状态变为0
        arr[numIndex] = arr[numIndex] & (~ (1 << bitIndex));
    }
}
