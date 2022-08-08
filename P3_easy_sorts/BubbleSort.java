package leetcode_for.P3_easy_sorts;
/*
 * 相邻两位对比，大的放在右侧，一次循环选择出最大的在最右侧
 */
public class BubbleSort {
    public static void bubble_sort(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            for(int j = 0; j< arr.length-1-i; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
